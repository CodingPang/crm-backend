package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderListDto {

    private Long id;


    private String orderNo;


    private String orderTitle;


    private String customer;


    private String sale;


    private String business;



    private String product;

    private BigDecimal oderTotal;


    private String oderStatus;


    private String uploadAttachment;


    private Integer payMethods;


    private String orderContract;


    private String ownerSigner;


    private String ownerSignerPhone;


    private String faceSigner;


    private String faceSignerPhone;


    private String orderDate;


    private BigDecimal totalRes;


    private BigDecimal totalTicket;


    private String remark;

    private Long cutomerId;


}
