package com.greatgump.crm.dto.businessDto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class BusinessSourceDto {
    @ApiModelProperty("id")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField("contactss")
    @ApiModelProperty("首联系人")
    private String contactss;
    @TableField("e_mail")
    @ApiModelProperty("电子邮箱")
    private String eMail;
    @ApiModelProperty("联系号码")
    @TableField("phone")
    private String phone;
    @ApiModelProperty("QQ号码")
    @TableField("qq")
    private String qq;
    @ApiModelProperty("部门职务")
    @TableField("dept_id")
    private Integer deptId;
    @TableField("wechat")
    @ApiModelProperty("微信账号")
    private String wechat;
    @ApiModelProperty("商机标题")
    @TableField("business_name")
    private String businessTitle;
    @ApiModelProperty("商机归属")
    @TableField("user_id")
    private Integer userId;
    @ApiModelProperty("商机来源")
    @TableField("business_origin")
    private String businessOrigin;
    @ApiModelProperty("商机阶段")
    @TableField("business_stage")
    private String businessStage;
    @ApiModelProperty("关联客户")
    @TableField("customer_id")
    private Integer customerId;
    @ApiModelProperty("预计收益")
    @TableField("estimated_income")
    private BigDecimal estimatedIncome;
    @ApiModelProperty("备注信息")
    @TableField("customer_needs")
    private String customerNeeds;
}
