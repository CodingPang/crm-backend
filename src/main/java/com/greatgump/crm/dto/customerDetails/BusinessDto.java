package com.greatgump.crm.dto.customerDetails;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class BusinessDto {

    @ApiModelProperty("商机标题")
    @TableField("opportunity_title")
    private String opportunityTitle;

    @ApiModelProperty("商机阶段")
    @TableField("bussiness_stage_id")
    private String opportunityStage;

    @ApiModelProperty("报价记录")
    @TableField("price_records")
    private String priceRecords;

    @ApiModelProperty("最后跟进")
    @TableField("last_follow")
    private Date lastFollow;

    @ApiModelProperty("未跟进天数")
    @TableField("not_follow_days")
    private int notFollowDays;

}
