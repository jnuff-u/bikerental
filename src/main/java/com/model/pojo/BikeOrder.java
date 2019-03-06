package com.model.pojo;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BikeOrder
 * @Description TODO
 * @Author ZhangQiang
 * @Date 2019/2/21 0021 18:51
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "bike_order")
public class BikeOrder implements Serializable {
    private static final long serialVersionUID = -2212918268060773382L;
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

    @Getter(onMethod_= {@Column(name = "order_num")})
    private String orderNum;

    @Getter(onMethod_= {@Column(name = "order_amount")})
    private String orderAmount;

    @Getter(onMethod_= {@Column(name = "lease")})
    private String lease;

    @Getter(onMethod_= {@Column(name = "tell")})
    private String tell;

    @Getter(onMethod_= {@Column(name = "status")})
    private Integer status;
}
