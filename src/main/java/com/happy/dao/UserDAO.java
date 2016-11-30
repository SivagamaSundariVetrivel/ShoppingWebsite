package com.happy.dao;

import java.util.List;

import com.happy.model.User;


public interface UserDAO {
	 public int insertRow(User user);

	 public List getList();

	 public User getRowById(int id);

	 public int updateRow(User user);

	 public int deleteRow(int id);

}

