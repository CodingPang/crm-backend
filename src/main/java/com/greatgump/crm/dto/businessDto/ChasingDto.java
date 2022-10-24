package com.greatgump.crm.dto.businessDto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChasingDto {
    @ApiModelProperty("关联客户")
    @TableField("customer_name")
    private String customerName;

}
