package com.greatgump.crm.dto.back.plan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.OrderDto;
import com.greatgump.crm.dto.back.record.BackRecordPreDto;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/14 6:58
 * @since 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BackPlanQueryAllDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("系统编号")
    @TableField("back_no")
    private String backNo;

    @ApiModelProperty("关联订单(外键)")
    @TableField("order_id")
    private OrderDto order;

/*    @ApiModelProperty("回款期数")
    @TableField("plan_back_count")
    private String planBackCount;

    @ApiModelProperty("计划回款金额")
    @TableField("plan_back_total")
    private BigDecimal planBackTotal;*/

    @ApiModelProperty("计划回款期次 + 计划回款金额")
    private BackPlanDetailDto backPlanDetailDto;

   /* @ApiModelProperty("实际回款金额")
    @TableField("back_money")
    private BigDecimal backMoney;*/
   @ApiModelProperty("实际回款金额")
   private BackRecordPreDto backRecordPreDto;

    @ApiModelProperty("回款状态(0表示未完成，1表示已完成，2表示还款中，3表示已逾期)")
    @TableField("back_status")
    private Integer backStatus;

    @ApiModelProperty("关联客户(外键)")
    @TableField("customer_id")
    private CustomerDto customer;

    @ApiModelProperty("审批状态(0代表已驳回，1代表已通过，2代表审批中)")
    @TableField("approval_status")
    private Integer approvalStatus;

    @ApiModelProperty("创建时间")
    @TableField("creation_time")
    private String creationTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private String updateTime;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删(0代表未删，1代表删除)")
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;


    public BackPlanQueryAllDto(CustomerDto customerId, OrderDto order) {
        this.customer = customerId;
        this.order = order;
    }

  /**
   * 查询所有的回款计划
   * @param id
   * @param backNo
   * @param order
   * @param backPlanDetailDto
   * @param backRecordPreDto
   * @param backStatus
   * @param customer
   */
  public BackPlanQueryAllDto(Long id, String backNo, OrderDto order, BackPlanDetailDto backPlanDetailDto,
      BackRecordPreDto backRecordPreDto, Integer backStatus, CustomerDto customer) {
    this.id = id;
    this.backNo = backNo;
    this.order = order;
    this.backPlanDetailDto = backPlanDetailDto;
    this.backRecordPreDto = backRecordPreDto;
    this.backStatus = backStatus;
    this.customer = customer;
  }
}