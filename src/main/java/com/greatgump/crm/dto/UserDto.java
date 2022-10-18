package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.greatgump.crm.entity.Dept;
import com.greatgump.crm.entity.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 用户 数据传输层
 * @date 2022/10/13 15:43
 * @since 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("用户名")
  @TableField("username")
  private String username;


  @ApiModelProperty("角色")
  private Role role;

  @ApiModelProperty("备注")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("逻辑删除(0表示未删，1表示删除)")
  @TableField("is_delete")
  @TableLogic
  private String isDelete;

  public UserDto(Long id, String username) {
    this.id = id;
    this.username = username;
  }
}
