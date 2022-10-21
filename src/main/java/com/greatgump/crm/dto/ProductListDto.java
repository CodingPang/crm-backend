package com.greatgump.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {
    private Long id;
    private String product;
    private String productId;
    private String productSize;
    private Double price;
    private Long company;

}
