package com.happy.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.happy.model.User;
import com.happy.services.UserService;




@Component
public class Demohandler {

	@Autowired
	UserService userService;
	
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
	
	public String enterDB(User userBean)
	{
		String s="success";
		int l=userService.insertRow(userBean);
		if(l==0)
		{
			s="failure";
		}
		return s;
	}
}