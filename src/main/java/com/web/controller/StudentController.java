package com.web.controller;

import com.model.dto.JsonResult;
import com.model.dto.Page;
import com.model.enums.ResultCodeEnum;
import com.model.pojo.Student;
import com.service.StudentService;
import com.utils.LocalMessageUtil;
import com.utils.PageUTil;
import com.utils.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/22 0022 17:34
 * @Version 1.0
 **/
@Controller
public class StudentController {

    private static Logger log = LogManager.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    LocalMessageUtil localMessageUtil;

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public String students(@RequestParam(value = "nowPage",defaultValue = "1")Integer nowPage,
                           @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, Model model){

        List<Student> students = studentService.findAll();

        JsonResult jsonResult = new JsonResult(ResultCodeEnum.SUCCESS.getStatCode(),localMessageUtil.getMessage("code.admin.common.save-success"));
        PageUTil<Student> pageUtil = new PageUTil();

        Page<Student> pages = pageUtil.getPage(nowPage,pageSize,students);

        model.addAttribute("pages",pages);
        model.addAttribute("jsonResult",jsonResult);

        return "/students";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String addStudent(HttpServletResponse response, HttpServletRequest request,Model model, Student student){

        log.fatal(" 添加学生 ：" + student.toString());

        student.setCreateAt(new Date());
        student.setUpdateAt(new Date());

        studentService.insert(student);

        JsonResult jsonResult = new JsonResult(ResultCodeEnum.SUCCESS.getStatCode(),localMessageUtil.getMessage("code.admin.common.save-success"));

        model.addAttribute("jsonResult",jsonResult);

        return "redirect:/students";
    }



}
