package com.jw.entity;

public class Teacher {
	private int tid;
	private String name;
	private String sex;
	private int age;
	private String address;
	
	public Teacher(){}
	
	public Teacher(int tid,String name,String sex,int age,String address){
		this.tid=tid;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.address=address;
	}
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", address=" + address + "]";
	}
	
	
}
