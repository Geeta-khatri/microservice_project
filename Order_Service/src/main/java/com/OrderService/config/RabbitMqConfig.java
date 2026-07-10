package com.OrderService.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	
	public static final String Order_Queue="order.queue";
	public static final String Order_Echange="order.exchange";
	public static final String Order_Routing_key="order.created";
	
	@Bean
	public Queue queue() {
		return new Queue(Order_Queue,true);
	}

	@Bean
	public DirectExchange Exchange() {
		return new DirectExchange(Order_Echange);
	}
	
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Order_Routing_key);
	}
	
	
	@Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
	
}
