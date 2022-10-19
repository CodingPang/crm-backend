package com.greatgump.crm.dto.productlibrary;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryAssortDto {

    @ApiModelProperty("主键，自增")
    private Long id;

    @ApiModelProperty("产品分类")
    private String assortName;
}
