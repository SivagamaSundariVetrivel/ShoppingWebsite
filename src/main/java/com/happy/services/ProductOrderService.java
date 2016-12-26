package com.happy.services;

import java.util.List;

import com.happy.model.ProductOrder;

public interface ProductOrderService {
	public int insertRow(ProductOrder cate);

	 public List getList();

	 public ProductOrder getRowById(int id);

	 public int updateRow(ProductOrder cate);

	 public int deleteRow(int id);
}
