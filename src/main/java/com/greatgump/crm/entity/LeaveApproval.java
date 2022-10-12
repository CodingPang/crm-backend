package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_leave_approval")
@ApiModel(value = "LeaveApproval对象", description = "")
public class LeaveApproval implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增,主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("请假类型")
    @TableField("leave_type")
    private String leaveType;

    @ApiModelProperty("提交人员")
    @TableField("submit_personnel")
    private String submitPersonnel;

    @ApiModelProperty("请假原因")
    @TableField("leave_reason")
    private String leaveReason;

    @ApiModelProperty("请假天数")
    @TableField("leave_Days")
    private Integer leaveDays;

    @ApiModelProperty("审批状态(0表示已驳回,1表示已通过,2表示待审批)")
    @TableField("approval_status")
    private Integer approvalStatus;

    @ApiModelProperty("提交时间")
    @TableField("submission_time")
    private Date submissionTime;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删(0表示未删,1表示删除)")
    @TableField("is_delete")
    private Integer isDelete;


}
