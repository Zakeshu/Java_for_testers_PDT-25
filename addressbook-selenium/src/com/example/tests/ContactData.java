package com.example.tests;

public class ContactData {
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
}