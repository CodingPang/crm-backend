package com.greatgump.crm.dto;

import com.greatgump.crm.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClueBoxDto {
    @ApiModelProperty("线索归属下拉框集合")
    private List<UserDto> users;

    @ApiModelProperty("线索来源下拉框集合")
    private List<Source> sources;

    @ApiModelProperty("线索状态下拉框集合")
    private List<Clue> clues;


   /* @ApiModelProperty("商机阶段下拉框集合")
    private List<Business> businesses;

    @ApiModelProperty("关联客户下拉框集合")
    private List<Customer> customers;*/


}
