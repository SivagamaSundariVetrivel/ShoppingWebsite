package com.happy.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.AddressDAO;
import com.happy.model.ShippingAddress;



@Service("addressService")
public class AddressServiceImpl implements AddressService {
    
	 @Autowired
	 AddressDAO addressDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(ShippingAddress cate) {
	  return addressDAO.insertRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return addressDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public ShippingAddress getRowById(int id) {
	  return addressDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(ShippingAddress cate) {
	  return addressDAO.updateRow(cate);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return addressDAO.deleteRow(id);
	 }
}