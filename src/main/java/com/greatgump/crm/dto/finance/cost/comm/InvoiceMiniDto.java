package com.greatgump.crm.dto.finance.cost.comm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description
 * @date 2022/10/20 19:30
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceMiniDto {
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("开票金额")
  @TableField("invoice_money")
  private BigDecimal invoiceMoney;
}
