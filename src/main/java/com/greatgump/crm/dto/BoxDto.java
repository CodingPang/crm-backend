package com.greatgump.crm.dto;

import com.greatgump.crm.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业规模下拉框集合")
    private List<Scale> scales;

    @ApiModelProperty("客户类别下拉框集合")
    private List<Type> types;

    @ApiModelProperty("客户来源下拉框集合")
    private List<Source> sources;

    @ApiModelProperty("客户行业下拉框集合")
    private List<Industry> industries;

    @ApiModelProperty("客户归属下拉框集合")
    private List<User> users;
}
