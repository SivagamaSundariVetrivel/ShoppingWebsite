package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.ProductOrderDAO;
import com.happy.model.ProductOrder;



@Service("productOrderService")
public class ProductOrderServiceImpl implements ProductOrderService {
    
	 @Autowired
	 ProductOrderDAO productOrderDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(ProductOrder cate) {
	  return productOrderDAO.insertRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return productOrderDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public ProductOrder getRowById(int id) {
	  return productOrderDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(ProductOrder cate) {
	  return productOrderDAO.updateRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return productOrderDAO.deleteRow(id);
	 }
}