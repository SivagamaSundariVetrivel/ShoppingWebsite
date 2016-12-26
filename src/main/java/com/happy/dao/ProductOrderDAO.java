package com.happy.dao;

import java.util.List;

import com.happy.model.ProductOrder;
//import com.happy.model.ProductOrder;

public interface ProductOrderDAO {
	public int insertRow(ProductOrder cate);

	 public List getList();

	 public ProductOrder getRowById(int id);

	 public int updateRow(ProductOrder cate);

	 public int deleteRow(int id);


}

