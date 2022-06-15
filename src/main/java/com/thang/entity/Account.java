package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the Accounts database table.
 * 
 */
@Data
@Entity
@Table(name="Accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Username")
	private String username;

	@Column(name="Activated")
	private boolean activated;

	@Column(name="Admin")
	private boolean admin;

	@Column(name="Email")
	private String email;

	@Column(name="Fullname")
	private String fullname;

	@Column(name="Password")
	private String password;

	@Column(name="Photo")
	private String photo;

	//bi-directional many-to-one association to Authority
	@OneToMany(mappedBy="account")
	private List<Authority> authorities;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="account")
	private List<Order> orders;

	
}