package com.happy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.happy.model.Category;
import com.happy.services.CategoryService;

@Controller
public class CategoryController {

	public CategoryController() {
		System.out.println("category control");
	}

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/addCategory")
	public ModelAndView toAddCategory(@ModelAttribute("cat") Category cat) {
		List ls = categoryService.getList();
		return new ModelAndView("addCategory", "listCate", ls);
		/* return new ModelAndView("addCategory"); return pro;*/
		 
	}

	/*@RequestMapping("/viewCateWidAngJS")
	public @ResponseBody ModelAndView toCateAngularJS(ModelMap m) {
		List<Category> ls = categoryService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(ls);
		m.addAttribute("pdata", st);
		System.out.println("pdata" + st);
		return new ModelAndView("viewCateWidAngJS");
		 return new ModelAndView("addCategory"); 
	}*/

	@RequestMapping(value = "saveCategory", method = RequestMethod.POST)
	public ModelAndView getCategoryForm(@ModelAttribute("cat") Category cat,Model m) {
	
		List<Category> categoryLt = categoryService.getList();
		/*for(Category cate:categoryLt)
		{
			if(cate.getCname().equals(cat.getCname()))
			{
				m.addAttribute("err", "Category already exists..");
				break;
			}
			else
			{
				categoryService.insertRow(cat);
			}
		}
		*/
		
		return new ModelAndView("addCategory", "listCate", categoryLt);
	}

	@RequestMapping("/deleteCategory")
	public ModelAndView toDeleteCate(@ModelAttribute("cat") Category cat, @RequestParam int id) {
		categoryService.deleteRow(id);
		List ls = categoryService.getList();
		return new ModelAndView("addCategory", "listCate", ls);
		 /*return new ModelAndView("addCategory"); */

	}

	@RequestMapping("/viewCategory")
	public ModelAndView toListCategory(@ModelAttribute("cat") Category cat) {
		List ls = categoryService.getList();
		return new ModelAndView("viewCategory", "listCate", ls);
	}

	@RequestMapping("/editCategory")
	public ModelAndView toEditCategory(@ModelAttribute("cat") Category cat, @RequestParam int id,Model m) {
		cat = categoryService.getRowById(id);
		List catLt=categoryService.getList();
		m.addAttribute("categoryList", catLt);
		return new ModelAndView("editCategory", "cate", cat);
	}

	@RequestMapping(value="updateCategory", method = RequestMethod.POST)
	public ModelAndView toUpdateCategory(@ModelAttribute("cat") Category cat) {
		categoryService.updateRow(cat);
		List ls = categoryService.getList();
		return new ModelAndView("viewCategory", "listCate", ls);
		/*return new ModelAndView("viewCategory");*/
	}
}