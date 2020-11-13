package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserOrder")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="state")
	protected String state;
	
	public User() {
	}
	
	public User(String name, String state) {
		super();
		this.name = name;
		this.state = state;
	}

	public User(int id, String name, String state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public int getId() {
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
	public String getState() {
		return state;
	}
	public void setEmail(String state) {
		this.state = state;
	}
}