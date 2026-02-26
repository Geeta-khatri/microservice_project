package com.Inventory_Service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory_Service.Service.stock_Inventory_service;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class stock_Inventory_Controller {

	private final stock_Inventory_service stock_service;
	
	@GetMapping("/AllProduct")
	public ResponseEntity<?> getAllProduct(){
		return stock_service.AllProduct();
	}
	
	
	@GetMapping("/inventory/check")
	public boolean isInStock(@RequestParam int productCode,
	                         @RequestParam int quantity) {
		return stock_service.checkStock(productCode,quantity);
	}
	
//	@GetMapping("/Product/{id}")
//	public ResponseEntity<?> getProductById(@PathVariable int id){
//		return stock_service.ProductById(id);
//		
//	}
}
