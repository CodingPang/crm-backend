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
  * 角色
  * </p>
* @author team6
* @since 2022-10-15 04:12:20
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_role")
  @ApiModel(value = "Role对象", description = "角色")
  public class Role implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("角色id")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("角色名称")
      @TableField("name")
  private String name;

          @ApiModelProperty("角色描述")
      @TableField("description")
  private String description;

          @ApiModelProperty("上级")
      @TableField("parent_id")
  private Long parentId;

          @ApiModelProperty("部门(外键)")
      @TableField("dept_id")
  private Long deptId;

          @ApiModelProperty("假删(0表示未删，1表示未删)")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
