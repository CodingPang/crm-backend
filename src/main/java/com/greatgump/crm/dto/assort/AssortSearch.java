package com.greatgump.crm.dto.assort;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/23 15:52
 **/
@Data
public class AssortSearch {
    @ApiModelProperty("当前第几页")
    private Integer current;
    @ApiModelProperty("每页多少条记录")
    private Integer size;
    @ApiModelProperty("分类名称")
    private String name;
}
