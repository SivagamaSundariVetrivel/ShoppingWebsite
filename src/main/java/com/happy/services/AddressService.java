package com.happy.services;

import java.util.List;

import com.happy.model.ShippingAddress;

public interface AddressService {
	public int insertRow(ShippingAddress cate);

	 public List getList();

	 public ShippingAddress getRowById(int id);

	 public int updateRow(ShippingAddress cate);

	 public int deleteRow(int id);
	 
	 
}
