package com.thang.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;
import org.springframework.web.context.annotation.SessionScope;

import com.thang.DAO.ProductDAO;
import com.thang.bean.Item;
import com.thang.entity.Product;

//@SessionScope
@Service

public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ProductDAO pdao;

	Map<Integer, Item> map = new HashMap<>();

	@Override
	public Item add(Integer id) {
		System.out.println("so nguyen day :" + id);
		Item item = map.get(id);
//			int idd = id;
Product p = pdao.getById(id);
			System.out.println(p.getName());
     	if (item == null) {

			
			Item i = new Item();
			i.setId(p.getId());
			i.setName(p.getName());
			i.setPrice(p.getPrice());
			i.setImage(p.getImage());
			item = i;	
			item.setQty(1);
			map.put(id, item);

		} else {
			item.setQty(item.getQty() + 1);
		}
//		
//			if(item != null) {
//			
//			Product p =pdao.findByProductId(idd);
//			Item i = new Item();
//			i.setId(p.getId());
//			i.setName(p.getName());
//			i.setPrice(p.getPrice());
//			i.setImage(p.getImage());
//			item = i;
//			item.setQty(1);
//			map.put(id,	 item);
//			
//		
//		} else {
//			item.setQty(item.getQty() + 1);
//		}
//	
//			return item;
	return item;

		
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
	}

	@Override
	public Item update(Integer id, int qty) {
		Item item = map.get(id);
		item.setQty(qty);
		return item;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return map.values();

	}

	@Override
	public int getCount() {
		return map.values().stream().mapToInt(item -> item.getQty()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getPrice() * item.getQty()).sum();
	}
}
