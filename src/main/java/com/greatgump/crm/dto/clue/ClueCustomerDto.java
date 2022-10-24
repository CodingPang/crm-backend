package com.greatgump.crm.dto.clue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "Clue对象", description = "线索管理")
public class ClueCustomerDto {

    @ApiModelProperty("客户id")
    private Long customerId;

    @ApiModelProperty("客户名称")
    private String customerName;
}
