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

import com.happy.model.Cart;
import com.happy.model.Category;
import com.happy.model.Item;
import com.happy.model.Orders;
import com.happy.model.Product;
import com.happy.model.ProductOrder;
import com.happy.model.ShippingAddress;
import com.happy.model.User;
import com.happy.services.AddressService;
import com.happy.services.CartService;
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
	CartService cartService;
	
	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	public String username;

	public CartController() {
		System.out.println("cart Ctrl"); // TODO Auto-generated constructor stub
	}
	
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

	@RequestMapping("addToCart")
	public ModelAndView addToCart(@ModelAttribute("item") Item item, @RequestParam int id, Model m,
			HttpServletRequest r) {
		if (username.equals("anonymousUser")) {
			m.addAttribute("msg", "Login to add in cart");
			return new ModelAndView("loginvalid");
		}
		productService.updateStock(id);
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
		if(cart==null)
		{
			cart=new Cart(username);
			cartService.insertRow(cart);
		}
		List<Item> itemLt = itemService.getList();
		List<Item> items = itemLt;
		item = null;
		cartService.updateRowById(cart.getCartId(), id);
		for (Item i : itemLt) {
			if ((i.getCart().getCartId()==cart.getCartId()) && (i.getProduct().getPid() == id)) {
				item = itemService.updateQuantity(i.getItemId());
				break;
			}
		}
		// Item i=item;
		if (item == null) {
			Product prod = productService.getRowById(id);
			item = new Item(prod, 1, cart);
			itemService.insertRow(item);
			itemService.updateQuantity(item.getItemId());
		}
		List<Item> itemsLt = new ArrayList<Item>();
		for (Item p : itemLt) {
			if (p.getCart().getCartId()==cart.getCartId()) {
				itemsLt.add(p);
			}
		}
		List ls2 = categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		m.addAttribute("cartId", cart.getCartId());
		return new ModelAndView("CartPage");
	}

	@RequestMapping("CartPage")
	public String toCartPage(@ModelAttribute("item") Item item, Model m) {
		List<Item> itemLt = itemService.getList();
		List<Item> itemsLt = new ArrayList<Item>();
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
		for (Item p : itemLt) {
			if (p.getCart().getCartId()==cart.getCartId()) {
				itemsLt.add(p);
			}
		}
		if(cart==null)
		{
			//nothing in cart
		}
		List ls2 = categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		m.addAttribute("cartId", cart.getCartId());
		return "CartPage";
	}

/*	@RequestMapping("OrdersPage")
	public String toOrderPage(Model m) {
		List<Item> itemLt = itemService.getList();
		List<Item> itemsLt = new ArrayList<Item>();
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
		for (Item p : itemLt) {
			if (p.getCart().getCartId()==cart.getCartId()) {
				itemsLt.add(p);
			}
		}
		if(cart==null)
		{
			//nothing in cart
		}
		List ls2 = categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "OrdersPage";
	}*/

	@RequestMapping("deleteItem")
	public String deleteItem(@ModelAttribute("item") Item item, @RequestParam int id, Model m) {
		productService.stockUp(id);
		itemService.deleteRow(id);
		List<Item> itemLt = itemService.getList();
		List<Item> itemsLt = new ArrayList<Item>();
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
		for (Item p : itemLt) {
			if (p.getCart().getCartId()==cart.getCartId()) {
				itemsLt.add(p);
			}
		}
		if(cart==null)
		{
			//nothing in cart
		}
		List ls2 = categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		m.addAttribute("cartId", cart.getCartId());
		return "CartPage";
	}


	/*@RequestMapping(value = "/payNow")
	public ModelAndView toOrder(@ModelAttribute("ship") ShippingAddress ship, @RequestParam int id,
			HttpServletRequest r, Model m) {
		Orders order = orderService.getRowById(id);
		ship.setOrder(order);
		addressService.insertRow(ship);
		m.addAttribute("amount", order.getTotalPrice());
		m.addAttribute("order", id);
		List<User> userLt = userService.getList();
		List<ProductOrder> itemLt = productOrderService.getList();
		List<ProductOrder> items = new ArrayList<ProductOrder>();
		for (User u : userLt) {
			if (u.getUserName().equals(username)) {
				m.addAttribute("email", u.getEmail());
				break;
			}
		}
		for (ProductOrder it : itemLt) {
			if (it.getOrderId() == id) {
				items.add(it);
			}
		}
		m.addAttribute("cart", items);
		m.addAttribute("shippingDetials", ship);
		// order.setDeliveryAddress(ship);
		return new ModelAndView("cashPayment");
	}
	
	@RequestMapping("orderNow")
	public String toShippingAddress(@ModelAttribute("ship") ShippingAddress ship, @RequestParam double total,
			HttpServletRequest r, Model m) {
		// m.addAttribute("amount", total);
		// Double.parseDouble(r.getParameter("price")
		Orders order = new Orders(total, username);
		// order.setTotalPrice();
		// order.setUserName(username);
		orderService.insertRow(order);
		List<Item> itemLt = itemService.getList();
		List<Item> items = new ArrayList<Item>();
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
		for (Item p : itemLt) {
			if (p.getCart().getCartId()==cart.getCartId()) {
				items.add(p);
			}
		}
		if(cart==null)
		{
			//nothing in cart
		}
		for (Item i : items) {
			ProductOrder prod = new ProductOrder(order.getOrderId(), i.getProduct(), i.getQuantity());
			productOrderService.insertRow(prod);

		}
		m.addAttribute("order", order.getOrderId());
		return "orderNow";
	}*/
}