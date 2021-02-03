package org.techforce.hibernate.inheritance_single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("SAVING_ACCOUNT")
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
