package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static com.example.fw.ContactHelper.CREATION;


public class ContactCreationTests extends TestBase {

	@Test(dataProvider ="randomValidContactGenerator")
	public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		app.navigateTo().mainPage();
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions 
		app.getContactHelper()
		.openContactPage()
		.fillContactForm(contact,CREATION)
		.submitContactCreation()
		.returnToHomePage();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		//compare states		
		oldList.add(contact);
		Collections.sort(oldList); 
		Collections.sort(newList);
		assertEquals(newList,oldList);
	}

	   @Test
	      public void compareSumCountContacts () {
	      	app.navigateTo().mainPage(); 
	      	assertEquals(app.getContactHelper().getSumCountContacts(), app.getContactHelper().getContacts().size());
	      }

}
