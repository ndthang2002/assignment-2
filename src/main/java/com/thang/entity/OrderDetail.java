package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the OrderDetails database table.
 * 
 */
@Data
@Entity
@Table(name="OrderDetails")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="Price")
	private double price;

	@Column(name="Quantity")
	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="Productid")
	private Product product;

	

}