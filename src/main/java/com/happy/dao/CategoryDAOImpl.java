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

import com.happy.model.Category;



@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Category p) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(p);
	  tx.commit();
	  Serializable id = session.getIdentifier(p);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from Category").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Category getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Category p = (Category) session.load(Category.class, id);
	  return p;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Category p) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  session.saveOrUpdate(p);
	  tx.commit();
	  Serializable id = session.getIdentifier(p);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  Category p = (Category) session.load(Category.class, id);
	  session.delete(p);
	  tx.commit();
	  Serializable ids = session.getIdentifier(p);
	  session.close();
	  return (Integer) ids;
	 }

}