package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.OrderDAO;
import com.happy.model.Orders;



@Service("orderService")
public class OrderServiceImpl implements OrderService {
    
	 @Autowired
	 OrderDAO orderDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Orders cate) {
	  return orderDAO.insertRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return orderDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Orders getRowById(int id) {
	  return orderDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Orders cate) {
	  return orderDAO.updateRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return orderDAO.deleteRow(id);
	 }
}