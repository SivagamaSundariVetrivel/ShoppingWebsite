package com.happy.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.happy.model.User;
import com.happy.services.CategoryService;
import com.happy.services.UserService;




@Component
public class Demohandler {

	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public User initFlow(){
		return new User();
	}

	public String validateDetails(User userBean,MessageContext messageContext){
		String status = "success";
		 if(userBean.getPassword().equals(userBean.getReTypePass()))
			{
				status="success";
			}
			else
			{
				messageContext.addMessage(new MessageBuilder().error().source(
						"reTypePass").defaultText("Password and conform password doesn't match..").build());
				status = "failure";
			}
		List<User> usrLt=userService.getList();
		for(User u:usrLt)
		{
			if(u.getEmail().equals(userBean.getEmail()))
			{
				messageContext.addMessage(new MessageBuilder().error().source(
						"email").defaultText("Email already exist..").build());
				status = "failure";
			}
			if(u.getUserName().equals(userBean.getUserName()))
			{
				messageContext.addMessage(new MessageBuilder().error().source(
						"userName").defaultText("UserName already exist..").build());
				status = "failure";
			}
		}
	
		if(userBean.getUserName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"userName").defaultText("UserName cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getEmail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		return status;
	}
	
	public String enterDB(User userBean,Model m,HttpServletRequest request)
	{
		String s="success";
	/*	List<User> usrLt=userService.getList();
		for(User u:usrLt)
		{
			if((u.getUserName().equals(userBean.getUserName()))||(u.getEmail().equals(userBean.getEmail())))
			{
				m.addAttribute("msg", "Already Signed Up.. login please");
				s="failure";
				break;
			}	
		}
		if(s.equals("success"))
		{*/
			userService.insertRow(userBean);
			String recipientAddress = request.getParameter("recipient");
			String subject = "Welcome..";
			String message = "Welcome "+userBean.getUserName()+"\n\nYour account has been created successfully in b-mobiles.\n\nNow you can login in our website to find your mobile..\n\n\n\n\n-bmobiles";
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
			List catLt=categoryService.getList();
			m.addAttribute("listCate", catLt);
		/*}*/
		return s;
	}
}