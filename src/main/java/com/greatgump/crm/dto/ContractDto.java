package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {

    private Long id;


    private String contractNum;

    private Date signingDate;

    private String contractName;

    private String customerName;

    private String ourSignatory;

    private String yourSignatory;


    private BigDecimal contractAmount;


    private String saler;


    private String contacts;


    private String contracUrl;


    private String contactsPhone;

    private String payMethod;


    private Date payDate;


    private String remake;


}
