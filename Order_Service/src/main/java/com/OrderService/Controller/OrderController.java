package com.OrderService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OrderService.DTO.OrderReqDTO;
import com.OrderService.Entity.Orders;
import com.OrderService.Service.OrderService;

import lombok.RequiredArgsConstructor;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	
	
	private final OrderService orderService;
	
	@GetMapping("/hello")
	public String getHelloOrder() {
		return "Hello from Order";
	}
	
	//public String placeOrder(@RequestParam int productCode, 
    //@RequestParam int quantity) {

	@PostMapping("/placeOrder")
    public String placeOrder(@RequestBody OrderReqDTO orderReqDTO) {

        return orderService.OrderReq(orderReqDTO);
    }
	
	
	@GetMapping("/AllOrder")
	public ResponseEntity<List<Orders>>  getAllOrders(){
		return orderService.AllOrders();
	}
}

