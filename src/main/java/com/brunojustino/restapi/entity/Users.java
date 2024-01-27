package com.brunojustino.restapi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name="email")
	private String email;

//	@OneToOne(mappedBy = "users")
//	@PrimaryKeyJoinColumn
//	private Journal journal;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Users(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public int id() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
