package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Accessors(chain = true)
public class FollowFormAllDto {
//    private static final long serialVersionUID = 1L;
//    @ApiModelProperty("主键，自增")
////    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

//    @ApiModelProperty("联系人")
//    @TableField("contactss")
    private String contactss;

//    @ApiModelProperty("电子邮箱")
//    @TableField("e_mail")
    private String eMail;
//
//    @ApiModelProperty("联系号码")
//    @TableField("phone")
    private String phone;
//
//    @ApiModelProperty("QQ号码")
//    @TableField("qq")
    private String qq;

//    @ApiModelProperty("部门职务(外键，部门表)")
//    @TableField("dept_id")
    private String deptId;

//    @ApiModelProperty("微信账号")
//    @TableField("wechat")
    private String wechat;

//    @ApiModelProperty("客户需求")
//    @TableField("customer_needs")
    private String customerNeeds;

//    @ApiModelProperty("状态(0初步意向 1下次邀约 2已转客户 4商机未成交  5商机成交)")
//    @TableField("status")
    private String status;

//    @ApiModelProperty(" 跟进类型(标识跟进的方式 是 0-线索  1-商机  2-客户)")
//    @TableField("follow_type")
    private String followType;

//    @ApiModelProperty("跟进来源(关联线索来源表)")
//    @TableField("follow_source")
    private String followSource;
//
//    @ApiModelProperty("归属客户(关联用户表的id)")
//    @TableField("user_id")
    private Long userId;
//
//    @ApiModelProperty("客户的id (关联客户表的id)")
//    @TableField("customer_id")
    private Long customerId;

//    @ApiModelProperty("当前的服务器时间")
//    @TableField("current_time")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date currentTime;

//    @ApiModelProperty("商机标题")
//    @TableField("business_name")
    private String businessName;
//
//    @ApiModelProperty("客户名字")
//    @TableField("customer_name")
    private String customerName;

//    @ApiModelProperty("商机阶段（0表示首次拜访，1表示方案展示，2表示产品报价，3表示合同签订）")
//    @TableField("business_stage")
    private String businessStage;

//    @ApiModelProperty("预计收益")
//    @TableField("estimated_income")
    private BigDecimal estimatedIncome;
//
//    @ApiModelProperty("报价记录")
//    @TableField("offerlog")
    private BigDecimal offerlog;

//    @ApiModelProperty("备注")
//    @TableField("remark")
    private String remark;
}
