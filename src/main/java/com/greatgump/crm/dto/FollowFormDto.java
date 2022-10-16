package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowFormDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    private Long id;

    @ApiModelProperty("联系人")
    private String contactss;

    @ApiModelProperty("电子邮箱")
    private String eMail;

    @ApiModelProperty("联系号码")
    private String phone;

    @ApiModelProperty("QQ号码")
    private String qq;

    @ApiModelProperty("部门职务(外键，部门表)")
    private String deptId;

    @ApiModelProperty("微信账号")
    private String wechat;
}
