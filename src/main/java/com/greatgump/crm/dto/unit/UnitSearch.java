package com.greatgump.crm.dto.unit;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/23 16:27
 **/
@Data
public class UnitSearch {
    @ApiModelProperty("当前在多少页")
    private Integer current;
    @ApiModelProperty("每页多少条记录")
    private Integer size;
    @ApiModelProperty("记量单位名称")
    private String unitName;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
}
