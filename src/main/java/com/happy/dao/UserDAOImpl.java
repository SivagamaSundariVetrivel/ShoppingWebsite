package com.happy.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.model.User;
import com.happy.model.UserRole;



@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(User us) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  us.setEnable(true);
	  UserRole ur=new UserRole();
	  ur.setRoleId(us.getUid());
	  ur.setRoleName("ROLE_ADMIN");
	  ur.setRoleUserName(us.getUserName());
	 /* Cart cart=new Cart();
	  cart.setCartId(us.getUid());
	  session.saveOrUpdate(cart);	 */ 
	  session.saveOrUpdate(ur);
	  session.saveOrUpdate(us);
	  tx.commit();
	  Serializable id = session.getIdentifier(us);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from User").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public User getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  User us = (User) session.load(User.class, id);
	  return us;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(User s) {
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
	  User s = (User) session.load(User.class, id);
	  session.delete(s);
	  tx.commit();
	  Serializable ids = session.getIdentifier(s);
	  session.close();
	  return (Integer) ids;
	 }

}
