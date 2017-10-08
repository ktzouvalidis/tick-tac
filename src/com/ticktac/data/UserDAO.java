package com.ticktac.data;

import java.util.HashMap;
import com.ticktac.business.User;

public class UserDAO {
	private static HashMap<String, User> usersMap = new HashMap<String, User>();
	
	static {
		usersMap.put("kostastzouvalidis@gmail.com", new User("Kostas", "Tzouvalidis", "kostastzouvalidis@gmail.com", "qwerty1"));
		usersMap.put("kostasxouveroudis@gmail.com", new User("Kostas", "Xouveroudis", "kostasxouveroudis@gmail.com", "qwerty2"));
		usersMap.put("niklasnystad@gmail.com", new User("Niklas", "Nystad", "niklasnystad@gmail.com", "qwerty3"));
		usersMap.put("teemupoytaniemi@gmail.com", new User("Teemu", "Poytaniemi", "teemupoytaniemi@gmail.com", "qwerty4"));
		usersMap.put("a@gmail.com",new User("a","a","a@gmai.com","a"));
	}
	
	public UserDAO() {}
	
	public int putNewUser(User user) {
		return 0;
	}
	
	public User getInfo(String email) {
		return usersMap.get(email);
	}
	
	public User searchUser(String email, String password) {
		User u = usersMap.get(email);
		if(u != null)
			if(!u.getPassword().equals(password))
				return null;
		
		return u;
	}
	
	public void addUser(String name, String surname, String email, String password) {
		usersMap.put(email, new User(name, surname, email, password));
	}
	
	public void updateUser(User user, String name, String surname, String password, String photo) {
		user.updateUser(name, surname, password, photo);
	}
	
	public User findUserByName(String name) {
		for(String k : usersMap.keySet()) {
			User u = usersMap.get(k);
			if(u.getName().equals(name))
				return u;
		}
		return null;
	}
	
	public boolean validateUser(User user, String pass) {
		return user.getPassword() == pass;
	}
}
