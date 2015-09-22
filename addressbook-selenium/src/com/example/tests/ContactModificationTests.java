package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	@Test
	public void modifySomeGroup (){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().gotoContactUpdatePage();
		ContactData contact = new ContactData();
		contact.phoneOther = "+100500";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().initContactModification();
		app.getNavigationHelper().openMainPage();
}
}