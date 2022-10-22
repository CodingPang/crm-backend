package com.greatgump.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("状态id")
    private Long id;

    @ApiModelProperty("审批状态")
    private String Approval_status;
}
