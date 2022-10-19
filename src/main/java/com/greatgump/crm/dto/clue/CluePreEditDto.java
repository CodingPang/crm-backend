package com.greatgump.crm.dto.clue;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodingPang
 * @version V1.0
 * @description 线索预编辑Dto
 * @date 2022/10/19 10:18
 * @since 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CluePreEditDto {
  private long id;

  @ApiModelProperty("客户名称")
  private String username;

  @ApiModelProperty("线索归属")
  private Integer userId;

  @ApiModelProperty("线索归属姓名")
  private String userName;

  @ApiModelProperty("线索来源")
  private Integer sourceId;

  @ApiModelProperty("线索来源标题")
  private String sourceName;

  @ApiModelProperty("线索状态")
  private Integer status;


  @ApiModelProperty("客户需求")
  private String customerNeeds;

  @ApiModelProperty("联系人")
  private String contacts;

  @ApiModelProperty("电子邮箱")
  private String eMail;

  @ApiModelProperty("联系号码")
  private String phone;

  @ApiModelProperty("QQ号码")
  private String qq;

  @ApiModelProperty("部门职务(外键，部门表)")
  private Integer deptId;

  @ApiModelProperty("微信账号")
  private String wechat;

}
