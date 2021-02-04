package org.techforce.hibernate.envers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "E_LOGIN")
@Audited
public class Login {
	@Id
	@Column(name = "Id")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "USER")
	private String user;
	@Column(name = "PASSWORD")
	private String password;
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", user=" + user + ", password=" + password + "]";
	}
}
