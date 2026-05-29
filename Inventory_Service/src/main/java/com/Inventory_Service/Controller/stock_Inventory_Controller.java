package com.Inventory_Service.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory_Service.DTO.ProductReqDTO;
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
	
	@GetMapping("/Product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id){
		return stock_service.ProductById(id);
		
	}
	
	@PutMapping("/reduce")
	public ResponseEntity<String> reduceStock(@RequestParam int productCode,
            @RequestParam int quantity){
		return stock_service.stockReduce(productCode,quantity );
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>UpdateStock(@RequestParam int productCode,
            @RequestParam int quantity){
		return stock_service.stockUpdate(productCode,quantity );
		
	}
	
	@PostMapping("/add/products")
	public ResponseEntity<String> addProductList(@RequestBody List<ProductReqDTO> prod){
		 stock_service.appProducts(prod);
		return ResponseEntity.status(HttpStatus.OK).body("Products added successfully"); // returning ResponseEntity here as it is a good practise
		
	}
}
