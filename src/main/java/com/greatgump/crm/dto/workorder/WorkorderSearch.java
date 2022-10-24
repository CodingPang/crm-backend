package com.greatgump.crm.dto.workorder;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/20 14:39
 **/
@Data
public class WorkorderSearch extends BaseSearch{
    @ApiModelProperty("工单标题--关键词搜")
    private String title;
    @ApiModelProperty("工单状态")
    private Integer status;
    @ApiModelProperty("紧急程度")
    private Integer urgent;


}
