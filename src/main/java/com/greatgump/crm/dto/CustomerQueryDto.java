package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerQueryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String keywords;
    private Integer typeId;
    private Integer industryId;
    private Date startTime;
    private Date endTime;
}
