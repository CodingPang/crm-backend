package com.greatgump.crm.dto.businessDto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.greatgump.crm.entity.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BusinessDto {
    @ApiModelProperty("id")
    @TableField("id")
    private Long id;
    @ApiModelProperty("关联客户")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("商机标题")
    @TableField("bussiness_title")
    private String bussinessTitle;

    @ApiModelProperty("商机阶段")
    @TableField("business_stage")
    private String businessStage;

    @ApiModelProperty("报价记录")
    @TableField("price_records")
    private String priceRecords;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("最后跟进")
    @TableField("last_follow")
    private Date lastFollow;

    @ApiModelProperty("未跟进天数")
    @TableField("not_follow_days")
    private int notFollowDays;

}
