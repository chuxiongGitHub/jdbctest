package com.caihong.entity;

public class User extends IdEntity {
	private String name;
	private String password;
	private String emial;

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

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", emial="
				+ emial + ", id=" + id + "]";
	}

}
