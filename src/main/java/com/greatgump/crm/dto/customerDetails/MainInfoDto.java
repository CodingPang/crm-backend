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
public class MainInfoDto {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("客户名称")
    private String customerName;

    @ApiModelProperty("客户归属")
    private String user;

    @ApiModelProperty("客户类别")
    private String type;

    @ApiModelProperty("客户行业")
    private String industry;

    @ApiModelProperty("所在城市")
    private String city;

    @ApiModelProperty("客户行业")
    private String scale;

    @ApiModelProperty("客户来源")
    private String source;

    @ApiModelProperty("联系人id")
    private Integer contactId;

    @ApiModelProperty("联系人")
    private String contactName;

    @ApiModelProperty("电子邮箱")
    private String eMail;

    @ApiModelProperty("联系号码")
    private String phone;

    @ApiModelProperty("QQ号码")
    private String qq;

    @ApiModelProperty("部门职务(外键，部门表)")
    private String dept;

    @ApiModelProperty("微信账号")
    private String wechat;
}
