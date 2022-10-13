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
 * 借款表
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_loan")
@ApiModel(value = "Loan对象", description = "借款表")
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联业务")
    @TableField("associated_business")
    private Customer associatedBusiness;

    @ApiModelProperty("借款金额")
    @TableField("loan_amount")
    private BigDecimal loanAmount;

    @ApiModelProperty("借款原因")
    @TableField("cause")
    private String cause;

    @ApiModelProperty("审批状态（1表示已通过，2表示待审批，0表示已驳回）")
    @TableField("approval_status")
    private Integer approvalStatus;

    @ApiModelProperty("申请时间")
    @TableField("appplication_time")
    private Date appplicationTime;

    @ApiModelProperty("申请人员")
    @TableField("applicant")
    private String applicant;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删")
    @TableField("is_delete")
    private Integer isDelete;


}
