package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static com.example.fw.ContactHelper.CREATION;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider ="randomValidContactGenerator")
	public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		// actions 
		app.getContactHelper().createContact(contact);

		
		//save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare states		
//		oldList.add(contact);
//		Collections.sort(oldList); 
		Collections.sort(newList);
//		assertEquals(newList,oldList);
		assertThat(newList,equalTo(oldList.withAdded(contact)));
	}

	   @Test
	      public void compareSumCountContacts () {
	      	app.navigateTo().mainPage(); 
	      	assertEquals(app.getContactHelper().getSumCountContacts(), app.getContactHelper().getContacts().size());
	      }

}
