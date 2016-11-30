package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.UserDAO;
import com.happy.model.User;



@Service("userService")
public class UserServiceImpl implements UserService {
    
	 @Autowired
	 UserDAO userDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(User use) {
	  return userDAO.insertRow(use);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return userDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public User getRowById(int id) {
	  return userDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(User use) {
	  return userDAO.updateRow(use);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return userDAO.deleteRow(id);
	 }
	 
}