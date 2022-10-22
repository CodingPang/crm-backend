package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class FollowFromAscriptionDto {
    @TableField("归属人员")
    private String ascription;

    @TableField("归属起始")
    private String ascriptionStart;

    @TableField("归属截止")
    private String ascriptionEnd;

    @TableField("归属人员")
    private String operators;

    @TableField("操作时间")
    private String operateTime;
}
