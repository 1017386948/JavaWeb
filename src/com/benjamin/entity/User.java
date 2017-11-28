package com.benjamin.entity;

public class User {
	private Integer id;
	private String name;
	private Integer age;
	private String telephone;

	public User() {
	}

	public User(Integer id, String name, Integer age, String telephone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.telephone = telephone;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", telephone=" + telephone + "]";
	}

}
