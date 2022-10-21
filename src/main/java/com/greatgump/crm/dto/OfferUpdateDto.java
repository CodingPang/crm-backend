package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferUpdateDto {
    private Long id;
    private Long customerId;
    private String customer;
    private Long saleId;
    private String saler;
    private Long contactsId;
    private String contact;

}
