package com.OrderService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/placeOrder")
    public String placeOrder(@RequestParam int productCode, 
                             @RequestParam int quantity) {

        // This is synchronous — thread waits here until Inventory Service responds
        boolean inStock = inventoryClient.isInStock(productCode, quantity);

        if (inStock) {
            // Normally call OrderService logic to save order here
            return "Order placed successfully!";
        } else {
            return "Product out of stock!";
        }
    }
}

