package com.service.impl;

import com.model.pojo.Admin;
import com.repository.AdminRepository;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/4 0004 15:41
 **/
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin findByName(String userName){
     return adminRepository.findByName(userName);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Long insert(Admin admin) {
        return adminRepository.insert(admin);
    }

    @Override
    public int update(Admin admin) {
        return adminRepository.update(admin);
    }

    @Override
    public int delete(Long id) {
        return adminRepository.delete(id);
    }
}
