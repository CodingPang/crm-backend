package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 计量单位
 * @TableName t_calc_unit
 */
@TableName(value ="t_calc_unit")
@Data
public class CalcUnit implements Serializable {
    /**
     * 主键,自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单位名称
     */
    @TableField(value = "unit_name")
    private String unitName;

    /**
     * 创建日期
     */
    @TableField(value = "creation_date")
    private Date creationDate;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 假删(0表示未删,1表示删除)
     */
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}