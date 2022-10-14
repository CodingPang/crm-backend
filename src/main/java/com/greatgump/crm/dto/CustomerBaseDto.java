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
public class CustomerBaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业规模")
    private Scale scale;

    @ApiModelProperty("客户类别")
    private Type type;

    @ApiModelProperty("客户来源")
    private Source source;

    @ApiModelProperty("客户行业")
    private Industry industry;

    @ApiModelProperty("客户归属")
    private User user;

    @ApiModelProperty("联系人")
    private Contact contact;
}
