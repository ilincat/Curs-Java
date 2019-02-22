package com.curs.Curs3;

import java.util.HashMap;
import java.util.Map;

public class Users {
	private Map<String,String> users;
    // static variable single_instance of type Singleton 
    private static Users single_instance = null; 
  
    // variable of type String 
    public String s; 
  
    // private constructor restricted to this class itself 
    private Users() 
    { 
        users= new HashMap<String,String>();
    } 
  
    // static method to create instance of Singleton class 
    public static Users getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Users(); 
  
        return single_instance; 
    } 
    
	public void addUser(String name, String password) {
		users.put(name, password);
	}
	
	public Boolean exists(String name) {
		if(users.containsKey(name))
			return true;
		return false;
	}
	
	public String getPassword(String name) {
		return users.get(name);
	}
}
