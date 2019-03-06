package com.model.pojo;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Bike
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 18:40
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "bike")
public class Bike implements Serializable {
    private static final long serialVersionUID = -5723498934211299584L;

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

    @Getter(onMethod_= {@Column(name = "bike_num")})
    private String bikeNum;

    @Getter(onMethod_= {@Column(name = "img")})
    private String img;

    @Getter(onMethod_= {@Column(name = "rent")})
    private String rent;

    @Getter(onMethod_= {@Column(name = "deposit")})
    private String deposit;

    @Getter(onMethod_= {@Column(name = "sort")})
    private Integer sort;

    @Getter(onMethod_= {@Column(name = "QR_code")})
    private String QRCode;

    @Getter(onMethod_= {@Column(name = "status")})
    private Integer status;

    @Getter(onMethod_= {@Column(name = "remark")})
    private String remark;

}
