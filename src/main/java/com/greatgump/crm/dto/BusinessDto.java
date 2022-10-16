package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.greatgump.crm.entity.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessDto {
    @ApiModelProperty("关联客户")
    @TableField("customer")
    private String customer;

    @ApiModelProperty("商机标题")
    @TableField("opportunity_title")
    private String opportunityTitle;

    @ApiModelProperty("商机阶段")
    @TableField("opportunity_stage")
    private String opportunityStage;


    @ApiModelProperty("最后跟进")
    @TableField("last_follow")
    private Date lastFollow;



}
