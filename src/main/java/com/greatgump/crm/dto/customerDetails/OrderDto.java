package com.greatgump.crm.dto.customerDetails;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.dto.CustomerDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class OrderDto {
    @ApiModelProperty("自增主建")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单标题")
    @TableField("order_title")
    private String orderTitle;

    @ApiModelProperty("审批状态(0代表是已驳回，1代表已通过，2代表待审批)")
    @TableField("oder_status")
    private String oderStatus;

    @ApiModelProperty("订单总额")
    @TableField("oder_total")
    private BigDecimal oderTotal;

    @ApiModelProperty("已回款金额")
    @TableField("total_res")
    private BigDecimal totalRes;

    @ApiModelProperty("已开票金额")
    @TableField("total_ticket")
    private BigDecimal totalTicket;

}
