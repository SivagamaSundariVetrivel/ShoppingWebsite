package com.happy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.happy.model.Category;
import com.happy.model.Product;
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
	
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public ModelAndView validateLogin(HttpServletRequest req,Model m)
	{
		String u=req.getParameter("username");
		String pass=req.getParameter("password");
		String use="admin";
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
//			List<User> users=userService.getList(); 
//			if(users==null)
//			{
				if((u.equals("admin"))&&(pass.equals("admin")))
				{
					//m.addAttribute("userName", use);
					return new ModelAndView("adminHome","userName", use);
			}
				else
				{
					//m.addAttribute("noSuchUsr","Invalid user or password");
					return new ModelAndView("adminLogin","noSuchUsr","Invalid admin or password");
				}	
			}
			/*else
			{
				for(User us:users)
				{
					if((us.getEmail().equals(u))&&(us.getPassword().equals(pass)))
					{
						m.addAttribute("userName",us.getUserName());
						return new ModelAndView("userIndex");					}
			}
			}
	}*/
		
	

	@RequestMapping("productPage")
	public ModelAndView productPage(@ModelAttribute ("prod")Product prod,Model m){
		List prodLt=productService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("productPage","listProd",prodLt);
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
			if(p.getCid()==id)
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
		
				
}
