package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.entity.Dept;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BusinessCustomerDto {
    @ApiModelProperty("联系人")
    @TableField("contactss")
    private String contactss;

    @ApiModelProperty("电子邮箱")
    @TableField("e_mail")
    private String eMail;

    @ApiModelProperty("联系号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("QQ号码")
    @TableField("qq")
    private String qq;

    @ApiModelProperty("部门职务(外键，部门表)")
    @TableField("dept_id")
    private Dept deptId;

    @ApiModelProperty("微信账号")
    @TableField("wechat")
    private String wechat;
}
