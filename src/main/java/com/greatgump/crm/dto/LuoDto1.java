package com.greatgump.crm.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LuoDto1 {
    private Long id;
    private String product_name;
    private String product_code;
    private String unit;
    private Double price;


}
