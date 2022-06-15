package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the Roles database table.
 * 
 */
@Data
@Entity
@Table(name="Roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Authority
	@OneToMany(mappedBy="role")
	private List<Authority> authorities;


}