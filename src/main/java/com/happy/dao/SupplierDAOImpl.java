package com.happy.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.model.Supplier;



@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Supplier s) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(s);
	  tx.commit();
	  Serializable id = session.getIdentifier(s);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from Supplier").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Supplier getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Supplier s = (Supplier) session.load(Supplier.class, id);
	  return s;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Supplier s) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(s);
	  tx.commit();
	  Serializable id = session.getIdentifier(s);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  Supplier s = (Supplier) session.load(Supplier.class, id);
	  session.delete(s);
	  tx.commit();
	  Serializable ids = session.getIdentifier(s);
	  session.close();
	  return (Integer) ids;
	 }

	

	
}
