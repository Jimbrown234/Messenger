package com.brown.UserMs.dto;

import com.brown.UserMs.entity.User;

public class UserDTO {

	String email;
	
	String name;
	
	String password;
	
	String mobNo;
	
	public UserDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	public static UserDTO valueOf(User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
//		userDTO.setPassword(user.getPassword());
		userDTO.setMobNo(user.getMobNo());
		return userDTO;
	}
	
	public User createEntity() {
		User user = new User();
		user.setEmail(this.email);
		user.setName(this.name);
		user.setPassword(this.password);
		user.setMobNo(this.mobNo);
		return user;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserDTO[email="+email+", name="+name+", mobNo="+mobNo+"]";
	}


}
