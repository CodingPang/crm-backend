package com.greatgump.crm.dto.businessDto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChasingAddDto {
    @ApiModelProperty("id")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("关联客户")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty("联系人")
    @TableField("concat_id")
    private int concatId;

    @ApiModelProperty("跟进时间")
    @TableField("progressive_time")
    private String progressiveTime;

    @ApiModelProperty("跟进人员")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("跟进方式")
    @TableField("follow_through")
    private String chasingMethod;


    @ApiModelProperty("跟进内容")
    @TableField("catch_content")
    private String catchContent;
}
