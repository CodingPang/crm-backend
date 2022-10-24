package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品库
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */

@JsonIgnoreProperties(value = {"handler"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_product")
@ApiModel(value = "Product对象", description = "产品库")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("产品编码")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty("所属分类")
    @TableField("classificationid")
    private Integer classificationid;


    @ApiModelProperty("产品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("计量单位")
    @TableField("unitid")
    private Integer unitid;


    @ApiModelProperty("创建日期")
    @TableField("creation_date")
    private Date creationDate;

    @ApiModelProperty("产品单价")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @TableLogic(value = "0",delval = "1")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty("购买状态 0-未被购买 1-被购买")
    @TableField("purchased_status")
    private Integer purchasedStatus;

    @ApiModelProperty("产品当前出库状态 0-未出库 1-已出库")
    @TableField("out_status")
    private Integer outStatus;





    /**
     * 所属分类名称
     */
    @ApiModelProperty("所属分类名称")
    @TableField(exist = false)
    private String sortName;

    /**
     * 计量单位   @TableField(exist = false) 该注解表示不和数据库字段映射
     */
    @ApiModelProperty("计量单位")
    @TableField(exist = false)
    private String unit;
    /**
     * 产品属性   @TableField(exist = false) 该注解表示不和数据库字段映射
     */
    @ApiModelProperty("产品属性")
    @TableField(exist = false)
    private List<Property> properties;

    /**
     * 产品图片  @TableField(exist = false) 该注解表示不和数据库字段映射
     */
    @ApiModelProperty("产品图片")
    @TableField(exist = false)
    private List<ProductPhoto> photos;




}
