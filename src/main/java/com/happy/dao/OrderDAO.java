package com.happy.dao;

import java.util.List;

import com.happy.model.Orders;
//import com.happy.model.Orders;

public interface OrderDAO {
	public int insertRow(Orders cate);

	 public List getList();

	 public Orders getRowById(int id);

	 public int updateRow(Orders cate);

	 public int deleteRow(int id);


}

