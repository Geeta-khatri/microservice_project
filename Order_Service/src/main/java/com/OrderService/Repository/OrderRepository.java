package com.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OrderService.Entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
