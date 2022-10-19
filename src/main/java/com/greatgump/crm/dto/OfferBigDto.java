package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferBigDto {
    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty("单号")
    @TableField("odd_num")
    private String oddNum;

    @ApiModelProperty("创建时间")
    @TableField("creation_date")
    private Date creationDate;

    @ApiModelProperty("客户")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty("报价人")
    @TableField("saler_id")
    private Integer salerId;

    @ApiModelProperty("联系人")
    @TableField("contacts_id")
    private Integer contactsId;

    @ApiModelProperty("售价总额")
    @TableField("price")
    private BigDecimal pricetotal;

    @ApiModelProperty("折扣率")
    @TableField("discount_tate")
    private String discountTate;

    @ApiModelProperty("报价总额")
    @TableField("offer")
    private BigDecimal offer;

    private List<OfferDetailsDto> offerDetailsDtos;
}
