package com.greatgump.crm.controller.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
  * 
  * </p>
* @author team6
* @since 2022-10-15 04:12:19
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_assort")
  @ApiModel(value = "Assort对象", description = "")
  public class Assort implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("产品分类")
      @TableField("assort_name")
  private String assortName;

          @ApiModelProperty("父级分类的id")
      @TableField("parent_id")
  private Integer parentId;

}
