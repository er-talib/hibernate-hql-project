package com.hibernate.hql.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int stuId ;
	private String stuName ;
	private String stuCity ;
	private String phone ;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuCity() {
		return stuCity;
	}
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
//	// use for print object 
//	@Override
//	public String toString() {
//		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuCity=" + stuCity + ", phone=" + phone + "]";
//	}
	
	

}
