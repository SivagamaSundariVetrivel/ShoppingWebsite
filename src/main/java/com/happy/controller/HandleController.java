package com.happy.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.happy.services.CategoryService;
import com.happy.services.ProductService;


@Controller
public class HandleController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	
	public HandleController()
	{
		System.out.println("inside controller");
	}
	
	@RequestMapping("/")
	public ModelAndView homePage(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("index");
	}
	
	@RequestMapping("/index")
	public ModelAndView gotohome(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("index");
	}

	@RequestMapping("/homeout")
	public ModelAndView gotohomeout(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("homeout");
	}

	@RequestMapping("/infoout")
	public ModelAndView gotoinfo(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("infoout");
	}

	@RequestMapping("/info")
	public ModelAndView gotoAbtus(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("info");
	}

	/*@RequestMapping("/addComment")
	public ModelAndView toAddComment(@ModelAttribute("cmt")Comment cmt,Model m)
	{
		commentService.insertRow(cmt);
		List cmts=commentService.getList();
		m.addAttribute("cmtList",cmts);
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("info");
	}*/
	
	@RequestMapping("/loginvalid")
	public ModelAndView gotoInvalidLog(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("loginvalid");
	}

	
	@RequestMapping("/product")
	public ModelAndView gotoProduct(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		List prodLt=productService.getList();
		return new ModelAndView("product","listProd",prodLt);
	}
	
	@RequestMapping("/category")
	public String gotoCategory(Model m)
	{	
		return "category";
	}
	
	

	/*@RequestMapping(value="/ThankU",method=RequestMethod.POST)
	public String toThankU(HttpServletRequest req,Model m)
	{
		//check all the details in the pay now page and preform all the transactions for bank
		//to validate the pay now form
		String cardName=req.getParameter("name");
		String cardNo=req.getParameter("cardNo");
		
		String mm=req.getParameter("month");
		String yy=req.getParameter("year");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH);
		int mth=Integer.parseInt("mm");
		int yth=Integer.parseInt("yy");
		
		 for(char c : cardName.toCharArray()){
		        if(Character.isDigit(c)){  
		        	m.addAttribute("errorNme", "Enter valid card name");
		        	break;  
		        } 
		 }
		 for(char c : cardNo.toCharArray()){
		        if(Character.isDigit(c)){  
		        } else
		        {
		            m.addAttribute("errorNo", "Enter valid CardNo.");
		             break;            
		        }
		 }
		 
		 if(m==null)
		 {
			 return("ThankU");
		 }
		 else
		 {
			 return("CashPayment");
		 }
		 }*/
}
