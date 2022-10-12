package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 顾客表
 * </p>
 *
 * @author team6
 * @since 2022-10-12 10:31:27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_customer")
@ApiModel(value = "Customer对象", description = "顾客表")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("客户名称")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("省份")
    @TableField("province")
    private String province;

    @ApiModelProperty("城市")
    @TableField("city")
    private String city;

    @ApiModelProperty("企业规模对象")
    @TableField(exist = false)
    private Scale scale;

    @ApiModelProperty("客户类别对象")
    @TableField(exist = false)
    private Type type;

    @ApiModelProperty("客户来源对象")
    @TableField(exist = false)
    private Source source;

    @ApiModelProperty("客户行业对象")
    @TableField(exist = false)
    private Industry industry;

    @ApiModelProperty("客户归属")
    @TableField(exist = false)
    private User belong;

    @ApiModelProperty("1是客户，0是公海")
    @TableField("is_customer")
    private Long isCustomer;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("删除标记（1删除 0未删）")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty("联系人集合")
    @TableField(exist = false)
    private List<Contact> contacts;

}
