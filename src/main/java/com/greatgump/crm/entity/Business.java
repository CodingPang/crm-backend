package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * 商机管理
 * </p>
 *
 * @author team6
 * @since 2022-10-13 09:52:50
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("t_business")
@ApiModel(value = "Business对象", description = "商机管理")
public class Business implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty("自增")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty("关联客户(外键)")
  @TableField("customer_id")
  private Long customerId;

  @ApiModelProperty("商机标题")
  @TableField("bussiness_title")
  private String bussinessTitle;

  @ApiModelProperty("商机来源")
  @TableField("bussiness_origin_id")
  private BusinessOrigin bussinessOrigin;

  @ApiModelProperty("商机阶段")
  @TableField("bussiness_stage")
  private BusinessStage bussinessStage;

  @ApiModelProperty("报价记录")
  @TableField("price_records")
  private String priceRecords;

  @ApiModelProperty("最后跟进")
  @TableField("last_follow")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date lastFollow;

  @ApiModelProperty("未跟进天数")
  @TableField("not_follow_days")
  private Integer notFollowDays;

  @ApiModelProperty("备注")
  @TableField("remark")
  private String remark;

  @ApiModelProperty("假删（0表示未删，1表示删除）")
  @TableField("is_delete")
  @TableLogic
  private Integer isDelete;

  // 费用管理使用的有参构造
  public Business(Long id, String bussinessTitle) {
    this.id = id;
    this.bussinessTitle = bussinessTitle;
  }
}
