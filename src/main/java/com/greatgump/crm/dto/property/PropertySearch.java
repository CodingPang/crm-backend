package com.greatgump.crm.dto.property;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/23 14:15
 **/
@Data
public class PropertySearch {
    @ApiModelProperty(value = "当前多少页",required = true)
    private Integer current;
    @ApiModelProperty(value = "每页多少条数据",required = true)
    private Integer size;
    @ApiModelProperty(value = "搜索框的内容")
    private String searchContent;

    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
