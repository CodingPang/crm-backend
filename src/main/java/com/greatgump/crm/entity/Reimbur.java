package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 报销
 * </p>
 *
 * @author team6
 * @since 2022-10-14 01:52:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_reimbur")
@ApiModel(value = "Reimbur对象", description = "报销")
public class Reimbur implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("报销单号")
  @TableField("reimbur_no")
  private String reimburNo;

  @ApiModelProperty("报销部门(外键，部门id)")
  @TableField("reimbur_dept")
  private Long reimburDept;

  @ApiModelProperty("报销金额")
  @TableField("reimbur_money")
  private BigDecimal reimburMoney;

  @ApiModelProperty("提交时间")
  @TableField("submit_time")
  private String submitTime;

  @ApiModelProperty("报销人员(外键，销售id)")
  @TableField("reimburer")
  private Long reimburer;

  @ApiModelProperty("审批状态(0表示未审批，1表示已通过，2表示已驳回)")
  @TableField("check_status")
  private Integer checkStatus;

  @ApiModelProperty("审批时间")
  @TableField("check_time")
  private String checkTime;

  @ApiModelProperty("审批人员(外键，审计)")
  @TableField("checker")
  private String checker;

  @ApiModelProperty("打款方式(1表示支付宝，2表示微信，3表示现金)")
  @TableField("pay_method")
  private Integer payMethod;

  @ApiModelProperty("财务打款(0表示未打款，1表示已打款)")
  @TableField("pay_status")
  private Integer payStatus;

  @ApiModelProperty("备注")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删(0表示未删，1表示已删)")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;

}
