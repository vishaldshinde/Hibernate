package org.techforce.hibernate.inheritance_table_per_class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="I_SAVING_ACCOUNT_TPC")
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
