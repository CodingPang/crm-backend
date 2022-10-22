package com.greatgump.crm.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalStatusDto implements Serializable {

    @ApiModelProperty("状态id")
    private Long id;

    @ApiModelProperty("审批状态")
    private String approval_status;
}
