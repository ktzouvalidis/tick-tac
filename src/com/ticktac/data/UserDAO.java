package com.ticktac.data;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;


public class UserDAO {
	
	public UserDAO() {}
	
	public User searchUser(String email, String password, EntityManager em) {
		String prep = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password";
		
		try {
			TypedQuery<User> q = em.createQuery(prep, User.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			
			User u = (User) q.getSingleResult();
			return u;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertUser(User user, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			em.persist(user);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return false;
		}

		return true;
	}
	
	public boolean removeUser(User user, EntityManager em, UserTransaction tr) {		
		try {
			tr.begin();
			if(!em.contains(user)) // Is it being managed?
				user = em.merge(user);
			em.remove(user);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return false;
		}

		return true;
	}
	
	public User updateUser(User user, String name, String surname, String password, String photo,
			EntityManager em, UserTransaction tr) {
		//user.updateUser(name, surname, password, photo);
		try {
			tr.begin();
			if(!em.contains(user)) // Is it being managed?
				user = em.merge(user);
			user.setName(name);
			user.setSurname(surname);
			user.setPassword(password);
			user.setPhoto(photo);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return null;
		}
		
		return user;
	}
	
	public boolean validateUser(User user, String pass) {
		return user.getPassword().equals(pass);
	}
	
	public boolean userHasTickets(User user) {
		//return user.getEvents().size() > 0;
		return false;
	}
}
