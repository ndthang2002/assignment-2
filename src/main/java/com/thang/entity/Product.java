package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Products database table.
 * 
 */
@Data
@Entity
@Table(name="Products")
//@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Available")
	private boolean available;

//	@Column(name="CreateDate")
//	private Object createDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createDate = new Date();
	
	@Column(name="Image")
	private String image;

	@Column(name="Name")
	private String name;

	@Column(name="Price")
	private double price;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "Categoryid")
	Category category;

	public static Product get(Integer id2) {
		// TODO Auto-generated method stub
		return null;
	}
	

}