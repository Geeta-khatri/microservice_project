package com.Inventory_Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inventory_Service.Entity.Product;
import com.Inventory_Service.Repository.ProductRepo;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class stock_Inventory_service {

	private static final Logger log =
            LoggerFactory.getLogger(stock_Inventory_service.class);
	
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

	public ResponseEntity<?> ProductById(int id) {
		Product pExists=prepo.findById(id).orElse(null);
		if(pExists!=null) {
			return  ResponseEntity.status(HttpStatus.OK).body(pExists);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product exists with given id");
	
	}

	public ResponseEntity<String> stockUpdate(int productId, int  quantity) {
		log.info("entered stockUpdate service");
		log.info("input is "+productId +"and "+quantity);

		Optional<Product> product=prepo.findById(productId);
		if(product.isPresent()) {
			Product pExist=product.get();
			pExist.setQuantity(pExist.getQuantity()-quantity);
			log.info("quantity is "+pExist.getQuantity());
			prepo.save(pExist);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Inventory updated successfully ");
	}

	
}
