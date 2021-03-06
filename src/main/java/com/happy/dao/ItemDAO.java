package com.happy.dao;

import java.util.List;

import com.happy.model.Item;
import com.happy.model.Item;

public interface ItemDAO {
	public int insertRow(Item cate);

	 public List getList();

	 public Item getRowById(int id);

	 public int updateRow(Item cate);

	 public int deleteRow(int id);

	 public Item updateQuantity(int id);
}

