package com.thang.controller;



import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.thang.DAO.CategoryDAO;
import com.thang.DAO.OrderDAO;
import com.thang.DAO.ProductDAO;
//import com.thang.DAO.ProductDetailDAO;
import com.thang.entity.Account;
import com.thang.entity.Category;
import com.thang.entity.Order;
import com.thang.entity.Product;


@Controller
public class BuyProduct {
	@Autowired
	  CategoryDAO dao;
//	@Autowired
//	ProductDetailDAO dao_detail;
	@Autowired
	ProductDAO dao_product;
	@Autowired
	OrderDAO dao_order;
	AccountController accounts;
	@Autowired
	ServletContext app;
	//lấy ảnh  tài khoản
	AccountController acc;
	@Autowired
  HttpServletRequest request;
	@Autowired
	com.thang.service.ShoppingCartService cart;
//	theêm sản phẩm vào giỏ hàng
	
	 @PostMapping(value="/addtocart",params = ("idsanpham"))
	 public String addtocart(Model model ,@RequestParam("idsanpham") int id,@RequestParam("size") String size ,@RequestParam("color") String color,
			 @RequestParam("quantity") Integer quantity) {
		 System.out.println("id: "+id);
          Product sanpham = dao_product.findByProductId(id);
//          HttpSession session = request.getSession();
//         session.setAttribute("name", sanpham.getName());
//		 session.setAttribute("id", id);
//		 session.setAttribute("image", sanpham.getImage());
//		 session.setAttribute("price", sanpham.getPrice());
//		 session.setAttribute("size",size);
//		 session.setAttribute("color", color);
//		 session.setAttribute("quantity", quantity);		 		 
//         model.addAttribute("id",id);
//		 System.out.println("them thanh cong");
     
		 

//		System.out.println(order);
//		 System.out.println(size);
//		 System.out.println(color);
//		 System.out.println(quantity);
		 cart.add(id);
		 System.out.println("them thanh cong");

       		
		return ("/template/shoping-cart");
		
		
	 }
		@RequestMapping("/shoping-cart")
		public String show7( Model model) {
			List<Category> lists = dao.findAll();
			model.addAttribute("lists",lists);			
			model.addAttribute("avt",acc.accountt);
		List<Order> order = dao_order.findAll();
//		HttpSession session =request.getSession();
//		String price= session.getAttribute("price").toString();
//		model.addAttribute("price",price);
//					
			return "/template/shoping-cart";
		}
}
