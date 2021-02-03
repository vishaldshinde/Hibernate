package org.techforce.hibernate.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "N_CUSTOMER")
public class NCustomer {
	@Id
	@Column(name="CUST_ID")
	private Integer cust_id;
	@Column(name="NAME")
	private String name;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="PHONE_NO")
	private String phoneno;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CUSTMORE_ACCOUNT",
	joinColumns = @JoinColumn(name="CUST_ID",referencedColumnName = "CUST_ID"),
	inverseJoinColumns = @JoinColumn(name="ACCOUNT_NO",referencedColumnName = "ACCOUNT_NO"))
	private List<Account> accounts;

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}

