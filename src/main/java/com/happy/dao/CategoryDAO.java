package com.happy.dao;

import java.util.List;

import com.happy.model.Category;
import com.happy.model.Category;

public interface CategoryDAO {
	public int insertRow(Category cate);

	 public List getList();

	 public Category getRowById(int id);

	 public int updateRow(Category cate);

	 public int deleteRow(int id);


}

