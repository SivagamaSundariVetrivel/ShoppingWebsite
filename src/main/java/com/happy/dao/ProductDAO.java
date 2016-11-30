package com.happy.dao;


import java.util.List;

import com.happy.model.Product;





public interface ProductDAO {
 public int insertRow(Product prod,String s);

 public List getList();

 public Product getRowById(int id);

 public int updateRow(Product prod,String path);

 public int deleteRow(int id);

}