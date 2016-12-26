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
import com.happy.model.ProductOrder;
import com.happy.model.ShippingAddress;
import com.happy.model.User;
import com.happy.services.AddressService;
import com.happy.services.CategoryService;
import com.happy.services.ItemService;
import com.happy.services.OrderService;
import com.happy.services.ProductOrderService;
import com.happy.services.ProductService;
import com.happy.services.UserService;

@Controller
public class CartController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	ProductService productService;

	@Autowired
	ProductOrderService productOrderService;
	
	@Autowired
	QuantityController quantityControl;
	
	@Autowired
	UserService userService;
	
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
		//quantityControl.deleteproductquantity(prod);
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
		for(Item i:itemLt)
		{
			if((i.getUserId().equals(username))&&(i.getProduct().getPid()==id))
			{
				item=itemService.getRowById(i.getItemId());
				break;
			}
		}
		Item i=item;
		if(item==null)
		{
			item=new Item(prod,1,username);
			itemService.insertRow(item);
		}
		else
		{
			
			int q=i.getQuantity()+1;
			item.setQuantity(q);
			item.setItemId(i.getItemId());
			item.setProduct(i.getProduct());
			item.setUserId(username);
			itemService.updateRow(item);
		}
		/*else
		{
			m.addAttribute("modi", "modify the quantity of product over here..");
			List<Item> itemsLt=new ArrayList<Item>();
			for(Item p:itemLt)
			{
				if(p.getUserId().equals(username))
				{
					itemsLt.add(p);
				}
			}
			m.addAttribute("cart", itemsLt);
			return new ModelAndView("CartPage");
		}*/
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
	
	@RequestMapping("OrderPage")
	public String toOrderPage(@ModelAttribute("orderProd")ProductOrder orderProd,Model m)
	{
		List<Orders> ordLt=orderService.getList();
		List<Orders> orders=new ArrayList<Orders>();
		for(Orders p:ordLt)
		{
			if(p.getUserName().equals(username))
			{
				orders.add(p);
			}
		}
		List<ProductOrder> itemLt=productOrderService.getList();
		List<ProductOrder> itemsLt=new ArrayList<ProductOrder>();
		for(Orders order:orders)
		{
		for(ProductOrder p:itemLt)
		{
			if(p.getOrderId()==order.getOrderId())
			{
				itemsLt.add(p);
			}
		}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("orderProd", itemsLt);
		return "OrderPage";
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
	
	@RequestMapping("editItem")
	public String toEditItem(@ModelAttribute("item")Item item,@RequestParam int id,Model m)
	{
		item=itemService.getRowById(id);
		m.addAttribute("itm", item);
		return "editItem";
	}
	
	@RequestMapping(value="updateItem")
	public String updateItem(@ModelAttribute("item")Item item/*,@RequestParam int id*/,Model m,HttpServletRequest r)
	{
		String q=r.getParameter("quantity");
		int quan=Integer.parseInt(q);
		/*item=itemService.getRowById(id);*/
		String p=r.getParameter("id");
		int prodId=Integer.parseInt(p);
		Product pro=productService.getRowById(prodId);
		/*if(quan<=pro.getStock())
		{*/
			item.setProduct(pro);
			item.setUserId(username);
			item.setQuantity(quan);
			itemService.updateRow(item);
			return "CartPage";
	}
	
	@RequestMapping("buyNow")
	public String toBuy(@ModelAttribute("ship")ShippingAddress ship,@RequestParam int id,Model m)
	{
		Product prod=productService.getRowById(id);
		Orders order=new Orders(prod.getPrice(),username);
		orderService.insertRow(order);
		ProductOrder prodOrd=new ProductOrder(order.getOrderId(),prod, 1);
		productOrderService.insertRow(prodOrd);
		 m.addAttribute("order", order.getOrderId());
		return "orderNow";
	}
	
	@RequestMapping(value="/payNow")
	public ModelAndView toOrder(@ModelAttribute("ship")ShippingAddress ship,@RequestParam int id,HttpServletRequest r,Model m) {
			Orders order=orderService.getRowById(id);
			ship.setOrder(order);
			addressService.insertRow(ship);
			m.addAttribute("amount",order.getTotalPrice());
			m.addAttribute("order", id);
			List<User> userLt=userService.getList();
			List<ProductOrder> itemLt=productOrderService.getList();
			List<ProductOrder> items=new ArrayList<ProductOrder>(); 
			for(User u:userLt)
			{
				if(u.getUserName().equals(username))
				{
					m.addAttribute("email",u.getEmail() );
					break;
				}
			}
			for(ProductOrder it:itemLt)
			{
			if(it.getOrderId()==id)
			{
				items.add(it);
			}
			}
			m.addAttribute("cart", items);
			m.addAttribute("shippingDetials", ship);
//			order.setDeliveryAddress(ship);
			return new ModelAndView("cashPayment");
	}
	
	/*@RequestMapping(value="order", method = RequestMethod.POST)
	public ModelAndView toSubmitAddress(@ModelAttribute("shipping") ShippingAddress shipping) {
		
		return new ModelAndView("cashPayment");
	}*/
	
/*	@RequestMapping(value="/validPay",method=RequestMethod.POST)
	public String toThankU(@RequestParam int order,HttpServletRequest req,Model m)
	{
	
				
			
		 }*/
	
	@RequestMapping("orderNow")
	public String toShippingAddress(@ModelAttribute("ship")ShippingAddress ship,@RequestParam double total,HttpServletRequest r,Model m)
	{
		//m.addAttribute("amount", total);
//		Double.parseDouble(r.getParameter("price")
		Orders order=new Orders(total,username);
		// order.setTotalPrice();
		// order.setUserName(username);
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
			 /*Product p=productService.getRowById(i.getProduct().getPid());
			 p.setStock(p.getStock()-i.getQuantity());
			 productService.updateRow(p, p.getImgs());*/
			 ProductOrder prod=new ProductOrder(order.getOrderId(),i.getProduct(),i.getQuantity());
			 productOrderService.insertRow(prod);
			 
		 }
		 /*for(Item i:items)
		 {
			 Product p=productService.getRowById(i.getProduct().getPid());
			 p.setStock(p.getStock()-i.getQuantity());
			 productService.updateRow(p, p.getImgs());
		 }*/
		 m.addAttribute("order", order.getOrderId());
		return "orderNow";
	}
}