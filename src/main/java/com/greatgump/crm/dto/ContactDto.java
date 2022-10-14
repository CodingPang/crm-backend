package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 企业联系人表
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("客户名称")
    private String customerName;

    @ApiModelProperty("联系人名称")
    private String contactName;

    @ApiModelProperty("邮箱")
    private String mail;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("QQ")
    private String qq;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("微信")
    private String wechat;




}
