package org.techforce.hibernate.inheritance_single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CURRENT_ACCOUNT")
public class CurrentAccount extends Account {
	@Column(name = "OVERDRAFT")
	private Double overDraftAmount;

	public Double getOverDraftAmount() {
		return overDraftAmount;
	}

	public void setOverDraftAmount(Double overDraftAmount) {
		this.overDraftAmount = overDraftAmount;
	}
}
