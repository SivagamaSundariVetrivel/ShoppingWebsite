package com.happy.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.happy.model.Supplier;
import com.happy.services.CategoryService;
import com.happy.services.SupplierService;

@Controller
public class SupplierController {

	public SupplierController() {
		System.out.println("supply control");
	}

	@Autowired
	SupplierService SupplierService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/addSupplier")
	public ModelAndView toAddSupplier(@ModelAttribute("supply") Supplier supply,Model m) {
		List ls = SupplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("addSupplier", "listsupply", ls);
		/*
		 * return new ModelAndView("addSupplier"); return pro;
		 */
	}

	/*@RequestMapping("/viewSupplierWidAngJS")
	public @ResponseBody ModelAndView toSupplierAngularJS(ModelMap m) {
		List<Supplier> ls = SupplierService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(ls);
		m.addAttribute("pdata", st);
		System.out.println("pdata" + st);
		return new ModelAndView("viewsupplyWidAngJS");
		 return new ModelAndView("addSupplier"); 
	}*/

	@RequestMapping(value = "saveSupplier", method = RequestMethod.POST)
	public ModelAndView getSupplierForm(@ModelAttribute("supply") Supplier supply, ModelMap m) {
		SupplierService.insertRow(supply);
		List SupplierLt = SupplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("addSupplier", "listsupply", SupplierLt);
	}

	@RequestMapping("/deleteSupplier")
	public ModelAndView toDeleteSupply(@ModelAttribute("supply") Supplier supply, @RequestParam int id,Model m) {
		SupplierService.deleteRow(id);
		List ls = SupplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("addSupplier", "listsupply", ls);
		/* return new ModelAndView("addSupplier"); */

	}

	@RequestMapping("/viewSupplier")
	public ModelAndView toListSupplier(@ModelAttribute("supply") Supplier supply,Model m) {
		List ls = SupplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewSupplier", "listsupply", ls);
	}

	@RequestMapping("/editSupplier")
	public ModelAndView toEditSupplier(@ModelAttribute("supply") Supplier supply, @RequestParam int id,Model m) {
		supply = SupplierService.getRowById(id);
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("editSupplier", "sup", supply);
	}

	@RequestMapping(value="updateSupplier", method = RequestMethod.POST)
	public ModelAndView toUpdateSupplier(@ModelAttribute("supply") Supplier supply,Model m) {
		SupplierService.updateRow(supply);
		List ls = SupplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewSupplier", "listsupply", ls);
		/*return new ModelAndView("viewSupplier");*/
	}
}