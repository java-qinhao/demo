package com.luban.dao;
import com.luban.dao.UserDao;
public class $Proxy implements UserDao { 
	private UserDao target;
	public $Proxy(UserDao target){
		this.target=target;
	}
	public void query(){
		 System.out.println("log");
		target.query();
	}

}