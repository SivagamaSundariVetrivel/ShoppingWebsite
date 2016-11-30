package com.happy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	private String roleName;
	private String roleUserName;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleUserName() {
		return roleUserName;
	}
	public void setRoleUserName(String roleUserName) {
		this.roleUserName = roleUserName;
	}
	
}
