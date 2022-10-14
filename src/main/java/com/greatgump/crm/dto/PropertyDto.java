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
public class PropertyDto {
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

//    @ApiModelProperty("备注")
//    @TableField("remark")
//    private String remark;
//
//    @ApiModelProperty("假删(0表示未删,1表示删除)")
//    @TableField("is_delete")
//    private Integer isDelete;
}
