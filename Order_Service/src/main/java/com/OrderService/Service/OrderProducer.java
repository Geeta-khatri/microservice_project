package com.OrderService.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.OrderService.Entity.Orders;
import com.OrderService.config.RabbitMqConfig;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderProducer {

	private final RabbitTemplate rabbitTemplate;
	
	
	public OrderProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate=rabbitTemplate;
	}
	
	
	
	public void send(Integer userId) {
		log.debug("inside send of OrderProducer"+userId);
		rabbitTemplate.convertAndSend(RabbitMqConfig.Order_Echange, RabbitMqConfig.Order_Routing_key,userId );
	}
	
	@PostConstruct
	public void test() {
	    System.out.println("RabbitTemplate = " + rabbitTemplate);
	}
	
	
}
