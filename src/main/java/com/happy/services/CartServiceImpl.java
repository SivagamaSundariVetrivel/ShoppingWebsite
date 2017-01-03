package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.CartDAO;
import com.happy.model.Cart;

@Service("cartService")
public class CartServiceImpl implements CartService {
    
	 @Autowired
	 CartDAO cartDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Cart cate) {
	  return cartDAO.insertRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return cartDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Cart getRowById(int id) {
	  return cartDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Cart cate) {
	  return cartDAO.updateRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return cartDAO.deleteRow(id);
	 }
	 
	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRowById(int id,int pid)
	 {
		 return cartDAO.updateRowById(id,pid);
	 }
}