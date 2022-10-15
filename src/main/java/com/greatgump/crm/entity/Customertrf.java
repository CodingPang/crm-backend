package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_customertrf")
@ApiModel(value = "客户转移记录", description = "")
public class Customertrf implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("转出的用户id")
    @TableField("from")
    private Long from;

    @ApiModelProperty("接受的用户id")
    @TableField("to")
    private Long to;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删(0表示未删，1代表删除)")
    @TableField("is_delete")
    @TableLogic
    private Integer isDelete;

}
