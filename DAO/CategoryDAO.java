package com.thang.DAO;


import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thang.entity.Category;




public interface CategoryDAO extends JpaRepository<Category, String>{
	@Query("SELECT c FROM Category c where c.id=?1")
	List<Category> finbya(String id);
}