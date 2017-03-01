package ru.msk.tkachenko.dmitry.web.springphonebook.model;

import java.io.Serializable;

public class User implements Serializable {
	private Long id;
	private String username;
	private String phone;

	public User() {}

	public User(Long id, String username, String phone) {
		this.id = id;
		this.username = username;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
