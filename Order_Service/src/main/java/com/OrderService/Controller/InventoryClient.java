package com.OrderService.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="InventoryService")
public interface InventoryClient {
	@GetMapping("/products/inventory/check")
	public boolean isInStock(@RequestParam int productCode,
	                         @RequestParam int quantity) ;
}
