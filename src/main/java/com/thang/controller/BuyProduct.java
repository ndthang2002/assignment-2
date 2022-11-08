package com.thang.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.thang.DAO.CategoryDAO;
import com.thang.DAO.OrderDAO;
import com.thang.DAO.ProductDAO;
//import com.thang.DAO.ProductDetailDAO;

import com.thang.entity.Category;
import com.thang.entity.Order;
import com.thang.entity.Product;
import com.thang.service.ShoppingCartService;


@Controller
public class BuyProduct {
	@Autowired
	CategoryDAO dao_category;
	
//	@Autowired
//	ProductDetailDAO dao_detail;
	
	@Autowired
	ProductDAO dao_productt;
	
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
	ShoppingCartService cart;
    
//	theêm sản phẩm vào giỏ hàng
	
	@RequestMapping(value="/addtocart", params="id")
	 public String addtocart(Model model ,@RequestParam("id") Integer id) {
//		 System.out.println("id cua detail: "+id);
//        
		 cart.add(id);
//		 System.out.println("them thanh cong");
         
       		
		return ( "redirect:/shoping-cart");
		
	 }
		@RequestMapping("/shoping-cart")
		public String show7( Model model) {
//			List<Category> lists = dao_category.findAll();
//			model.addAttribute("lists",lists);			
//			model.addAttribute("avt",acc.accountt);
//		List<Order> order = dao_order.findAll();
//		HttpSession session =request.getSession();
//		String price= session.getAttribute("price").toString();
//		model.addAttribute("price",price);
//			model.addAttribute("count", cart.getCount());
//			model.addAttribute("amount",cart.getAmount());
//		model.addAttribute("cart",cart);
						List<Category> lists = dao_category.findAll();
			model.addAttribute("lists",lists);
			model.addAttribute("items", cart.getItems());
		return "/template/shoping-cart";
		}
		
		@GetMapping("/productcontrol")
		public String procontrol(Model model) {
			
			List<Category> lists = dao_category.findAll();
			model.addAttribute("lists",lists);
			List<Product> product = dao_productt.findAll();  //s6
			model.addAttribute("product",product);
			
			return "/template/crud";
		}
		@PostMapping("/addProduct")
		public String addproduct(Model model ,
				@RequestParam("id") int id,
				@RequestParam("name") String name,
				@RequestParam("photo") MultipartFile photo,
				@RequestParam("price") double price,
				@RequestParam("categoryid") int categoryid)		
		{
			System.out.println(categoryid);
	       Category category = dao_category.getById(categoryid);
			System.out.println(category.getName());
			System.out.println("category nha ae:"+categoryid);
			System.out.println(id);
			System.out.println(name);
			System.out.println(photo.getOriginalFilename());
			System.out.println(price);
			System.out.println(categoryid);
			
//				Product newpro = new Product();
//			newpro.setId(id);
//			newpro.setName(name);
//			newpro.setImage(photo.getOriginalFilename());
//			newpro.setPrice(price);
//		    newpro.setCategory(categoryid);
//			dao_productt.save(newpro);
				try {
					dao_productt.createProduct(id, name, photo.getOriginalFilename(), price, category);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(" khong ket qua ta ve");
				}			
			try {			
					String filename = photo.getOriginalFilename();
					// String path = app.getRealPath("/images/"+filename);
					File file = new File(app.getRealPath("/images/" + filename));
					photo.transferTo(file);
					model.addAttribute("name", photo.getOriginalFilename());
					model.addAttribute("type", photo.getContentType());
					model.addAttribute("size", photo.getSize());

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("loi luu file");
				}
			return "redirect:/productcontrol";	
		}
		@GetMapping(value="/delete", params="id")
		public String delete(@RequestParam("id") int id) {
			dao_productt.deleteById(id);
			return "redirect:/productcontrol";			
		}
		@GetMapping(value="/edit", params="id")
		public String edit(@RequestParam("id") int id) {
			
			return "redirect:/productcontrol";		
		}
		
		
}
