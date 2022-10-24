package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.greatgump.crm.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClueDto {
    @ApiModelProperty("自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("客户名称")
    @TableField("username")
    private String username;

    @ApiModelProperty("归属人员")
    @TableField("personnel")
    private User personnel;

    @ApiModelProperty("联系人")
    @TableField("contacts")
    private String contactss;

    @ApiModelProperty("号码")
    private String phone;

    @ApiModelProperty("最后跟进")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lastFollow;

    @ApiModelProperty("未跟进天数")
    private Integer notFollowDays;

    @ApiModelProperty("线索归属")
    private User clue;

    @ApiModelProperty("线索来源")
    private Source source;

    @ApiModelProperty("线索状态")
    private Integer status;

    @ApiModelProperty("客户需求")
    private String customerNeeds;

    @ApiModelProperty("联系人")
    private String contacts;

    @ApiModelProperty("电子邮箱")
    private String eMail;


    @ApiModelProperty("QQ号码")
    @TableField("qq")
    private String qq;

    @ApiModelProperty("部门职务(外键，部门表)")
    private String deptId;

    @ApiModelProperty("微信账号")
    private String wechat;














//    @ApiModelProperty("线索归属")
//    private Clue clue;
//
//    @ApiModelProperty("线索来源")
//    private FollowForm source;
//
//    @ApiModelProperty("线索状态")
//    private FollowForm status;
//
//    @ApiModelProperty("客户需求")
//    private String customerNeeds;
//
//    @ApiModelProperty("客户名称")
//    @TableField("username")
//    private String username;
//
//    @ApiModelProperty("归属人员")
//    @TableField("personnel")
//    private User personnel;
//
//    @ApiModelProperty("联系人")
//    @TableField("contacts")
//    private String contactss;
//
//    @ApiModelProperty("号码")
//    @TableField("phone")
//    private String phone;
//
//    @ApiModelProperty("QQ号码")
//    @TableField("qq")
//    private String qq;
//
//    @ApiModelProperty("微信账号")
//    @TableField("wechat")
//    private String wechat;
//
//    @ApiModelProperty("电子邮箱")
//    @TableField("e_mail")
//    private String eMail;
//
//    @ApiModelProperty("部门职务(外键，部门表)")
//    @TableField("dept_id")
//    private String deptId;
//
//
//
//    @ApiModelProperty("最后跟进")
//    @TableField("last_follow")
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
//    private Date lastFollow;
//
//    @ApiModelProperty("未跟进天数")
//    @TableField("not_follow_days")
//    private Integer notFollowDays;
//
//    @ApiModelProperty("线索状态（0表示表示下次邀约，1表示已转客户，2表示初步意向）")
//    @TableField("clue_status")
//    private Integer clueStatus;
//
//    @ApiModelProperty("备注")
//    @TableField("remark")
//    private String remark;
//
//    @ApiModelProperty("假删（0表示未删，1表示删除）")
//    @TableField("is_delete")
//    private Integer isDelete;


}
