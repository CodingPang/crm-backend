package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_management")
@ApiModel(value = "Management对象", description = "跟进管理")
public class ManagementDot {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("跟进内容")
    @TableField("follow_content")
    private String followContent;

    @ApiModelProperty("跟进时间")
    @TableField("follow_time")
    private Date followTime;

    @ApiModelProperty("关联客户")
    @TableField(value = "customer_name")
    private String customerName;

    @ApiModelProperty("负责人员")
    @TableField("person_charge")
    private String personCharge;

    @ApiModelProperty("跟进类型")
    @TableField("follow_type")
    private String followType;

    @ApiModelProperty("跟进方式")
    @TableField("follow_method")
    private String followMethod;

    @ApiModelProperty("联系人员")
    @TableField("contact_personnel")
    private String contactPersonnel;

    @ApiModelProperty("联系号码")
    @TableField("contact_number")
    private String contactNumber;

    @ApiModelProperty("创建时间")
    @TableField("creation_time")
    private Date creationTime;

//    @ApiModelProperty("备注")
//    @TableField("remark")
//    private String remark;
//
//    @ApiModelProperty("假删（0表示未删，1表示删除）")
//    @TableField("is_delete")
//    private Integer isDelete;

}
