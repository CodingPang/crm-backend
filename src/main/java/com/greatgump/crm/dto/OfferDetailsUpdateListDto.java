package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDetailsUpdateListDto {
    private int id;
    private int current;
    private int size;
    private int orderid;
}
