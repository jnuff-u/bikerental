package com.model.pojo;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Common
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 18:54
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "common")
public class Common implements Serializable {
    private static final long serialVersionUID = 390869974426564488L;
    @Getter(onMethod_={@GenericGenerator(name = "generator", strategy = "uuid.hex"),@Id,@GeneratedValue(generator = "generator"),
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

    @Getter(onMethod_= {@Column(name = "student_id")})
    private Long studentId;

    @Getter(onMethod_= {@Column(name = "order_id")})
    private Long orderId;

    @Getter(onMethod_= {@Column(name = "info")})
    private String info;
}
