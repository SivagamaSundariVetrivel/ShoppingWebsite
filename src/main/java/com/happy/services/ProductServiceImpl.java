package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.ProductDAO;
import com.happy.model.Product;



@Service("productService")
public class ProductServiceImpl implements ProductService {
    
	 @Autowired
	 ProductDAO productDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Product Prod,String s) {
	  return productDAO.insertRow(Prod,s);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return productDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Product getRowById(int id) {
	  return productDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Product Prod,String path) {
	  return productDAO.updateRow(Prod,path);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return productDAO.deleteRow(id);
	 }
}