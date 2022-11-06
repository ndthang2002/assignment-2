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
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="products")
//@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
//	private static final long serialVersionUID = 7156526077883281623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;

	private String name;
		
	private String image;
	
	private double price;
	
//	Date createdate = new Date();
		
//	@Column(name="available")
//	private String available;
	
    @ManyToOne
	@JoinColumn(name="categoryid")
	Category category;
 public void setcategori(Category id)
 {
	 this.category= id;
 }
//	@Column(name="CreateDate")
//	private Object createDate;
//	@Temporal(TemporalType.DATE)
	

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Category
	

	

}