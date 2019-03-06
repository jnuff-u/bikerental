package com.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author  ZhangQiang
 * @Date 2019/2/21 0021 17:24
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{

    private static final long serialVersionUID = -1924117556035806407L;

    @Getter(onMethod_={@GenericGenerator(name = "generator", strategy = "native"),@Id,@GeneratedValue(generator = "generator"),
            @Column(name = "id", unique = true)})
    private Long id;

    @Getter(onMethod_= {@Column(name = "create_at")})
    private Date createAt;

    @Getter(onMethod_= {@Column(name = "update_at")})
    private Date updateAt;

    @Getter(onMethod_= {@Column(name = "create_by")})
    private Long createBy;

    @Getter(onMethod_= {@Column(name = "update_by")})
    private Long updateBy;

    @Getter(onMethod_= {@Column(name = "student_num")})
    private String studentNum;

    @Getter(onMethod_= {@Column(name = "username")})
    private String username;

    @Getter(onMethod_= {@Column(name = "password")})
    private String password;

    @Getter(onMethod_= {@Column(name = "email")})
    private String email;

    @Getter(onMethod_= {@Column(name = "tell")})
    private String tell;

    @Getter(onMethod_= {@Column(name = "status")})
    private Integer status;
}
