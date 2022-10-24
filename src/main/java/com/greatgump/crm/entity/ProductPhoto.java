package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 产品图片表
 * @TableName t_product_photo
 */
@TableName(value ="t_product_photo")
@Data
public class ProductPhoto implements Serializable {
    /**
     * id
     */
    @TableField(value = "id")
    private Integer id;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 产品照片
     */
    @TableField(value = "product_photo")
    private String productPhoto;

    @TableLogic(value = "0",delval = "1")
    @TableField("is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}