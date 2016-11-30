package com.happy.dao;

import java.util.List;

import com.happy.model.Supplier;


public interface SupplierDAO {
	 public int insertRow(Supplier supply);

	 public List getList();

	 public Supplier getRowById(int id);

	 public int updateRow(Supplier supply);

	 public int deleteRow(int id);


}

