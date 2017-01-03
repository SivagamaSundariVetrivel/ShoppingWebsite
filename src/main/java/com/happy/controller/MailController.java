package com.happy.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.happy.model.Cart;
import com.happy.model.Item;
import com.happy.model.Orders;
import com.happy.model.ProductOrder;
import com.happy.model.ShippingAddress;
import com.happy.model.User;
import com.happy.services.AddressService;
import com.happy.services.CartService;
import com.happy.services.CategoryService;
import com.happy.services.ItemService;
import com.happy.services.OrderService;
import com.happy.services.ProductOrderService;
import com.happy.services.UserService;



@Controller
public class MailController {

	public MailController() {
		super();
		System.out.println("Mail ctrl");
		// TODO Auto-generated constructor stub
	}

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	CartService cartService;
	
    @Autowired
    ItemService itemService;
    
    @Autowired
	OrderService orderService;
    
	@Autowired
	ProductOrderService productOrderService;
    
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
    
    /*@RequestMapping("/Order")
	public String gotoHome(Model m)
	{
		
	}*/
	
	@RequestMapping(value="/sendEmail", method = RequestMethod.POST)
	public String doSendEmail(@RequestParam int ship,HttpServletRequest request,Model m) {
		//check all the details in the pay now page and preform all the transactions for bank
		//to validate the pay now form
		String cardName=request.getParameter("name");
		String cardNo=request.getParameter("cardNo");
		String status="success";
		//String mm=req.getParameter("month");
		//String yy=req.getParameter("year");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH);
		int mth=Integer.parseInt(request.getParameter("month"));
		int yth=Integer.parseInt(request.getParameter("year"));
		int i,q;
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
		 
		/* if(year>yth)
		 {
			 m.addAttribute("errorDate", "Expired already");
			 status="failure";
		 }
		 else */if(year==yth)
		 {
			 if(month>mth)
			 {
				 m.addAttribute("errorDate", "Expired already");
				 status="failure";
			 }
		 }
		 /*if(mth>12)
		 {
			 m.addAttribute("errorDate", "Invalid Date"); 
			 status="failure";
		 }*/
		 if(status.equals("success"))
		 {
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
				
				 //create an order
				ShippingAddress address=addressService.getRowById(ship);
				 Orders order=new Orders(cart.getGrandTotal(),username,address);
				 orderService.insertRow(order);
				 
				List<Item> allItem=itemService.getList();
				List<Item> items=new ArrayList<Item>();
				for(Item item:allItem)
				{
					if(cart.getCartId()==item.getCart().getCartId())
					{
						items.add(item);
					}
				}
				for (Item item : items) {
					ProductOrder prod = new ProductOrder(order.getOrderId(), item.getProduct(), item.getQuantity());
					productOrderService.insertRow(prod);
					itemService.deleteRow(item.getItemId());
				}
				cartService.deleteRow(cart.getCartId());
				
		// takes input from e-mail form
		String recipientAddress = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String from = "noreply@gmail.com";
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		
		// forwards to the view named "ThankU"
		return "ThankU";
		 }
		 else
		 {
			 return "cashPayment";
		 }
}
	
	@RequestMapping(value="/sendForgotEmail", method = RequestMethod.POST)
	public String doSendForgotEmail(HttpServletRequest request,Model m) {
		//check all the details in the pay now page and preform all the transactions for bank
		// takes input from e-mail form
		String recipientAddress = request.getParameter("recipient");
		List<User> usrLt=userService.getList();
		User u=null;
		boolean flag=true;
		for(User usr:usrLt)
		{
			if(usr.getEmail().equals(recipientAddress))
			{
				u=userService.getRowById(usr.getUid());
				flag=false;
				//m.addAttribute("userName", usr.getEmail());
				//m.addAttribute("password", usr.getPassword());
				break;
			}
		}
		if(flag)
		{
			m.addAttribute("err", "Please check your mailID");
			return "forgotPass";
		}
		else
		{
		String subject = request.getParameter("subject");
		String message = "The information are\nYour UserName:"+u.getUserName()+"\nYour Password:"+u.getPassword()+"\n\n\n-bmobiles.";
		String from = "sundari.vetri@gmail.com";
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		
		// forwards to the view named "ThankU"
		return "validEmail";
		}
}

	@RequestMapping("OrderPage")
	public String toOrderPage(@ModelAttribute("orderProd") ProductOrder orderProd, Model m) {
		List<Orders> ordLt = orderService.getList();
		List<Orders> orders = new ArrayList<Orders>();
		for (Orders p : ordLt) {
			if (p.getUserName().equals(username)) {
				orders.add(p);
			}
		}
		List<ProductOrder> itemLt = productOrderService.getList();
		List<ProductOrder> itemsLt = new ArrayList<ProductOrder>();
		for (Orders order : orders) {
			for (ProductOrder p : itemLt) {
				if (p.getOrderId() == order.getOrderId()) {
					itemsLt.add(p);
				}
			}
		}
		List ls2 = categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("orderProd", itemsLt);
		return "OrderPage";
	}
}