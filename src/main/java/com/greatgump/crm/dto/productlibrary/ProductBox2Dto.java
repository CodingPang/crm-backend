package com.greatgump.crm.dto.productlibrary;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductBox2Dto {
    @ApiModelProperty("主键,自增")
    private Long id;

    @ApiModelProperty("单位名称")
    private String unitName;
}
