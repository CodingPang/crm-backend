package com.greatgump.crm.dto;

import com.greatgump.crm.entity.DataDictionary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//商机来源
@NoArgsConstructor
//@AllArgsConstructor
@Data
public class BusinessSourceDto {
    private Long businessSourceId;
    private String businessSourceName;

//    private DataDictionary
}
