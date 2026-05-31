package com.OrderService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.OrderService.Controller.InventoryClient;
import java.util.List;
import com.OrderService.DTO.OrderReqDTO;
import com.OrderService.Entity.Orders;
import com.OrderService.ExceptionHandler.InvalidOrderException;
import com.OrderService.Repository.OrderRepository;
import com.OrderService.enums.OrderStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepo;
	private final InventoryClient inventoryClient;

	
	
	public String OrderReq(OrderReqDTO orderReqDTO) {
		if(orderReqDTO== null || orderReqDTO.getQuantity()<=0) {
			
			throw new InvalidOrderException("Invalid Order Request");
		}
		
// This is synchronous — thread waits here until Inventory Service responds
		boolean inStock = inventoryClient.isInStock(orderReqDTO.getProductCode(), orderReqDTO.getQuantity());

		if (inStock) {
// Normally call OrderService logic to save order here
//inventoryClient.placeOrder(productCode, quantity);
			Orders orders=new Orders();
			orders.setProductId(orderReqDTO.getProductCode());
			orders.setQuantity(orderReqDTO.getQuantity());
			orders.setUserId(orderReqDTO.getUserId());
			orders.setStatus(OrderStatus.CREATED);
			System.out.println("orders is "+orders);
			ResponseEntity<String> response = inventoryClient.reduceStock(orderReqDTO.getProductCode(), orderReqDTO.getQuantity());
			orderRepo.save(orders);
			String order_stat = response.getBody();
			return "Order placed successfully!" + order_stat;
		} else {
			return "Product out of stock!";
		}
	}



	public ResponseEntity<List<Orders>> AllOrders() {
		List<Orders> OrdersList=orderRepo.findAll();
		return  ResponseEntity.status(HttpStatus.OK).body(OrdersList);
		}
}
