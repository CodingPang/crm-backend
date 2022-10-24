package com.greatgump.crm.dto.clue;

import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value = "ClueSelectCondition对象", description = "线索管理")
public class ClueSelectCondition {
    @ApiModelProperty("客户名称")
    private String username;

    @ApiModelProperty("线索来源id")
    private Long originId;

    @ApiModelProperty("线索状态id")
    private Long statusId;

    @ApiModelProperty("查询时间前面")
    private Date startTime;

    @ApiModelProperty("查询时间后面")
    private Date endTime;
}
