package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.entity.Source;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClueReceiveDto {
    @ApiModelProperty(value = "id",hidden = true)
    private long id;

    @ApiModelProperty(value = "联系人id",hidden = true)
    private Long contactId;

    @ApiModelProperty("客户名称")
    private String customerName;

    @ApiModelProperty("客户名称")
    private Long customerId;

    @ApiModelProperty("线索归属")
    private Long userId;

    @ApiModelProperty("线索来源")
    private Integer sourceId;

    @ApiModelProperty("线索状态")
    private Integer status;

    @ApiModelProperty("客户需求")
    private String customerNeeds;

    @ApiModelProperty("联系人")
    private String contacts;

    @ApiModelProperty("电子邮箱")
    private String eMail;

    @ApiModelProperty("联系号码")
    private String phone;

    @ApiModelProperty("QQ号码")
    private String qq;

    @ApiModelProperty("部门职务(外键，部门表)")
    private Integer deptId;

    @ApiModelProperty("微信账号")
    private String wechat;

    @ApiModelProperty(value = "最近跟进时间",hidden = true)
    private Date lastTime;

    @ApiModelProperty(value = "线索表id",hidden = true)
    private Long followFormId;


}
