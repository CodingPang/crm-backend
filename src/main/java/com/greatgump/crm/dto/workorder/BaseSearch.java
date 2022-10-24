package com.greatgump.crm.dto.workorder;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/20 14:38
 **/
@Data
public class BaseSearch {
    @ApiModelProperty("当前是多少页")
    private Integer current;
    @ApiModelProperty("每页多少条记录")
    private Integer size;
}
