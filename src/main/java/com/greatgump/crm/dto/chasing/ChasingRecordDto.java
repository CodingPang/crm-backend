package com.greatgump.crm.dto.chasing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "Clue对象", description = "线索管理")
public class ChasingRecordDto {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("跟进内容")
    private String catchContent;

    @ApiModelProperty("跟进时间")
    private Date progressiveTime;

    @ApiModelProperty("关联客户")
    private String customer;

    @ApiModelProperty("负责人")
    private String user;

    @ApiModelProperty("跟进类型")
    private String followType;

    @ApiModelProperty("跟进方式")
    private String followThrough;

    @ApiModelProperty("联系人员")
    private String contact;

    @ApiModelProperty("联系号码")
    private String phone;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
