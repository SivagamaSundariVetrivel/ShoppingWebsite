package com.happy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.happy.model.Item;
import com.happy.model.Product;
import com.happy.model.ProductOrder;
import com.happy.services.CategoryService;
import com.happy.services.ItemService;
import com.happy.services.ProductOrderService;
import com.happy.services.ProductService;
import com.happy.services.SupplierService;

@Controller
public class ProductController {

	public ProductController() {
		System.out.println("prod control");
	}

	@Autowired
	ProductOrderService productOrderService;
	
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;	
	
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/addProduct")
	public ModelAndView toAddProduct(@ModelAttribute("prod") Product prod , Model m) {
		List ls = productService.getList();
		List ls1=supplierService.getList();
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cList", ls2);
		m.addAttribute("sList", ls1);
		return new ModelAndView("addProduct", "listProd", ls);
		/*
		 * return new ModelAndView("addProduct"); return pro;
		 */
	}

	@RequestMapping("/viewProdWidAngJS")
	public @ResponseBody ModelAndView toProdAngularJS(ModelMap m) {
		List<Product> ls = productService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(ls);
		m.addAttribute("pdata", st);
		System.out.println("pdata" + st);
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewProdWidAngJS");
		/* return new ModelAndView("addProduct"); */
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView getProdForm(@ModelAttribute("prod") Product prod, ModelMap m,HttpServletRequest req) {
		  MultipartFile file = prod.getFile(); 
		  String fileName = "";
		  String image="";
		  if(!file.isEmpty())		 
		  {
			  try 
			  {
				  System.out.println("inside try");
			  fileName = file.getOriginalFilename();
			  byte[] filesize=file.getBytes();
			  BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\SIVAGAMA SUNDARI\\workspace\\bmobiles1\\src\\main\\webapp\\resources\\db\\Product\\" + fileName)));
			   bout.write(filesize);
			   bout.close();
			   image="/resources/db/Product/"+fileName;
			  // r.setAttribute("img",image);
			   m.addAttribute("img", image);
			   System.out.println("upload success.."+image);
			  }
			   catch (IOException e) {
			   // TODO Auto-generated catch block
				  System.out.println("upload failed..");
			   e.printStackTrace();
			  }
			 
		  }

		productService.insertRow(prod, image);
		List productLt = productService.getList();
		List ls1=supplierService.getList();
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("sList", ls1);
		return new ModelAndView("addProduct", "listProd", productLt);
		 
	}

	@RequestMapping("/deleteProduct")
	public ModelAndView toDeleteProd(@ModelAttribute("prod") Product prod, @RequestParam int id,Model m) {
		List<Item> itemLt=itemService.getList();
		for(Item i:itemLt)
		{
				if(i.getProduct().getPid()==id)
				{
					//productService.stockUp(id);
					itemService.deleteRow(i.getItemId());	
				}
		}
		List<ProductOrder> orderedLt=productOrderService.getList();
		for(ProductOrder pro:orderedLt)
		{
				if(pro.getProduct().getPid()==id)
				{
					//productService.stockUp(id);
					productOrderService.deleteRow(pro.getOrderId());	
				}
		}
		//prod=productService.getRowById(id);
		//m.addAttribute("deletedproduct", prod.getPname());
		productService.deleteRow(id);
		List ls = productService.getList();
		List ls1=supplierService.getList();
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("sList", ls1);
		return new ModelAndView("viewProduct", "listProd", ls);
		/* return new ModelAndView("addProduct"); */

	}

	@RequestMapping("/viewProduct")
	public ModelAndView toListProd(@ModelAttribute("prod") Product prod,Model m) {
		List ls = productService.getList();
		List catLt=categoryService.getList();
		m.addAttribute("listCate", catLt);
		return new ModelAndView("viewProduct", "listProd", ls);
	}

	@RequestMapping("/editProduct")
	public ModelAndView toEditProd(@ModelAttribute("prod") Product prod, @RequestParam int id,Model m) {
		prod = productService.getRowById(id);
		List ls1=supplierService.getList();
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("sList", ls1);
		return new ModelAndView("editProduct", "pd", prod);
	}

	@RequestMapping(value="updateProduct", method = RequestMethod.POST)
	public ModelAndView toUpdateProd(@ModelAttribute("prod") Product prod,ModelMap m,HttpServletRequest r) {
		MultipartFile file = prod.getFile(); 
		  String fileName = "";
		  String image="";
		  if(!file.isEmpty())		 
		  {
			  try 
			  {
				  System.out.println("inside try");
			  fileName = file.getOriginalFilename();
			  byte[] filesize=file.getBytes();
			  BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\SIVAGAMA SUNDARI\\workspace\\bmobiles\\src\\main\\webapp\\resources\\db\\Product\\" + fileName)));
			   bout.write(filesize);
			   bout.close();
			   image="/resources/db/Product/"+fileName;
			  // r.setAttribute("img",image);
			   m.addAttribute("img", image);
			   System.out.println("upload success.."+image);
			  }
			   catch (IOException e) {
			   // TODO Auto-generated catch block
				  System.out.println("upload failed..");
			   e.printStackTrace();
			  }
			 
		  productService.updateRow(prod,image); 
		}
		  List ls1=supplierService.getList();
			List ls2=categoryService.getList();
			m.addAttribute("listCate", ls2);
			m.addAttribute("sList", ls1);
		
		List ls = productService.getList();
		return new ModelAndView("viewProduct", "listProd", ls);
		/*return new ModelAndView("viewProduct");*/
	}
}