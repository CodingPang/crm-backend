package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.dto.BusinessDto;
import com.greatgump.crm.dto.CustomerDto;
import com.greatgump.crm.dto.power.UserDto;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
public class CostQueryDto {
  @ApiModelProperty("主键，自增")
  private Long id;

  @ApiModelProperty("费用编号")
  private String costNo;

  @ApiModelProperty("费用名称")
  private String costName;

  @ApiModelProperty("费用来源(0表示电话营销，1表示主动来电，2表示客户介绍，3表示展会促销，4表示其他途径)")
  private Integer costSource;

  @ApiModelProperty("费用类型(0表示招待费，1表示交通费，2表示住宿费，3表示礼品费，4表示其他)")
  private Integer costType;

  @ApiModelProperty("费用阶段(0表示需求获取，1表示首次拜访，2表示方案展示，3表示产品报价，4表示合同谈判，5表示合同签订)")
  private Integer costStage;

  @ApiModelProperty("关联客户(外键)")
  private String customerName;

  @ApiModelProperty("负责人员(外键，销售)")
  private String userName;

  @ApiModelProperty("关联订单(外键)")
  private String orderTitle;

  @ApiModelProperty("关联商机(外键)")
  private String business;

  @ApiModelProperty("费用金额")
  private BigDecimal costMoney;

  @ApiModelProperty("发生时间")
  private String happenedTime;

  @ApiModelProperty("报销状态(0表示未报销，1表示已报销)")
  private Integer expenseStatus;

  @ApiModelProperty("费用描述")
  private String remark;

  /*@ApiModelProperty(value = "假删(0表示未删，1表示删除)" ,hidden=true)
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;*/

  public CostQueryDto(Long id, String costNo, String costName, Integer costSource, Integer costType,
      Integer costStage, CustomerDto customerName, UserDto userName, Order orderTitle, BusinessDto businessStage,
      BigDecimal costMoney, String happenedTime, Integer expenseStatus, String remark) {
    this.id = id;
    this.costNo = costNo;
    this.costName = costName;
    /*this.costSource = costSource;
    this.costType = costType;
    this.costStage = costStage;*/
    this.customerName = customerName.getCustomerName();
    this.userName = userName.getUsername();
    /*this.orderTitle = orderTitle.getOrderTitle();
    this.business = businessStage.getOpportunityStage();*/
    this.costMoney = costMoney;
    this.happenedTime = happenedTime;
    this.expenseStatus = expenseStatus;
    this.remark = remark;
  }
}
