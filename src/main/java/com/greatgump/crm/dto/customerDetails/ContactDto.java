package com.greatgump.crm.dto.customerDetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "Clue对象", description = "线索管理")
public class ContactDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("联系人")
    private String contactName;

    @ApiModelProperty("联系电话")
    private String phone;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("电子邮箱")
    private String mail;

    @ApiModelProperty("qq")
    private String qq;

    @ApiModelProperty("微信电话")
    private String wechat;

}
