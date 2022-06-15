package com.thang.service;

import java.util.Collection;

import com.thang.entity.Product;
import com.thang.entity.giohang;

public interface ShoppingCartService {
	giohang add(Integer id);
 
 void remove(Integer id);
 
 giohang update(Integer id ,int quantity );
	
 void clear();
 
 Collection<giohang> getProducts();
  
 int getCount();
 
 
 double getAmount();
}
