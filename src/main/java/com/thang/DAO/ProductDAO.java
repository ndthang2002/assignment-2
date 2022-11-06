package com.thang.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thang.bean.Item;
import com.thang.entity.Product;
public interface ProductDAO  extends JpaRepository<Product, Integer>{
    
	@Query("select p from Product p where p.category.id = ?1")
	List<Product> findByCategoryId(Integer category);
	
	@Query("SELECT p FROM Product p WHERE p.id=?1")
	Product findByProductId(Integer id);
	
}
