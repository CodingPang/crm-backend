package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Synchronized;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OfferSearchDto implements Serializable {
    private int current;
    private int size;
    private String customerName;
    private Date start;
    private Date end;
}
