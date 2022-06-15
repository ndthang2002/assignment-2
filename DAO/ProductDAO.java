package com.thang.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thang.entity.Product;

public interface ProductDAO  extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where category.id = ?1")
	List<Product> findByCategoryId(String category);
	@Query("SELECT p FROM Product p WHERE id=?1")
	Product findByProductId(Integer id);
}
