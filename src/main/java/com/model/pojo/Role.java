package com.model.pojo;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName Role
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 18:49
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 5196597254245093264L;

    @Getter(onMethod_={@GenericGenerator(name = "generator", strategy = "uuid.hex"),@Id,@GeneratedValue(generator = "generator"),
            @Column(name = "id", unique = true)})
    private Long id;

    @Getter(onMethod_= {@Column(name = "admin_id")})
    private Long adminId;

    @Getter(onMethod_= {@Column(name = "role_name")})
    private String roleName;

    @Getter(onMethod_= {@Column(name = "auth")})
    private Integer auth;

}
