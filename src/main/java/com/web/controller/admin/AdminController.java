package com.web.controller.admin;

import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.digest.DigestUtil;
import com.model.dto.Const;
import com.model.dto.JsonResult;
import com.model.enums.ResponseStatusEnum;
import com.model.enums.ResultCodeEnum;
import com.model.pojo.Admin;
import com.service.AdminService;
import com.service.StudentService;
import com.utils.LocaleMessageUtil;
import com.utils.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/3 0003 11:15
 **/
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static Logger log = LogManager.getLogger(AdminController.class);

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    LocaleMessageUtil localeMessageUtil;


    /**
     * @Description //TODO 后台首页跳转
     *
     * @param
     * @return java.lang.String
     **/
    @GetMapping(value = {"","index"})
    public String index(){
        System.out.println("跳转到首页——index");
        return "admin/admin_index";
    }

    /**
     * @Description //TODO 处理用户跳转到登录页面的请求
     * @Date 14:48 2019/3/4 0004
     * @Param
     * @return
     **/
    @RequestMapping(value = "/login")
    public String login(HttpSession session){
        final Admin user = (Admin) session.getAttribute(Const.USER_SESSION_KEY);
        if (null != user) {
            System.out.println("跳转到首页");
            return "redirect:/admin";
        }
        System.out.println("跳转到登录页");
        return "admin/admin_login";
    }

    /**
     * @Description //TODO 登录验证 邮箱/方法
     * @Date 19:12 2019/3/4 0004
     * @Param [loginName, loginPwd, session]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginName") String loginName,
                        @ModelAttribute("loginPwd") String loginPwd,
                        HttpSession session, Model model){
        Admin user ;

        if (Validator.isEmail(loginName)){
            user = adminService.findByEmail(loginName);
        } else {
            user = adminService.findByName(loginName);
        }

        if(null == user){
            session.setAttribute(Const.USER_SESSION_KEY,user);
            model.addAttribute("jsonResult",new JsonResult(ResultCodeEnum.FAIL.getStatCode(),ResponseStatusEnum.EMPTY.getMsg()));
            log.info("User login failed,{}",ResponseStatusEnum.EMPTY.getMsg());
            return "redirect:/admin/login";
        } else {
            session.setAttribute(Const.USER_SESSION_KEY,user);
            model.addAttribute("jsonResult",new JsonResult(ResultCodeEnum.SUCCESS.getStatCode(), localeMessageUtil.getMessage("code.admin.login.success")));
            log.info("User {} login success",user.getUsername());
            return "redirect:/admin/list";
        }

    }


    /**
     * @Description //TODO 用户登出 -> 跳转到登录页面
     * @Date 15:25 2019/3/4 0004
     * @Param [session]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session){
        final Admin user = (Admin) session.getAttribute(Const.USER_SESSION_KEY);
        session.removeAttribute(Const.USER_SESSION_KEY);
        log.info("User {} has logged out",user.getUsername());

        return "redirect:/admin/login";
    }

    /**
     * @Description //TODO 注册跳转
     *
     * @param
     * @return java.lang.String
     **/
    @RequestMapping(value = "/reg")
    public String reg(){
        return "admin/admin_reg";
    }

    /**
     * @Description //TODO 用户注册
     * @Date 16:09 2019/3/4 0004
     * @Param [userName, password, model, session]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@RequestParam(value = "userName")String userName,
                      @RequestParam(value = "password")String password,
                      @RequestParam(value = "email")String email, Model model, HttpSession session){
            log.info("注册信息： " + userName + " : " + password + " : " + email);

        if (adminService.findByEmail(email) != null && !email.equals("") ){
            log.info("已存在邮箱");
            model.addAttribute("jsonResult",new JsonResult(ResultCodeEnum.FAIL.getStatCode(),localeMessageUtil.getMessage("reg.existing.userName")));
            return "/admin/admin_reg";
        }
        if (adminService.findByName(userName) != null && !userName.equals("") ){
            log.info("已存在用户名");
            model.addAttribute("jsonResult",new JsonResult(ResultCodeEnum.FAIL.getStatCode(),localeMessageUtil.getMessage("reg.existing.userEmail")));
            return "/admin/admin_reg";
        }

        Admin admin = new Admin();
        admin.setCreateAt(new Date());
        admin.setUpdateAt(new Date());
        admin.setUsername(userName);
        admin.setEmail(email);
        password = DigestUtil.md5Hex(password + SecurityUtil.getSult()).toString();
        admin.setPassword(password);
        Long s = adminService.insert(admin);
        if ( 0 != s){
            log.info("用户注册成功");
            model.addAttribute("jsonResult",new JsonResult(ResultCodeEnum.SUCCESS.getStatCode(), localeMessageUtil.getMessage("ret.seccess.message ")));
        }

        return "redirect:/admin/login";
    }





}
