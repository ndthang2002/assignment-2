package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Orders database table.
 * 
 */
@Data
@Entity
@Table(name="Orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private long id;

	@Column(name="Address")
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")	
	Date createDate = new Date();

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="Username")
	private Account account;

	
}