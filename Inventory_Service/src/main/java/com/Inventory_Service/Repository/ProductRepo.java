package com.Inventory_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory_Service.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	 @Query("select p.quantity from Product p  where p.id=:productId")
	int findQuantityById(@Param("productId") int productId  );

}
