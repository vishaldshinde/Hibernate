package org.techforce.hibernate.inheritance_joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="I_SAVING_ACCOUNT_J")
public class SavingAccount extends Account {
	@Column(name = "MINIMUM_BALANCE")
	private Double minimum_balance;

	public Double getMinimum_balance() {
		return minimum_balance;
	}

	public void setMinimum_balance(Double minimum_balance) {
		this.minimum_balance = minimum_balance;
	}
}
