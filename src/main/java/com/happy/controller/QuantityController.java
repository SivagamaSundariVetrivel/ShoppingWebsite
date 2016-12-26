package com.happy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.happy.model.Product;
import com.happy.services.ProductService;

@Controller
public class QuantityController {

	@Autowired
	ProductService productService;
	
	public QuantityController() {
		super();
		System.out.println("quantity ctrl");
		// TODO Auto-generated constructor stub
	}

	public void deleteproductquantity(Product prod) {
		int quantity = prod.getStock()-1;
		if(quantity>-1)
		{
		prod.setCid(prod.getCid());
		prod.setPdescription(prod.getPdescription());
		prod.setPid(prod.getPid());
		prod.setPname(prod.getPname());
		prod.setPrice(prod.getPrice());
		prod.setSid(prod.getSid());
		prod.setStock(quantity);
		productService.updateRow(prod, prod.getImgs());
	}
		if(quantity==0)
		{
			productService.deleteRow(prod.getPid());
		}
	}
}
