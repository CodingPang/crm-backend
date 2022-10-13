package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    @ApiModelProperty("产品编码")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty("所属分类")
    @TableField("classification")
    private String classification;

    @ApiModelProperty("产品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("计量单位")
    @TableField("unit")
    private String unit;

//    @ApiModelProperty("产品分类表的id")
//    @TableField("assort_id")
//    private Integer assortId;

    @ApiModelProperty("创建日期")
    @TableField("creation_date")
    private Date creationDate;

//    @ApiModelProperty("备注")
//    @TableField("remark")
//    private String remark;
//
//    @ApiModelProperty("假删(0表示未删,1表示删除)")
//    @TableField("is_delete")
//    private Integer isDelete;
}
