package com.happy.dao;

import java.util.List;

import com.happy.model.Cart;

public interface CartDAO {
	public int insertRow(Cart cate);

	 public List getList();

	 public Cart getRowById(int id);

	 public int updateRow(Cart cate);

	 public int deleteRow(int id);

	 public int updateRowById(int id,int pid);
}

