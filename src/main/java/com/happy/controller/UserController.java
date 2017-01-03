package com.happy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.happy.model.Category;
import com.happy.model.Product;
import com.happy.model.User;
import com.happy.services.CategoryService;
import com.happy.services.ProductService;
import com.happy.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;	
	
	@Autowired
	CategoryService categoryService;	

	public String username;

	@ModelAttribute
	public String getuserdata(HttpServletRequest req) {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		String name = au.getName();
		HttpSession ses = req.getSession();
		ses.setAttribute("u", name);
		username = (String) ses.getAttribute("u");
		System.out.println((String) ses.getAttribute("u"));
		return name;

	}

	@RequestMapping("/login")
	public String gotologin(@RequestParam(value="error",required = false) String error, @RequestParam(value="logout",required = false) String logout, Model model) 
	{
		
		if(error!=null)
		{
			model.addAttribute("error","Invalid username or password!");
		}
		if(logout!=null)
		{
			model.addAttribute("msg", "You have logged out successfully...");
		}
		return  "loginvalid";
  	}
	
		
	

	@RequestMapping("productPage")
	public ModelAndView productPage(@ModelAttribute ("prod")Product prod,Model m){
		List<Product> prodLt=productService.getList();
		List<Product> prods=new ArrayList<Product>();
		for(Product p:prodLt)
		{
			if(p.getStock()!=0)
			{
				prods.add(p);
			}
		}
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("productPage","listProd",prods);
	}

	@RequestMapping("viewThatProduct")
	public ModelAndView toViewOnlyThatProduct(@ModelAttribute ("prod")Product prod,@RequestParam int id,Model m){
		prod=productService.getRowById(id);
		m.addAttribute("product", prod);
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewThatProduct");
	}

	@RequestMapping("categoryPage")
	public ModelAndView categoryPage(@ModelAttribute("cat")Category cat,@RequestParam int id,Model m){
		List<Product> prodLt=productService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		m.addAttribute("category", categoryService.getRowById(id));
		List<Product> list2disp=new ArrayList<Product>();
		for(Product p:prodLt)
		{
			if((p.getCid()==id)&&(p.getStock()!=0))
			{
				list2disp.add(p);
			}
		}
		return new ModelAndView("categoryPage","listProd",list2disp);
	}
	
	/*@RequestMapping("CartPage")
	public ModelAndView cartPage(@ModelAttribute ("prod")Product prod,Model m){
		List prodLt=productService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("CartPage","listProd",prodLt);
	}*/
	
	@RequestMapping("CashPayment")
	public String payNow(Model m){
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return "CashPayment";
	}
	
	//Mapping4web-flow To Validate SignUp Page
	
		@RequestMapping("home")
		public ModelAndView home(Model m){
			List catLt=categoryService.getList();
			m.addAttribute("listCate", catLt);
			return new ModelAndView("index");
		}
		
		@RequestMapping("UserPage")
		public ModelAndView userPage(/*@ModelAttribute ("user")User user,*/Model m){
			List catLt=categoryService.getList();
			m.addAttribute("listCate", catLt);
			//m.addAttribute("userName", username);
			User user=new User();
			List<User> userLt=userService.getList();
			for(User u:userLt)
			{
				if(u.getUserName().equals(username))
				{
					user=userService.getRowById(u.getUid());
					break;
				}
			}
			m.addAttribute("user", user);
			return new ModelAndView("UserPage");
		}				
}
