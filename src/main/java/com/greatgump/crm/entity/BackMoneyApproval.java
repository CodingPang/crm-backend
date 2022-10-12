package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 回款审批
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_collection")
@ApiModel(value = "Collection对象", description = "回款审批")
public class BackMoneyApproval implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("系统编号")
    @TableField("number")
    private String number;

    @ApiModelProperty("关联订单")
    @TableField("associated_order")
    private String associatedOrder;

    @ApiModelProperty("回款期次")
    @TableField("collection_period")
    private String collectionPeriod;

    @ApiModelProperty("回款金额")
    @TableField("collection_amount")
    private BigDecimal collectionAmount;

    @ApiModelProperty("回款日期")
    @TableField("collection_date")
    private Date collectionDate;

    @ApiModelProperty("审批状态（0表示已驳回，1表示待审批，2表示已通过）")
    @TableField("approval_status")
    private String approvalStatus;

    @ApiModelProperty("提交时间")
    @TableField("submission_time")
    private Date submissionTime;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删（0表示未删，1表示删除）")
    @TableField("is_delete")
    private Integer isDelete;


}
