package com.tfg.backend.Common;

import com.tfg.backend.Entities.RoleType;

public class JwtInfo {

	private Long userId;
	private String userName;
	private RoleType role;

	public JwtInfo(Long userId, String userName, RoleType role) {

		this.userId = userId;
		this.userName = userName;
		this.role = role;

	}
	
	public JwtInfo(Long userId, String userName, String role) {

		this.userId = userId;
		this.userName = userName;
		this.role = RoleType.valueOf(role);

	}
	
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public RoleType getRole() {
	    return role;
	}

	public void setRole(RoleType role) {
	    this.role = role;
	}
	
	


}
