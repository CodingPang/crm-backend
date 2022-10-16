package com.greatgump.crm.dto;

import com.greatgump.crm.entity.Management;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FollowFormBoxDto {
    @ApiModelProperty("关联客户")
    private List<Management> managementList;

    @ApiModelProperty("联系人")
    private List<Management> managementList1;

    @ApiModelProperty("跟进人员")
    private List<Management> managementList2;

    @ApiModelProperty("跟进方式")
    private List<Management> managementList3;
}
