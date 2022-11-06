package com.thang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	Integer id;
	String image;
	String name;
	double price;
	int qty = 1;
}
