package com.greatgump.crm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.greatgump.crm.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UplodeEnclosureDto {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("附件名称")
    @TableField("upload_location")
    private String uploadName;

    @ApiModelProperty("上传人员")
    @TableField("upload_people")
    private String uploadPeople;

    @ApiModelProperty("上传文件地址")
    @TableField("upload_date")
    private String uploadDate;

    @ApiModelProperty("上传文件大小")
    @TableField("upload_size")
    private String uploadSize;
}
