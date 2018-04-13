package com.jw.entity;

public class Teacher {
	private int tid;
	private String tname;
	private char sex;
	private int age;
	private String address;
	
	public Teacher(){}
	
	public Teacher(String tname,char sex,int age,String address){
		this.tname=tname;
		this.sex=sex;
		this.age=age;
		this.address=address;
	}
	public Teacher(int tid,String tname,char sex,int age,String address){
		this.tid=tid;
		this.tname=tname;
		this.sex=sex;
		this.age=age;
		this.address=address;
	}
	
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", sex=" + sex
				+ ", age=" + age + ", address=" + address + "]";
	}
	
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
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
	
	
}
