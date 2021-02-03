package org.techforce.hibernate.inheritance_table_per_class;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "I_ACCOUNT_TPC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account {
	@Id
	@Column(name = "ACCOUNT_NO")
	private Long account_no;
	@Column(name = "OPEN_DATE")
	private Date open_date;
	@Column(name = "BALANCE")
	private Double balance;
	@Column(name = "ACCOUNT_STATUS")
	private String account_status;
	public Long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(Long account_no) {
		this.account_no = account_no;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
}
