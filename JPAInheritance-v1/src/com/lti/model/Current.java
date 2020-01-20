package com.lti.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="current_table")
@DiscriminatorValue("current")
public class Current extends Account{
	private int overdraft;

	public Current(int overdraft) {
		super();
		this.overdraft = overdraft;
	}

	public Current() {
		super();
	}

	public Current(int accountId, String accountHolder, double accountBalance, int i) {
		super(accountId, accountHolder, accountBalance);
		this.overdraft = overdraft;
	}

	public int getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "Current [overdraft=" + overdraft + "]";
	}

}
