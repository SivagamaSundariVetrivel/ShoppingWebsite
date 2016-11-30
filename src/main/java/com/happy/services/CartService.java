package com.happy.services;

import java.util.List;

import com.happy.model.Cart;

public interface CartService {
	public int insertRow(Cart cate);

	 public List getList();

	 public Cart getRowById(int id);

	 public int updateRow(Cart cate);

	 public int deleteRow(int id);
}
