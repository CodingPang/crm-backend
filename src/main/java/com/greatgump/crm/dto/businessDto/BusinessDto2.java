package com.greatgump.crm.dto.businessDto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessDto2 {

    @ApiModelProperty("商机标题")
    @TableField("opportunity_title")
    private String opportunityTitle;

    @ApiModelProperty("商机阶段")
    @TableField("bussiness_stage_id")
    private String businessStage;

    @ApiModelProperty("报价记录")
    @TableField("bussiness_origin_id")
    private String businessOrigin;





}
