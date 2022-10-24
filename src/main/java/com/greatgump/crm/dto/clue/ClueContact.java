package com.greatgump.crm.dto.clue;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel(value = "Clue对象", description = "线索管理")
public class ClueContact {
    @ApiModelProperty("自增")
    private Long id;

    @ApiModelProperty("线索来源")
    private String contact_name;


    @ApiModelProperty("线索来源")
    private String mail;

    @ApiModelProperty("线索来源")
    private String phone;

    @ApiModelProperty("线索来源")
    private String qq;

    @ApiModelProperty("线索来源")
    private String department;

    @ApiModelProperty("线索来源")
    private String wechat;

    @ApiModelProperty("线索来源")
    private String is_default;

    @ApiModelProperty("线索来源")
    private String customer_id;

    @ApiModelProperty("线索来源")
    private String remark;


}
