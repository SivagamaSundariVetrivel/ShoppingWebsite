package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.ItemDAO;
import com.happy.model.Item;



@Service("itemService")
public class ItemServiceImpl implements ItemService {
    
	 @Autowired
	 ItemDAO itemDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Item cate) {
	  return itemDAO.insertRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return itemDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Item getRowById(int id) {
	  return itemDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Item cate) {
	  return itemDAO.updateRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return itemDAO.deleteRow(id);
	 }
}