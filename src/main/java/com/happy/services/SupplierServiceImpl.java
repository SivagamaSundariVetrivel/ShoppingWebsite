package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.SupplierDAO;
import com.happy.model.Supplier;



@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    
	 @Autowired
	 SupplierDAO supplierDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Supplier supply) {
	  return supplierDAO.insertRow(supply);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return supplierDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Supplier getRowById(int id) {
	  return supplierDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Supplier supply) {
	  return supplierDAO.updateRow(supply);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return supplierDAO.deleteRow(id);
	 }
}