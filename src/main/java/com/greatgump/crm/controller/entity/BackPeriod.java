package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* <p>
  * 回款期次
  * </p>
* @author team6
* @since 2022-10-15 04:12:19
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_back_period")
  @ApiModel(value = "BackPeriod对象", description = "回款期次")
  public class BackPeriod implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("回款期次")
      @TableField("back_period_name")
  private String backPeriodName;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("假删(0表示假删，1表示删除)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
