package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.entity.Business;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.Order;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 费用 查询专用 数据传输层
 * @date 2022/10/16 21:30
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("费用编号")
  @TableField("cost_no")
  private String costNo;

  @ApiModelProperty("费用名称")
  @TableField("cost_name")
  private String costName;

  @ApiModelProperty("费用来源(0表示电话营销，1表示主动来电，2表示客户介绍，3表示展会促销，4表示其他途径)")
  @TableField("cost_source")
  private Integer costSource;

  @ApiModelProperty("费用类型(0表示招待费，1表示交通费，2表示住宿费，3表示礼品费，4表示其他)")
  @TableField("cost_type")
  private Integer costType;

  @ApiModelProperty("费用阶段(0表示需求获取，1表示首次拜访，2表示方案展示，3表示产品报价，4表示合同谈判，5表示合同签订)")
  @TableField("cost_stage")
  private Integer costStage;

  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private Customer customer;

  @ApiModelProperty("负责人员(外键，销售)")
  @TableField("user_id")
  private User user;

  @ApiModelProperty("关联订单(外键)")
  @TableField("order_id")
  private Order order;

  @ApiModelProperty("关联商机(外键)")
  @TableField("business_id")
  private Business business;

  @ApiModelProperty("费用金额")
  @TableField("cost_money")
  private BigDecimal costMoney;

  @ApiModelProperty("发生时间")
  @TableField("happened_time")
  private String happenedTime;

  @ApiModelProperty("报销状态(0表示未报销，1表示已报销)")
  @TableField("expense_status")
  private Integer expenseStatus;

  @ApiModelProperty("费用描述")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删(0表示未删，1表示删除)")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;

  public CostDto(Long id, String costNo, String costName, Integer costType, Customer customer,
      User user, Order order, Business business, BigDecimal costMoney, String happenedTime,
      Integer expenseStatus, String remark, Integer isDelete) {
    this.id = id;
    this.costNo = costNo;
    this.costName = costName;
    this.costType = costType;
    this.customer = customer;
    this.user = user;
    this.order = order;
    this.business = business;
    this.costMoney = costMoney;
    this.happenedTime = happenedTime;
    this.expenseStatus = expenseStatus;
    this.remark = remark;
    this.isDelete = isDelete;
  }
}
