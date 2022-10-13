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
    @TableField("username")
    private String username;

    @ApiModelProperty("商机标题")
    @TableField("opportunity_title")
    private String opportunityTitle;

    @ApiModelProperty("商机阶段")
    @TableField("opportunity_stage")
    private String opportunityStage;

    @ApiModelProperty("报价记录")
    @TableField("price_records")
    private String priceRecords;

    @ApiModelProperty("最后跟进")
    @TableField("last_follow")
    private Date lastFollow;

    @ApiModelProperty("未跟进天数")
    @TableField("not_follow_days")
    private Integer notFollowDays;

  /*  @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("假删（0表示未删，1表示删除）")
    @TableField("is_delete")
    private Integer isDelete;*/

}
