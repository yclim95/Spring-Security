package com.knowyourneighborhood.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int roleID;
	
	private String roleType;
	
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	
}
