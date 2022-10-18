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
  * 
  * </p>
* @author team6
* @since 2022-10-14 01:52:00
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_cost")
  @ApiModel(value = "Cost对象", description = "")
  public class Cost implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("费用编号")
      @TableField("cost_no")
  private String costNo;

          @ApiModelProperty("费用名称")
      @TableField("cost_name")
  private String costName;

          @ApiModelProperty("关联客户(外键)")
      @TableField("customer_id")
  private Long customerId;

          @ApiModelProperty("费用金额")
      @TableField("cost_money")
  private BigDecimal costMoney;

          @ApiModelProperty("发生时间")
      @TableField("happened_time")
  private String happenedTime;

          @ApiModelProperty("负责人员(外键，销售)")
      @TableField("charge")
  private Long charge;

          @ApiModelProperty("报销状态(0表示未报销，1表示已报销)")
      @TableField("expense_status")
  private Integer expenseStatus;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删(0表示未删，1表示删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
