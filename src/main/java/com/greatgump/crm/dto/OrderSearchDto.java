package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchDto {
    private int current;
    private int size;
    private String title;
    private Long status;
    private Date start;
    private Date end;
}
