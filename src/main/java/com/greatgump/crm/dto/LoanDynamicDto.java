package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDynamicDto implements Serializable {


    private static final long serialVersionUID = 1L;

   @ApiModelProperty("关键字")
    private String keywords;

    @ApiModelProperty("审批状态")
    private Integer approval_status;

    @ApiModelProperty("开始时间")
    private Date appplication_time;

    @ApiModelProperty("结束时间")
    private Date submission_time;


}
