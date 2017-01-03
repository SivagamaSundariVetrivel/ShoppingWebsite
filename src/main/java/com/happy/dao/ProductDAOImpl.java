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

import com.happy.model.Item;
import com.happy.model.Product;



@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Product p,String s) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  p.setImgs(s);
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
	  List pList = session.createQuery("from Product").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Product getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Product p = (Product) session.load(Product.class, id);
	  return p;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Product p,String path) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  p.setImgs(path);
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
	  Product p = (Product) session.load(Product.class, id);
	  session.delete(p);
	  tx.commit();
	  Serializable ids = session.getIdentifier(p);
	  session.close();
	  return (Integer) ids;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	public Product updateStock(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();  
		Product p = (Product) session.load(Product.class, id);
		int stock=p.getStock()-1;
			p.setStock(stock);  
			p.setImgs(p.getImgs());
			session.saveOrUpdate(p);
		tx.commit();
		Serializable sid = session.getIdentifier(p);
		session.close();
		return p;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public Product stockUp(int id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Item i = (Item) session.load(Item.class, id);
		Product p = (Product) session.load(Product.class, i.getProduct().getPid());
		p.setStock(p.getStock()+i.getQuantity());
		session.saveOrUpdate(p);
		tx.commit();
		Serializable sid = session.getIdentifier(p);
		session.close();
		return p;
	}
}
