package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.greatgump.crm.dto.power.UserDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClueQueryDto {
    @ApiModelProperty("自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("客户名称")
    @TableField("username")
    private CustomerDto customerDto;

    @ApiModelProperty("归属人员")
    @TableField("personnel")
    private UserDto personnel;

    @ApiModelProperty("联系人")
    @TableField("contacts")
    private UserDto contacts;

    @ApiModelProperty("号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("最后跟进")
    @TableField("last_follow")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lastFollow;

    @ApiModelProperty("未跟进天数")
    @TableField("not_follow_days")
    private Integer notFollowDays;

    @ApiModelProperty("线索状态（0表示表示下次邀约，1表示已转客户，2表示初步意向）")
    @TableField("clue_status")
    private Integer clueStatus;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删（0表示未删，1表示删除）")
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;

}
