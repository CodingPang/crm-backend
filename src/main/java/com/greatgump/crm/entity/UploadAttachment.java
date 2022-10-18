package com.greatgump.crm.entity;

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
 * 文件上传
 * </p>
 *
 * @author team6
 * @since 2022-10-18 01:40:29
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_upload_attachment")
@ApiModel(value = "UploadAttachment对象", description = "文件上传")
public class UploadAttachment implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty("主键，自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("上传文件地址")
  @TableField("upload_location")
  private String uploadLocation;

  @ApiModelProperty("订单id(外键，关联订单表)")
  @TableField("order_id")
  private Order orderId;

}
