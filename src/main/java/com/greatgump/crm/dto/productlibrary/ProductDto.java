package com.greatgump.crm.dto.productlibrary;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("产品编码")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty("产品名称")
    @TableField("product_name")
    private String productName;

//    @ApiModelProperty("所属分类")
//    @TableField("classificationid")
//    private Integer classificationid;

    @ApiModelProperty("所属分类")
    private Assort assort;


//    @ApiModelProperty("计量单位")
//    @TableField("unitid")
//    private Integer unitid;

    @ApiModelProperty("计量单位")
    private CalcUnit calcUnit;


    @ApiModelProperty("属性")
    private Property property;


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
