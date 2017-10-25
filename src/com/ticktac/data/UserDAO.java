package com.ticktac.data;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;
import com.ticktac.business.UserT;

public class UserDAO {
	private static HashMap<String, UserT> usersMap = new HashMap<String, UserT>();
	
	static {
		usersMap.put("kostastzouvalidis@gmail.com", new UserT("Kostas", "Tzouvalidis", "kostastzouvalidis@gmail.com", "qwerty1"));
		usersMap.put("kostasxouveroudis@gmail.com", new UserT("Kostas", "Xouveroudis", "kostasxouveroudis@gmail.com", "qwerty2"));
		usersMap.put("niklasnystad@gmail.com", new UserT("Niklas", "Nystad", "niklasnystad@gmail.com", "qwerty3"));
		usersMap.put("teemupoytaniemi@gmail.com", new UserT("Teemu", "Poytaniemi", "teemupoytaniemi@gmail.com", "qwerty4"));
		usersMap.put("a@gmail.com",new UserT("a","a","a@gmai.com","a"));
	}
	
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
		/*UserT u = usersMap.get(email);
		if(u != null)
			if(!u.getPassword().equals(password))
				return null;
		
		return u;*/
	}
	
	public void addUser(String name, String surname, String email, String password) {
		usersMap.put(email, new UserT(name, surname, email, password));
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
			if(!em.contains(user))
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
	
	public void updateUser(User user, String name, String surname, String password, String photo) {
		//user.updateUser(name, surname, password, photo);
	}
	
	public boolean validateUser(User user, String pass) {
		return user.getPassword().equals(pass);
	}
	
	public boolean userHasTickets(User user) {
		//return user.getEvents().size() > 0;
		return false;
	}
}
