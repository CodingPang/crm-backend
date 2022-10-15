package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* <p>
  * 跟进记录表
  * </p>
* @author team6
* @since 2022-10-15 04:12:19
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("chasing_record")
  @ApiModel(value = "ChasingRecord对象", description = "跟进记录表")
  public class ChasingRecord implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("联系人id")
      @TableField("contact_id")
  private Integer contactId;

          @ApiModelProperty("跟进方式（0表示到访，1表示电话，2表示微信，3表示QQ）")
      @TableField("follow_through")
  private String followThrough;

          @ApiModelProperty("关联用户表的id")
      @TableField("user_id")
  private Integer userId;

          @ApiModelProperty("跟进时间")
      @TableField("progressive_time")
      @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  private Date progressiveTime;

          @ApiModelProperty("跟进内容")
      @TableField("catch_content")
  private String catchContent;

          @ApiModelProperty("跟进表id（关联跟进表的id）")
      @TableField("t_follow_form_id")
  private Long tFollowFormId;

          @ApiModelProperty("备注")
      @TableField("remark")
  private String remark;

          @ApiModelProperty("删除（0未删，1删除）")
      @TableField("is_delete")
      @TableLogic
  private Integer isDelete;

}
