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
import org.springframework.web.servlet.ModelAndView;

import com.happy.model.Category;
import com.happy.model.Supplier;
import com.happy.services.CategoryService;
import com.happy.services.SupplierService;

@Controller
public class SupplierController {

	public SupplierController() {
		System.out.println("supply control");
	}

	@Autowired
	SupplierService supplierService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/addSupplier")
	public ModelAndView toAddSupplier(@ModelAttribute("supply") Supplier supply,Model m) {
		List ls = supplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("addSupplier", "listsupply", ls);
		/*
		 * return new ModelAndView("addSupplier"); return pro;
		 */
	}

	/*@RequestMapping("/viewSupplierWidAngJS")
	public @ResponseBody ModelAndView toSupplierAngularJS(ModelMap m) {
		List<Supplier> ls = supplierService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(ls);
		m.addAttribute("pdata", st);
		System.out.println("pdata" + st);
		return new ModelAndView("viewsupplyWidAngJS");
		 return new ModelAndView("addSupplier"); 
	}*/

	@RequestMapping(value = "saveSupplier", method = RequestMethod.POST)
	public ModelAndView getSupplierForm(@ModelAttribute("supply") Supplier supply, ModelMap m) {
		supplierService.insertRow(supply);
		List SupplierLt = supplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("addSupplier", "listsupply", SupplierLt);
	}

	@RequestMapping("/deleteSupplier")
	public ModelAndView toDeleteSupply(@ModelAttribute("supply") Supplier supply, @RequestParam int id,Model m) {
		supplierService.deleteRow(id);
		List<Supplier> ls = supplierService.getList();
		List<Category> catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("addSupplier", "listsupply", ls);
		/* return new ModelAndView("addSupplier"); */

	}

	@RequestMapping("/viewSupplier")
	public ModelAndView toListSupplier(@ModelAttribute("supply") Supplier supply,Model m) {
		List ls = supplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewSupplier", "listsupply", ls);
	}

	@RequestMapping("/editSupplier")
	public ModelAndView toEditSupplier(@ModelAttribute("supply") Supplier supply, @RequestParam int id,Model m) {
		supply = supplierService.getRowById(id);
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("editSupplier", "sup", supply);
	}

	@RequestMapping(value="updateSupplier", method = RequestMethod.POST)
	public ModelAndView toUpdateSupplier(@ModelAttribute("supply") Supplier supply,Model m) {
		supplierService.updateRow(supply);
		List ls = supplierService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewSupplier", "listsupply", ls);
		/*return new ModelAndView("viewSupplier");*/
	}
}