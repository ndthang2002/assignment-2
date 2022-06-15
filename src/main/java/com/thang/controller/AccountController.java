package com.thang.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.metadata.CallMetaDataContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thang.DAO.AccountDAO;
import com.thang.entity.Account;
import com.thang.service.CookieService;
import com.thang.service.ParamService;

@Controller
public class AccountController {
	@Autowired
	AccountDAO dao_acount;
	@Autowired
	HttpServletResponse response;
	@Autowired
	ParamService param;
	@Autowired
	CookieService cookie;
	@Autowired
	ServletContext app;
	@Autowired
	JavaMailSender mailer;
 static Account accountt ;
//	static public boolean trangthai;
	@RequestMapping("/my-account")
	public String show_acount() {
		return "/template/shoping-cart";
	}

	@RequestMapping("/admin")
	public String showadmin() {
		return "template-admin/admin";
	}

	@RequestMapping("/account/login")
	public String show8(Model model) {

		if (cookie.get("user") == null) {
			model.addAttribute("check", "");
			return "/template/account/login";
		} else {

			String user = cookie.get("user").getValue();
			String pass = cookie.get("pass").getValue();
			System.out.println(user);
			System.out.println(pass);

			model.addAttribute("user", user);
			model.addAttribute("pass", pass);
			model.addAttribute("check", "checked");

			return "/template/account/login";

		}

	}

	@PostMapping("/account/login")
	public String dangnhap(Model model, RedirectAttributes params, @RequestParam("username") String user, @RequestParam("password") String pass

	) {
		if (user.length() == 0 && pass.length() == 0) {
			model.addAttribute("message", "vui long nhap thong tin day du");
		} else {

			System.out.println(user);
			System.out.println(pass);

			boolean remember = param.getBoolean("check", false);
//		boolean active =  account).isActivated();
			Account accounts = dao_acount.findAccountsByUsername(user, pass);
           
			if (accounts == null) {
				model.addAttribute("message", "sai tai khoan hoac mat khau ");
			} else {

				if (remember == true) {

					cookie.add("user", user, 720);
					cookie.add("pass", pass, 720);
					if (accounts.isAdmin() ==true) {
                       
						return "redirect:/admin";
					} else {
						 
                        accountt = accounts;
						return "redirect:/index";
					}
				} else {
					cookie.remove("user");
					cookie.remove("pass");

					if (accounts.isAdmin() == false) {

						return "redirect:/admin";
					} else {
						return "redirect:/index";
					}

				}

			}
		}
		return "/template/account/login";
	}

	@RequestMapping("/account/signup")
	public String show9() {
		return "/template/account/signup";
	}

	@PostMapping("/account/signup")
	public String signup(Model model,@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("password") String pass, @RequestParam("fullname") String fullname,
			@RequestParam("photo") MultipartFile photo
			) {
		Account account = new Account();
		account.setUsername(username);
		account.setEmail(email);
		account.setPassword(pass);
		account.setFullname(fullname);
		account.setPhoto(photo.getOriginalFilename());
      
			dao_acount.save(account);
			
		model.addAttribute("user",username);
		model.addAttribute("pass",pass);
		try {
			String filename = photo.getOriginalFilename();
		//String path = app.getRealPath("/images/"+filename);
		File file = new File(app.getRealPath("/images/"+filename));
		photo.transferTo(file);
		model.addAttribute("name", photo.getOriginalFilename());
		model.addAttribute("type", photo.getContentType());
		model.addAttribute("size", photo.getSize());
	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi luu file");
		}
		

		
		return "/template/account/login";
	}

	@RequestMapping("/account/setting")
	public String show10() {
		return "/template/account/setting_account";
	}

	@RequestMapping("/account/myaccount")
	public String show11() {
		return "/template/account/my_account";
	}
	@RequestMapping("/account/forgotpassword")
	public String forgotpass() {
		
	
		return "/template/account/forgotpassword";
	}
	@PostMapping("/account/forgotpassword")
	public String forgot(Model model ,@RequestParam("username" ) String user,@RequestParam("email") String email) {
		System.out.println(user);
		System.out.println(email);
		Account account = dao_acount.finallbyusername(user);
		if(account==null) {
			
			model.addAttribute("message","tai khoan khong ton tai");
			model.addAttribute("username",user);
		}
		else if(!email.equals(account.getEmail())){
			model.addAttribute("username",user);
			model.addAttribute("email",email);
			System.out.println(account.getEmail());
		     model.addAttribute("emailerror","email không trùng với tài khoản");
		}else {
			try {
				
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom("nguyendinhthang23082002@gmail.com");
			helper.setTo(email);
			helper.setReplyTo("nguyendinhthang230832002@gmail.com");
			helper.setSubject("chào bạn "+account.getFullname()+"mật khẩu của bạn là :");
			helper.setText("Mật khẩu của bạn là : "+account.getPassword(),true);
			//gửi mail nè
			mailer.send(mail);
			model.addAttribute("sendmail","vui lòng check mail để nhận lại mật khẩu");
			} catch (Exception e) {
			   model.addAttribute("sedmailerror","lỗi gửi mail vui lòng kiểm tra lại ");
			}

		}
		
		return "/template/account/forgotpassword";
		
	}

}
