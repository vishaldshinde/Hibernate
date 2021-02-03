package org.techforce.hibernate.inheritance_table_per_class;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="I_CURRENT_ACCOUNT_TPC")
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
