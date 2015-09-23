package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address;
	public String phoneHome;
	public String phoneMobile;
	public String phoneWork;
	public String email_1;
	public String email_2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String groupName;
	public String address_2;
	public String phoneOther;

	public ContactData(String firstName, String lastName, String address, String phoneHome, String phoneMobile,
			String phoneWork, String email_1, String email_2, String bDay, String bMonth, String bYear,
			String groupName, String address_2, String phoneOther) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneHome = phoneHome;
		this.phoneMobile = phoneMobile;
		this.phoneWork = phoneWork;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.groupName = groupName;
		this.address_2 = address_2;
		this.phoneOther = phoneOther;
	}
	public ContactData() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phoneHome=" + phoneHome + ", phoneMobile=" + phoneMobile + ", phoneWork=" + phoneWork
				+ ", email_1=" + email_1 + ", email_2=" + email_2 + ", bDay=" + bDay + ", bMonth=" + bMonth + ", bYear="
				+ bYear + ", groupName=" + groupName + ", address_2=" + address_2 + ", phoneOther=" + phoneOther + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}
}