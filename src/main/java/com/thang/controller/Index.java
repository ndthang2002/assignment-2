package com.thang.controller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thang.DAO.CategoryDAO;
import com.thang.DAO.ProductDAO;
import com.thang.entity.Category;
import com.thang.entity.Product;
import com.thang.service.ParamService;

@Controller
public class Index {
  @Autowired
  CategoryDAO dao;
  @Autowired
  ProductDAO dao_product;
  @Autowired
  ParamService param;
  
  AccountController acc;
  
	@RequestMapping(value="index")
	public String index(Model model ) {
		
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
			System.out.println(lists.size());
		List<Product> product = dao_product.findAll();//s1
		model.addAttribute("product",product);
//							
		model.addAttribute("avt",acc.accountt);
		
	
		return "/template/index";
	}
	//Tim chi tiet san pham theo id san pham

	@RequestMapping(value="/index#?idsanpham={id}",params="idsanpham")
	public String productdetail(Model model ,  @PathVariable(value="id" ) int id) {
//		List<Product> productdetail = dao_product.findByProductId(id);
//		model.addAttribute("productdetail",productdetail);
        System.out.println(id);
		List<Product> product = dao_product.findAll(); //s2
		model.addAttribute("product",product);	
		
		return "/template/index";
	}
	

	
	
	@RequestMapping(value="/product-detail",params="idsanpham")
	public String productdetail1(Model model ,@RequestParam("idsanpham") Integer id) {
		  System.out.println("id: "+id);
		Product productdetail = dao_product.findByProductId(id);
		  Product productdetaill = dao_product.getById(id);//s3
		model.addAttribute("productdetail",productdetail);
       
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		List<Product> product = dao_product.findAll();
		model.addAttribute("product",product);	
		model.addAttribute("avt",acc.accountt);
		return "/template/product-detail";
	}
	
	@RequestMapping(value="/product",params="loaisanpham")
	public String list(Model model, @RequestParam("loaisanpham")String id) {		
		System.out.print("id: "+id);
		if(id=="") {
			List<Product> product = dao_product.findAll();//s4
			model.addAttribute("product",product);
		}
		else {	
			List<Category> lists = dao.findAll();
			model.addAttribute("lists",lists);
			List<Product> product = dao_product.findByCategoryId(id);	 //loi day
			model.addAttribute("product",product);
			model.addAttribute("avt",acc.accountt);
		}
		return "/template/product";	
	}
	
	@RequestMapping("/product")
	public String show( Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		
		List<Product> product = dao_product.findAll();  //s6
		model.addAttribute("product",product);
		model.addAttribute("avt",acc.accountt);
		return "/template/product";
	}
	@RequestMapping("/about")
	public String show1(Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		model.addAttribute("avt",acc.accountt);
		return "/template/about";
	}
	@RequestMapping("/blog")
	public String show2(Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		model.addAttribute("avt",acc.accountt);
	
		return "/template/blog";
	}
	
	@RequestMapping("/blog-detail")
	public String show3(Model model) {
		model.addAttribute("avt",acc.accountt);
		return "/template/blog-detail";
	}
	@RequestMapping("/contact")
	
	public String show4( Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);
		model.addAttribute("avt",acc.accountt);
		return "/template/contact";
	}
	@RequestMapping("/header")
	public String show5() {
		return "/template/header";
	}
	@RequestMapping("/product-detail")
	public String show6(Model model) {
		List<Category> lists = dao.findAll();
		model.addAttribute("lists",lists);	
		model.addAttribute("avt",acc.accountt);
		return "/template/product-detail";
	}

	
	
}
