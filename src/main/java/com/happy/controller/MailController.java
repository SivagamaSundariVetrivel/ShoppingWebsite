package com.happy.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.happy.model.Item;
import com.happy.model.User;
import com.happy.services.ItemService;
import com.happy.services.UserService;



@Controller
public class MailController {

	public MailController() {
		super();
		System.out.println("Mail ctrl");
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired 
	UserService userService;
	
    @Autowired
    ItemService itemService;
    
    /*@Autowired
    CartController ctrl;
	
	@RequestMapping("/Order")
	public String gotoHome(Model m)
	{
		
	}*/
	
	@RequestMapping(value="/sendEmail", method = RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request,Model m) {
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
		 
		 if(year>yth)
		 {
			 m.addAttribute("errorDate", "Expired already");
			 status="failure";
		 }
		 else if(year==yth)
		 {
			 if(month>mth)
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
}