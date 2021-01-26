package org.techforce.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
@Id
@Column(name="SID")
private Integer id;
@Override
public String toString() {
	return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", branch=" + branch + "]";
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(Integer id, String fname, String lname, String branch) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.branch = branch;
}
@Column(name="FIRST_NAME")
private String fname;
@Column(name="LAST_NAME")
private String lname;
@Column(name="BRANCH")
private String branch;

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}

}
