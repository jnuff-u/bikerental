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
 * @ClassName Admin
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 18:48
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {

    private static final long serialVersionUID = -5464257962870805213L;

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

    @Getter(onMethod_= {@Column(name = "user_display_name")})
    private String userDisplayName;

    @Getter(onMethod_= {@Column(name = "user_head_ico")})
    private String userHeadIco;

    @Getter(onMethod_= {@Column(name = "username",unique = true)})
    private String username;

    @Getter(onMethod_= {@Column(name = "password")})
    private String password;

    @Getter(onMethod_= {@Column(name = "email")})
    private String email;

    @Getter(onMethod_= {@Column(name = "role_id")})
    private Integer roleId;

    @Getter(onMethod_= {@Column(name = "status")})
    private Integer status;

    @Getter(onMethod_= {@Column(name = "login_last")})
    private Date loginLast;

}
