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
public class ReimburCheckDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("报销人员")
  @TableField("reimburer")
  private UserDto reimburer;

  @ApiModelProperty("报销部门")
  @TableField("reimbur_dept")
  private Dept reimburDept;

  @ApiModelProperty("备注信息")
  @TableField("remark")
  private String remark;

 /* @ApiModelProperty("报销金额")
  @TableField("reimbur_money")
  private BigDecimal reimburMoney;*/

  @ApiModelProperty("提交时间")
  @TableField("submit_time")
  private String submitTime;


  @ApiModelProperty("审批状态(0表示未审批，1表示已通过，2表示已驳回)")
  @TableField("check_status")
  private Integer checkStatus;

  @ApiModelProperty("审批人员(外键，审计)")
  @TableField("checker")
  private UserDto checker;

  @ApiModelProperty("审批时间")
  @TableField("check_time")
  private String checkTime;

  @ApiModelProperty("报销单号")
  @TableField("reimbur_no")
  private String reimburNo;


}
