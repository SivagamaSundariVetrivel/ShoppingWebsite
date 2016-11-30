package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.CategoryDAO;
import com.happy.model.Category;



@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    
	 @Autowired
	 CategoryDAO categoryDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Category cate) {
	  return categoryDAO.insertRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return categoryDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Category getRowById(int id) {
	  return categoryDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Category cate) {
	  return categoryDAO.updateRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return categoryDAO.deleteRow(id);
	 }
}