package com.happy.services;

import java.util.List;

import com.happy.model.User;

public interface UserService {
	public int insertRow(User user);

	 public List getList();

	 public User getRowById(int id);

	 public int updateRow(User user);

	 public int deleteRow(int id);

}
