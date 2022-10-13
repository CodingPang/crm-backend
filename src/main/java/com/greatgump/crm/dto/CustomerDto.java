package com.greatgump.crm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greatgump.crm.entity.Contact;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CustomerDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String customerName;
    private String userName;
    private String typeName;
    private String industryName;
    private String province;
    private String cityName;
    private String scope;
    private String sourceName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date createTime;
    List<Contact> contacts;
}
