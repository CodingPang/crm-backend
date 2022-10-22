package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
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
    private Long id;

    @ApiModelProperty("产品编码")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty("所属分类")
    @TableField("classificationid")
    private Integer classificationid;

//    @ApiModelProperty("所属分类")
//    private Assort assort;

    @ApiModelProperty("产品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("计量单位")
    @TableField("unitid")
    private Integer unitid;

//    @ApiModelProperty("计量单位")
//    private CalcUnit calcUnit;


    @ApiModelProperty("创建日期")
    @TableField("creation_date")
    private Date creationDate;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删(0表示未删,1表示删除)")
    @TableField("is_delete")
    private Integer isDelete;


}
