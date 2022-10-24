package com.greatgump.crm.dto.customerDetails;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class EnclosureDto {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("上传人员")
    private String uploadPeople;

    @ApiModelProperty("上传时间")
    private Date uploadDate;

    @ApiModelProperty("附件名称")
    private String uploadName;

    @ApiModelProperty("文件大小")
    private String uploadSize;



}
