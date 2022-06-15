package com.thang.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import com.thang.entity.giohang;
@SessionScope
@Service

public class ShoppingCartServiceImpl implements ShoppingCartService{
 
	Map<Integer, giohang> map = new HashMap<>();
	@Override
	public giohang add(Integer id) {
		// TODO Auto-generated method stub
		
		giohang item = map.get(id);
		
			map.put(id, item);
	
		
		return item;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		map.remove(id);
		
	}

	@Override
	public giohang update(Integer id, int quantity) {
		// TODO Auto-generated method stub
		giohang item = map.get(id);
		item.setQuantity(quantity);
		return item;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
		
	}

	@Override
	public Collection<giohang> getProducts() {
		// TODO Auto-generated method stub
		return map.values();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return map.values().stream().mapToInt(item -> item.getQuantity())
				.sum();
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return map.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity())
				.sum();
		
	}

}
