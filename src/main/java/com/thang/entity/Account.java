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
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	private String username;

	
	private boolean activated;

	
	private boolean admin;

	
	private String email;

	
	private String fullname;

	
	private String password;

	
	private String photo;

	//bi-directional many-to-one association to Authority
	@OneToMany(mappedBy="account")
	private List<Authority> authorities;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="account")
	private List<Order> orders;

	
}