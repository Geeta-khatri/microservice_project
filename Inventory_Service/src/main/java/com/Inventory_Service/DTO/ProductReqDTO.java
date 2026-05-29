package com.Inventory_Service.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductReqDTO {

	
	private String name;

    private String description;
    private Integer quantity;
    private Double price;
}
