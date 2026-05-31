package com.OrderService.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.OrderService.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer productId;
	private int quantity;
	private Double price;
	private Integer userId;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;   // CREATED, FAILED, CANCELLED
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	
	
	
	
}
