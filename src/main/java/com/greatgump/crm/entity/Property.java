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
 * 产品属性
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_property")
@ApiModel(value = "Property对象", description = "产品属性")
public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键,自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("属性名称")
    @TableField("property_name")
    private String propertyName;

    @ApiModelProperty("属性值")
    @TableField("property_value")
    private String propertyValue;

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
