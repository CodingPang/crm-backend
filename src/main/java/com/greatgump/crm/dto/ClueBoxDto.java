package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.TableField;
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

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    private Long id;

    @ApiModelProperty("线索归属下拉框集合")
    private List<Clue> clueList;

    @ApiModelProperty("线索来源下拉框集合")
    private List<FollowForm> sourceList;

    @ApiModelProperty("线索状态下拉框集合")
    private List<FollowForm> statusList;

    @ApiModelProperty("客户需求")
    private String customerNeeds;


}
