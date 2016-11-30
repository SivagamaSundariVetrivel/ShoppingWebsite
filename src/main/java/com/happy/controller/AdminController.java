package com.happy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.happy.services.CategoryService;

@Controller
public class AdminController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/adminLogin")
	public String gotoAdminLogin()
	{
		return "adminLogin";
	}
	
	@RequestMapping("/admin/adminHome")
	public ModelAndView gotoAdmin(Model m)
	{
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("adminHome");
//		return "adminHome";
	}
	
	@RequestMapping("/manageCategory")
	public ModelAndView toManageCategory(Model m) {
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("manageCategory");
	}
	
	@RequestMapping("/manageProduct")
	public ModelAndView toManageProduct(Model m) {
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("manageProduct");
	}

	@RequestMapping("/manageSupplier")
	public ModelAndView toManage(Model m) {
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("manageSupplier");
	}
}
