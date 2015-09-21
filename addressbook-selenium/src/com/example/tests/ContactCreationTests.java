package com.example.tests;

import org.testng.annotations.Test;
public class ContactCreationTests extends TestBase {


	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openContactPage();
		ContactData contact = new ContactData();
		contact.firstName = "Alex";
		contact.lastName = "Zakeshi";
		contact.address = "UA";
		contact.phoneHome = "75612354";
		contact.phoneMobile = "+381564586512";
		contact.phoneWork = "7612354";
		contact.email_1 = "mail_1@aol.com";
		contact.email_2 = "mail_2@aol.com";
		contact.bDay = "13";
		contact.bMonth = "September";
		contact.bYear = "1900";
		contact.groupName = "name 1";
		contact.address_2 = "street Lenina";
		contact.phoneOther = "over999";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openContactPage();
		ContactData contact = new ContactData();
		contact.firstName = "";
		contact.lastName = "";
		contact.address = "";
		contact.phoneHome = "";
		contact.phoneMobile = "";
		contact.phoneWork = "";
		contact.email_1 = "";
		contact.email_2 = "";
		contact.bDay = "-";
		contact.bMonth = "-";
		contact.bYear = "-";
		contact.groupName = "";
		contact.address_2 = "";
		contact.phoneOther = "";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}
}
