package org.techforce.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOCKER")
public class Locker {
	@Id
	@Column(name="LOCK_ID")
	private Integer id;
	@Column(name="TYPE")
	private String type;
	@Column(name="RENT")
	private Double rent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}
}
