package com.greatgump.crm.dto.finance.cost;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Customer;
import com.greatgump.crm.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 订单列表 dto
 * @date 2022/10/18 17:41
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderListDto {
  @ApiModelProperty("自增主建")
  private Long id;

  @ApiModelProperty("订单编号")
  private String orderNo;

  @ApiModelProperty("订单标题")
  private String orderTitle;

  @ApiModelProperty("关联客户(外键，客户表id)")
  private Customer customer;

  @ApiModelProperty("订单归属(外键，销售id)")
  private User sale;

}
