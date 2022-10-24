package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分类表--还可排序
 * @TableName t_assort
 */
@TableName(value ="t_assort")
@Data
public class Assort implements Serializable {
    /**
     * 主键，自增
     */
    @ApiModelProperty("产品分类")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品分类
     */
    @ApiModelProperty("产品分类")
    @TableField(value = "assort_name")
    private String assortName;

    /**
     * 父级分类的id
     */
    @ApiModelProperty("父级分类的id")
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 用于同级分类排序
     */
    @ApiModelProperty("用于同级分类排序")
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 
     */
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}