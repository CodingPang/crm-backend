package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 产品属性关联表
 * @TableName t_product_property
 */
@TableName(value ="t_product_property")
@Data
public class ProductProperty implements Serializable {
    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 属性id
     */
    @TableField(value = "property_id")
    private Long propertyId;

    /**
     * 
     */
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}