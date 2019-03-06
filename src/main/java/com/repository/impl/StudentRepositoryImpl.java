package com.repository.impl;

import com.model.pojo.Student;
import com.repository.StudentRepository;
import com.utils.HqlUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName StudentRepositoryImpl
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 22:28
 * @Version 1.0
 **/
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Logger log = LogManager.getLogger(StudentRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HqlUtil hqlUtil;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Student findById(Long id) {
        return getSession().get(Student.class,id);
    }

    public List<Student> findByLike(Long createAt,
                                    Long updateAt,
                                    Long createBy,
                                    Long updateBy,
                                    String studentNum,
                                    String username,
                                    String email,
                                    String tell ,
                                    Integer status,
                                    String orderBy){

        if (createAt == null && updateAt == null && createBy == null && updateBy == null && studentNum == null && username == null && email == null && tell == null ){
            return null;
        }

        String hql = hqlUtil.getSql("hql.student.findByLike");

        StringBuffer sb = new StringBuffer("");
        if (createAt!=null) {
            sb.append(" createAt like %" + createAt + "% ");
        }else if(updateAt!=null){
            sb.append(" updateAt like %" + updateAt + "% ");
        }else if(createBy!=null){
            sb.append(" createBy like %" + createBy + "% ");
        }else if(updateBy!=null){
            sb.append(" updateBy like %" + updateBy + "% ");
        }else if(studentNum!=null){
            sb.append(" studentNum like %" + studentNum + "% ");
        }else if(username!=null){
            sb.append(" username like %" + username + "% ");
        }else if(email!=null){
            sb.append(" email like %" + email + "% ");
        }else if(tell!=null){
            sb.append(" tell like %" + tell + "% ");
        }else if(status!=null ){
            sb.append(" status = " + status + " ");
        }

        hql += " WHERE " + sb.toString();

        if (orderBy!=null && !orderBy.isEmpty()){
            hql += " ORDER BY " + orderBy;
        }

        Query query = getSession().createQuery(hql);

        return query.list();

    }


    @Override
    public List<Student> findAll(){

        Query query = getSession().createQuery(hqlUtil.getSql("hql.student.findAll"));

        List<Student> students = (List<Student>)query.list();

        return students;
    }



    @Override
    public void insert(Student student) {
        getSession().save(student);
    }

    @Override
    public void update(Student student) {
        getSession().update(student);
    }

    @Override
    public void delete(Long id) {
        getSession().delete(id);
    }




}
