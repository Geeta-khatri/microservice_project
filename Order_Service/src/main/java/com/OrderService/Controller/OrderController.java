package com.OrderService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	private final InventoryClient inventoryClient;
	@GetMapping("/hello")
	public String getHelloOrder() {
		return "Hello from Order";
	}
	
	
	@PostMapping("/placeOrder")
    public String placeOrder(@RequestParam int productCode, 
                             @RequestParam int quantity) {

        // This is synchronous — thread waits here until Inventory Service responds
        boolean inStock = inventoryClient.isInStock(productCode, quantity);

        if (inStock) {
            // Normally call OrderService logic to save order here
        	//inventoryClient.placeOrder(productCode, quantity);
        	ResponseEntity<String> response=inventoryClient.reduceStock(productCode,quantity);
        	String order_stat=response.getBody();
            return "Order placed successfully!" +order_stat;
        } else {
            return "Product out of stock!";
        }
    }
}

