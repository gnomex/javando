package br.github.gnomex.files;

import java.io.Serializable;

public class AccountRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int account;
	private String firstName;
	private String lastName;
	private Double balance;
	
	public AccountRecord() {
		this(0, "", "", 0.0);
	}
	
	public AccountRecord(int account, String firstName, String lastName, Double balance) {
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	/**
	 * Getters and Setters
	 * */
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountRecord [account=" + account + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountRecord other = (AccountRecord) obj;
		if (account != other.account)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}	
}
