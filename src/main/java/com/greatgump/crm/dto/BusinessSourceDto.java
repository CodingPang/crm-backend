package com.greatgump.crm.dto;

import com.greatgump.crm.entity.DataDictionary;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//商机来源
@NoArgsConstructor
//@AllArgsConstructor
@Data
@AllArgsConstructor
public class BusinessSourceDto {
    @ApiModelProperty("商机标题")
    private String businessTitle;
    @ApiModelProperty("商机归属")
    private String businessAscription;
    @ApiModelProperty("商机来源")
    private String businessOrigin;
    @ApiModelProperty("商机阶段")
    private String businessStage;
    @ApiModelProperty("关联客户")
    private String businessCustomer;
    @ApiModelProperty("预计收益")
    private BigDecimal estimatedIncome;
    @ApiModelProperty("备注信息")
    private String customerNeeds;
    @ApiModelProperty("首联系人")
    private String contactss;
    @ApiModelProperty("电子邮箱")
    private String eMail;
    @ApiModelProperty("联系号码")
    private String phone;
    @ApiModelProperty("QQ号码")
    private String qq;
    @ApiModelProperty("部门职务")
    private String deptName;
    @ApiModelProperty("微信账号")
    private String wechat;
//    private DataDictionary
}
