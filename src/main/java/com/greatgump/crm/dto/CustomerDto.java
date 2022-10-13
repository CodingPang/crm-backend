package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.greatgump.crm.entity.Contact;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    @ApiModelProperty("客户名")
    private String customerName;

    @ApiModelProperty("归属人员")
    private String userName;
    @ApiModelProperty("客户类型")
    private String typeName;
    @ApiModelProperty("行业名")
    private String industryName;
    @ApiModelProperty("省份名")
    private String province;
    @ApiModelProperty("城市名")
    private String cityName;
    @ApiModelProperty("客户规模")
    private String scope;
    @ApiModelProperty("客户来源")
    private String sourceName;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date createTime;
    @ApiModelProperty("联系人集合")
    List<Contact> contacts;
}
