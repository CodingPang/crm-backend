package com.greatgump.crm.dto.finance.reimbur;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.Dept;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 报销 查询专用数据传输层
 * @date 2022/10/17 2:13
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReimburDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("报销单号")
  @TableField("reimbur_no")
  private String reimburNo;

  @ApiModelProperty("报销部门(外键，部门id)")
  @TableField("reimbur_dept")
  private Dept reimburDept;

  @ApiModelProperty("报销金额")
  @TableField("reimbur_money")
  private BigDecimal reimburMoney;

  @ApiModelProperty("提交时间")
  @TableField("submit_time")
  private String submitTime;

  @ApiModelProperty("报销人员(外键，销售id)")
  @TableField("reimburer")
  private UserDto reimburer;

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

  public ReimburDto(Long id, String reimburNo, Dept reimburDept, BigDecimal reimburMoney,
      String submitTime, UserDto reimburer, Integer checkStatus, Integer payStatus) {
    this.id = id;
    this.reimburNo = reimburNo;
    this.reimburDept = reimburDept;
    this.reimburMoney = reimburMoney;
    this.submitTime = submitTime;
    this.reimburer = reimburer;
    this.checkStatus = checkStatus;
    this.payStatus = payStatus;
  }

}
