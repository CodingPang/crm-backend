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
  * 数据字典表
  * </p>
* @author team6
* @since 2022-10-13 07:06:35
*/
  @NoArgsConstructor
  @AllArgsConstructor
  @Data
      @Accessors(chain = true)
  @TableName("t_data_dictionary")
  @ApiModel(value = "DataDictionary对象", description = "数据字典表")
  public class DataDictionary implements Serializable {

  private static final long serialVersionUID = 1L;
          @ApiModelProperty("主键，自增")
          @TableId(value = "id", type = IdType.AUTO)
  private Long id;

          @ApiModelProperty("字典表名字")
      @TableField("dictionary_name")
  private String dictionaryName;

          @ApiModelProperty("数据字典类型表id(外键)")
      @TableField("dictionary_type_id")
  private Long dictionaryTypeId;

}
