package com.happy.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.happy.model.Item;
import com.happy.model.Orders;
import com.happy.model.Product;
import com.happy.model.ShippingAddress;
import com.happy.services.CategoryService;
import com.happy.services.ItemService;
import com.happy.services.OrderService;
import com.happy.services.ProductService;

@Controller
public class CartController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
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
	
	public CartController() {
	System.out.println("cartCtrl");	// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("addToCart")
	public ModelAndView addToCart(@ModelAttribute("item")Item item,@RequestParam int id,Model m,HttpServletRequest r)
	{
		if(username.equals("anonymousUser"))
		{
			m.addAttribute("msg", "Login to add in cart");
			return new ModelAndView("loginvalid");
		}
		Product prod=productService.getRowById(id);
		List<Item> itemLt=itemService.getList();
		List<Item> items=itemLt;
		item=null;
		/*for(int i=0;i<items.size();i++)
		{
			int p=items.get(i).getProduct().getPid();
			if((items.get(i).getUserId().equals(username))&&(p==id))
			{
				item=itemService.getRowById(items.get(i).getItemId());
			}
		}*/
		/*Authentication au = SecurityContextHolder.getContext().getAuthentication();
		String name = au.getName();*/
		for(Item i:itemLt)
		{
			if((i.getUserId().equals(username))&&(i.getProduct().getPid()==id))
			{
				item=itemService.getRowById(i.getItemId());
			}
		}
		if(item==null)
		{
			item=new Item(prod,1,username);
			itemService.insertRow(item);
		}
		else
		{
			m.addAttribute("modi", "modify the quantity of product over here..");
		/*	List<Item> itemsLt=new ArrayList<Item>();
			for(Item p:itemLt)
			{
				if(p.getUserId().equals(username))
				{
					itemsLt.add(p);
				}
			}
			m.addAttribute("cart", itemsLt);
			return new ModelAndView("CartPage");*/
		}
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return new ModelAndView("CartPage");
	}
	
	@RequestMapping("CartPage")
	public String toCartPage(@ModelAttribute("item")Item item,Model m)
	{
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "CartPage";
	}

	@RequestMapping("OrdersPage")
	public String toOrderPage(Model m)
	{
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "OrdersPage";
	}
	@RequestMapping("deleteItem")
	public String deleteItem(@ModelAttribute("item")Item item,@RequestParam int id,Model m)
	{
		itemService.deleteRow(id);
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "CartPage";
	}

	@RequestMapping(value="updateItem",method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("item")Item item,Model m,HttpServletRequest r)
	{
		item=itemService.getRowById(item.getItemId());
		String n=r.getParameter("quantity");
		int q=Integer.parseInt(n);
		item.setQuantity(q);
		/*Product prod=item.getProduct();
		item.setProduct(prod);*/
		//Product prod=productService.getRowById(id);
		//item.setProduct(prod);
		//item.setUserId(username);
		itemService.updateRow(item);
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "CartPage";
	}
/*	@RequestMapping("addToCart")
	public ModelAndView addToCart(@ModelAttribute("prod")Product prod,@RequestParam int id,Model m,HttpSession s)
	{
		if(s.getAttribute("cart")==null)
		{
			List<Item> cart=new ArrayList<Item>();
			cart.add(new Item(productService.getRowById(id),1));
			s.setAttribute("cart", cart);
		}
		else
		{
			List<Item> cart=(List<Item>) s.getAttribute("cart");
			int index=isExisting(id,s);
			if(index==-1)
			{
				cart.add(new Item(productService.getRowById(id),1));
			}
			else
			{
				int quantity=cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			m.addAttribute("cart", cart);
		}
		return new ModelAndView("cartpage");
	}
	
	@RequestMapping("deleteThisProduct")
	public ModelAndView toRemoveThatProduct(@ModelAttribute("prod")Product prod,@RequestParam int id,Model m,HttpSession s)
	{
		List<Item> cart=(List<Item>) s.getAttribute("cart");
		int index=isExisting(id,s);
		cart.remove(index);
		m.addAttribute("cart", cart);
		return new ModelAndView("cartpage");
	}
	
	private int isExisting(int id,HttpSession s)
	{
		List<Item> cart=(List<Item>) s.getAttribute("cart");
		for(int i=0;i<cart.size();i++)
		{
			if(cart.get(i).getProduct().getFid()==id)
			{
				return i;
			}
		}
		return -1;
	}
*/
	

	@RequestMapping(value="/payNow")
	public ModelAndView toOrder(HttpServletRequest r,Model m) {
		/*categoryService.updateRow(cat);
		List ls = categoryService.getList();*/
		String ammount=r.getParameter("total");
		m.addAttribute("amount", ammount);
		return new ModelAndView("cashPayment");
		/*return new ModelAndView("viewCategory");*/
	}
	
	/*@RequestMapping(value="order", method = RequestMethod.POST)
	public ModelAndView toSubmitAddress(@ModelAttribute("shipping") ShippingAddress shipping) {
		
		return new ModelAndView("cashPayment");
	}*/
	
	@RequestMapping(value="/validPay",method=RequestMethod.POST)
	public String toThankU(HttpServletRequest req,Model m)
	{
		//check all the details in the pay now page and preform all the transactions for bank
		//to validate the pay now form
		String cardName=req.getParameter("name");
		String cardNo=req.getParameter("cardNo");
		String status="success";
		//String mm=req.getParameter("month");
		//String yy=req.getParameter("year");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH);
		int mth=Integer.parseInt(req.getParameter("month"));
		int yth=Integer.parseInt(req.getParameter("year"));
		
		 for(char c : cardName.toCharArray()){
		        if(Character.isDigit(c)){  
		        	m.addAttribute("errorNme", "Enter valid card name");
		        	status="failure";
		        	break;  
		        } 
		 }
		 for(char c : cardNo.toCharArray()){
		        if(Character.isDigit(c)){  
		        } else
		        {
		            m.addAttribute("errorNo", "Enter valid CardNo.");
		            status="failure";
		            break;            
		        }
		        
		 }
		 
		 if(year>yth)
		 {
			 m.addAttribute("errorDate", "Expired already");
			 status="failure";
		 }
		 else if(year==yth)
		 {
			 if(month<mth)
			 {
				 m.addAttribute("errorDate", "Expired already");
				 status="failure";
			 }
		 }
		 if(mth>12)
		 {
			 m.addAttribute("errorDate", "Invalid Date"); 
			 status="failure";
		 }
		 if(status.equals("success"))
		 {
			/* Orders order=null;
			 order.setUserName(username);
			 orderService.insertRow(order);
			 List<Item> itemLt=itemService.getList();
			 List<Item> items=new ArrayList<Item>();
			 for(Item i:itemLt)
			 {
				 if(i.getUserId().equals(username))
				 {
					 items.add(i);
					 itemService.deleteRow(i.getItemId());
				 }
			 }
			 for(Item i:items)
			 {
				 
			 }*/
			 return("ThankU");
		 }
		 else
		 {
			 return("cashPayment");
		 }
		 }
}
