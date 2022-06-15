package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the Authorities database table.
 * 
 */
@Data
@Entity
@Table(name="Authorities")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="Username")
	private Account account;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleId")
	private Role role;

	
}