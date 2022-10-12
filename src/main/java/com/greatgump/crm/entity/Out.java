package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_out")
@ApiModel(value = "Out对象", description = "")
public class Out implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("装货订单")
    @TableField("out_num")
    private String outNum;

    @ApiModelProperty("关联单号")
    @TableField("order")
    private String order;

    @ApiModelProperty("关联客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("出库状态")
    @TableField("state")
    private String state;

    @ApiModelProperty("出库日期")
    @TableField("out_date")
    private Date outDate;

    @ApiModelProperty("收货人")
    @TableField("res_people")
    private String resPeople;

    @ApiModelProperty("收获电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("物流单号")
    @TableField("express_id")
    private String expressId;

    @ApiModelProperty("物流公司")
    @TableField("express_name")
    private String expressName;

    @ApiModelProperty("运费金额")
    @TableField("express_price")
    private BigDecimal expressPrice;

    @ApiModelProperty("运费承担")
    @TableField("express_who")
    private String expressWho;

    @ApiModelProperty("收货姓名")
    @TableField("res_name")
    private String resName;

    @ApiModelProperty("收货电话")
    @TableField("res_phone")
    private String resPhone;

    @ApiModelProperty("备注")
    @TableField("reamake")
    private String reamake;

    @ApiModelProperty("虚拟删除(0是未删，1是删除)")
    @TableField("is_delete")
    private Integer isDelete;


}
