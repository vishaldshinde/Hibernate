package org.techforce.hibernate.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name="T_CUSTMORE")
public class Customer {

	@Id
	@Column(name="CUST_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DOB")
	private Date dob;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "LOCK_ID",unique = true)
	private Locker locker;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}
	
	
	
}
