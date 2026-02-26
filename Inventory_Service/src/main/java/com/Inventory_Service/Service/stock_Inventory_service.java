package com.Inventory_Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inventory_Service.Entity.Product;
import com.Inventory_Service.Repository.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class stock_Inventory_service {

	private final ProductRepo prepo;
	
//	public ResponseEntity<?> ProductById(int id) {
//		Optional<List<Product>> AllProduct=prepo.findAllById(id);
//		return ;
//	}
	
	public ResponseEntity<?> AllProduct() {
		List<Product> p =prepo.findAll();
		return  ResponseEntity.status(HttpStatus.OK).body(p);
	}

	public boolean checkStock(int productId, int  quantity) {
		int present_quantity = prepo.findQuantityById(productId);
		return present_quantity>=quantity;
	}

	
}
