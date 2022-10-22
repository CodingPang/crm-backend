package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractUpdateDto {
    private Long id;
    private Long customerId;
    private String customer;
    private Long ourSignatoryId;
    private String username;
    private Long salerId;
    private String saler;
    private Long contacts;
    private String contactsName;
    private String payMethod;
    private Date payDate;
    private Date signingDate;


}
