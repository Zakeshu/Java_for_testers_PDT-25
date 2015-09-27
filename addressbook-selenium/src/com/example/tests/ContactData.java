package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	/*
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
*/
	 	private String firstName;
	private String lastName;
	private String address;
	private String phoneHome;
	private String phoneMobile;
	private String phoneWork;
	private String email_1;
	private String email_2;
	private String bDay;
	private String bMonth;
	private String bYear;
	private String groupName;
	private String address_2;
	private String phoneOther;


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

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withLastName (String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withAddress (String address) {
		this.address = address;
		return this;
	}
	
	public ContactData withPhoneHome (String phoneHome) {
		this.phoneHome = phoneHome;
		return this;
	}
	
	public ContactData withPhoneMobile (String phoneMobile) {
		this.phoneMobile = phoneMobile;
		return this;
	}
	
	public ContactData withPhoneWork (String phoneWork) {
		this.phoneWork = phoneWork;
		return this;
	}
	
	public ContactData withEmail_1 (String email_1) {
		this.email_1 = email_1;
		return this;
	}
	
	public ContactData withEmail_2 (String email_2) {
		this.email_2 = email_2;
		return this;
	}
	
	public ContactData withAddress_2 (String address_2) {
		this.address_2 = address_2;
		return this;
	}
	
	public ContactData withPhoneOther (String phoneOther) {
		this.phoneOther = phoneOther;
		return this;
	}
	
	public ContactData withBDay (String bDay) {
		this.bDay = bDay;
		return this;
	}
	
	public ContactData withBMonth (String bMonth) {
		this.bMonth = bMonth;
		return this;
	}
	
	public ContactData withBYear (String bYear) {
		this.bYear = bYear;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}
	
	public String getPhoneHome() {
		return phoneHome;
	}
	
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public String getPhoneWork() {
		return phoneWork;
	}
	
	public String getEmail_1() {
		return email_1;
	}
	
	public String getEmail_2() {
		return email_2;
	}
	public String getAddress_2() {
		return address_2;
	}
	
	public String getPhoneOther() {
		return phoneOther;
	}
	
	public String getBDay() {
		return bDay;
	}
	
	public String getBMonth() {
		return bMonth;
	}
	
	public String getBYear() {
		return bYear;
	}
}