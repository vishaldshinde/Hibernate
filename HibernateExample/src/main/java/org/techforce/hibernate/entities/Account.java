package org.techforce.hibernate.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	@Id
	@Column(name = "ACCOUNT_NO")
	private Long account_no;
	@Column(name = "account_type")
	private String account_type;
	@Column(name = "OPENING_DATE")
	private Date opening_date;
	@Column(name = "account_status")
	private String account_status;
	
	private String ACH;

	public String getACH() {
		return ACH;
	}

	public void setACH(String aCH) {
		ACH = aCH;
	}

	public Long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(Long account_no) {
		this.account_no = account_no;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Date getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
}
