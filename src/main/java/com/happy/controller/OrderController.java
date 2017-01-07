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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.happy.model.Cart;
import com.happy.model.Item;
import com.happy.model.Orders;
import com.happy.model.ProductOrder;
import com.happy.model.ShippingAddress;
import com.happy.model.User;
import com.happy.services.AddressService;
import com.happy.services.CartService;
import com.happy.services.ItemService;
import com.happy.services.OrderService;
import com.happy.services.ProductOrderService;
import com.happy.services.ProductService;
import com.happy.services.UserService;

@Controller
public class OrderController {

	@Autowired
	AddressService addressService;

	@Autowired
	ProductService productService;

	@Autowired
	ItemService itemService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	private String username;
	
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
	
	public OrderController() {
		super();
		System.out.println("order ctrl");// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("orderNow")
	public ModelAndView orderNow(@ModelAttribute("ship") ShippingAddress ship, @RequestParam int id,
			HttpServletRequest r, Model m){
		List<Cart> cartLt=cartService.getList();
		Cart cart=null;
		for(Cart c:cartLt)
		{
			if(c.getUser().equals(username))
			{
				cart=c;	
				break;
			}
		}
		m.addAttribute("cartId", cart.getCartId());
		return new ModelAndView("orderNow");
	}
	
	@RequestMapping(value = "/payNow")
	public ModelAndView toOrder(@ModelAttribute("ship") ShippingAddress ship, @RequestParam int id,
			HttpServletRequest r, Model m) {
		ship.setCartId(id);
		addressService.insertRow(ship);
		List<User> userLt = userService.getList();
		for (User u : userLt) {
			if (u.getUserName().equals(username)) {
				m.addAttribute("email", u.getEmail());
				break;
			}
		}
		/*List<Cart> cartLt=cartService.getList();
		Cart cart=null;
		for(Cart c:cartLt)
		{
			if(c.getUser().equals(username))
			{
				cart=c;
				break;
			}
		}*/
		List<Item> allItem=itemService.getList();
		List<Item> items=new ArrayList<Item>();
		for(Item i:allItem)
		{
			if(id==i.getCart().getCartId())
			{
				items.add(i);
			}
		}
		m.addAttribute("cart", items);
		m.addAttribute("amount", cartService.getRowById(id).getGrandTotal());
		m.addAttribute("shippingDetials", ship);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		List<Integer> yrs=new ArrayList<Integer>();
		for(int i=0;i<10;i++)
		{
			yrs.add(year+i);
		}
		m.addAttribute("yyyy",yrs);
		// order.setDeliveryAddress(ship);
		return new ModelAndView("cashPayment");
	}
	
}
