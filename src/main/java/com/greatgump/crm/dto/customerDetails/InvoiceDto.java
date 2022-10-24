package com.greatgump.crm.dto.customerDetails;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class InvoiceDto {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("开票日期")
    private Date invoice_date;

    @ApiModelProperty("发票类型")
    private Integer invoice_type;

    @ApiModelProperty("发票号码")
    private String invoice_no;

    @ApiModelProperty("开票金额")
    private Long invoice_money;

    @ApiModelProperty("开票科目")
    private String invoice_subject;


}
