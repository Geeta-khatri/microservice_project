package com.OrderService.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name="InventoryService")
public interface InventoryClient {
	@GetMapping("/products/inventory/check")
	public boolean isInStock(@RequestParam int productCode,
	                         @RequestParam int quantity) ;
	
	@PutMapping("/products/reduce")
	public ResponseEntity<String> reduceStock(@RequestParam int productCode,
            @RequestParam int quantity);
}
