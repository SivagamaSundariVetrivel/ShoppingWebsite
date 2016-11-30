package com.happy.services;

import java.util.List;

import com.happy.model.Orders;

public interface OrderService {
	public int insertRow(Orders cate);

	 public List getList();

	 public Orders getRowById(int id);

	 public int updateRow(Orders cate);

	 public int deleteRow(int id);
}
