package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderContextDto {
    private Long id;


    private String orderTitle;


    private String orderOwner;


    private String orderCustomer;


    private String orderOpp;





    private String total;


    private String fujian;


    private String payMethod;


    private String yourSigh;


    private String ourSigh;


    private String phone;


    private Date sighdate;




}
