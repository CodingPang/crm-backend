package com.greatgump.crm.dto;

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
    @TableField("bussiness_title")
    private String bussinessTitle;

    @ApiModelProperty("商机阶段")
    @TableField("business_stage")
    private String businessStage;

    @ApiModelProperty("报价记录")
    @TableField("business_origin")
    private String businessOrigin;





}
