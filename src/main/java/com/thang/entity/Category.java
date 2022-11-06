package com.thang.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the Categories database table.
 * 
 */
@Data
@Entity
@Table(name="categories")
//@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private int id;


	private String name;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Product> products;

	

}