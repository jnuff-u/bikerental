package com.repository.impl;

import com.model.pojo.Admin;
import com.repository.AdminRepository;
import com.utils.HqlUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName AdminRepository
 * @Description TODO
 * @Author ZQ
 * @Date 2019/3/4 0004 15:38
 **/
@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private static Logger log = LogManager.getLogger(StudentRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HqlUtil hqlUtil;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    private EntityManager getEntityManager(){
        return sessionFactory.createEntityManager();
    }

    @Override
    public Admin findById(Long id) {
        return getSession().get(Admin.class,id);
    }

    @Override
    public Admin findByName(String userName){
        Admin admin = null;
        Query<Admin> query = getSession().createQuery(hqlUtil.getSql("hql.admin.findByName"),Admin.class).setParameter("username",userName);
        Iterator<Admin> iterator = query.iterate();
        while (iterator.hasNext()){
            admin = iterator.next();
        }
        return admin;
    }

    @Override
    public Admin findByEmail(String email){
        Admin admin = null;
        Query<Admin> query = getSession().createQuery(hqlUtil.getSql("hql.admin.findByEmail"),Admin.class).setParameter("email",email);
        try {
            admin = query.getSingleResult();
        }catch (NoResultException n){
            n.fillInStackTrace();
            log.info(" Email {} Not found ", email);
        }
        return admin;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Long insert(Admin admin) {
        return (Long) getSession().save(admin);
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

}
