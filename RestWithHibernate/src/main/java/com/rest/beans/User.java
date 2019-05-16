package com.rest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue
	@Column
	Integer id;
	@Column
	String name;
	@Column
	String add;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String add) {
		this.id = id;
		this.name = name;
		this.add = add;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
}
