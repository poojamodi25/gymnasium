package com.gym.model.gimnasium;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRoleMaster {
	
	private int role_id;
	private String role_name;
	private String role_detail;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int getRole_id() {
		return role_id;
	}
	
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_detail() {
		return role_detail;
	}
	public void setRole_detail(String role_detail) {
		this.role_detail = role_detail;
	}
	
	

}
