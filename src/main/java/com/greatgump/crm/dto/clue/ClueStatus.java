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
public class ClueStatus {
    @ApiModelProperty("自增")

    private Long id;

    @ApiModelProperty("线索状态")

    private String ClueStatus;
}
