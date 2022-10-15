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
  * 客户行业
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_industry")
  @ApiModel(value = "Industry对象", description = "客户行业")
  public class Industry implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("行业名称")
      @TableField("name")
  private String name;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("删除标记 1删除，0未删")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
