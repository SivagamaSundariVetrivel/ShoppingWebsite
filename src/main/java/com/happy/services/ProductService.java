package com.happy.services;


import java.util.List;

import com.happy.model.Product;


public interface ProductService {
 public int insertRow(Product Prod,String s);

 public List getList();

 public Product getRowById(int id);

 public int updateRow(Product Prod,String path);

 public int deleteRow(int id);

}