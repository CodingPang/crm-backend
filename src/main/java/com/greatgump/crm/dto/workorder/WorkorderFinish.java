package com.greatgump.crm.dto.workorder;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @Description:
 * @Author: zhuiyi
 * @CreatTime: 2022/10/23 20:21
 **/
@Data
public class WorkorderFinish {
    @ApiModelProperty("当前操作的用户id")
    private Integer currentUserId;
    @ApiModelProperty("完结工单id")
    private Integer finishId;
    @ApiModelProperty("备注")
    private String note;
    @ApiModelProperty("上传附件返回给你的url地址")
    private String attachment;
}
