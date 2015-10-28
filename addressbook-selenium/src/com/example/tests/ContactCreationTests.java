package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		//		return wrapContactsForDataProvider(loadContactsFromCsvFile (new File("contacts.txt"))).iterator();
		return wrapContactsForDataProvider(loadContactsFromXmlFile (new File("contacts.xml"))).iterator();
	}

	//	@Test(dataProvider ="randomValidContactGenerator")
	@Test(dataProvider ="contactsFromFile")
	public void testNonEmptyContactCreation(ContactData contact) throws Exception {

		//save old state
		//		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		//		SortedListOf<ContactData> oldList 
		//			= new SortedListOf<ContactData> ( app.getHibernateHelper().listContacts());
		SortedListOf<ContactData> oldList = app.getModel().getContacts();

		// actions 
		app.getContactHelper().createContact(contact);

		//save new state
		//		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		//		SortedListOf<ContactData> newList 
		//			= new SortedListOf<ContactData> ( app.getHibernateHelper().listContacts());
		SortedListOf<ContactData> newList = app.getModel().getContacts();

		//compare states		
		assertThat(newList,equalTo(oldList.withAdded(contact)));

		if (wantToCheck()){
			if("yes".equals(app.getProperty("check.db"))){
				assertThat(app.getModel().getContacts(),equalTo(app.getHibernateHelper().listContacts()));
			}
			if("yes".equals(app.getProperty("check.ui"))){
				assertThat(app.getModel().getContacts(),equalTo(app.getContactHelper().getUiContacts())); 
			}	
		}
	}
	//	   @Test
	//	      public void compareSumCountContacts () {
	//	      	app.navigateTo().mainPage(); 
	//	      	assertEquals(app.getContactHelper().getSumCountContacts(), app.getContactHelper().getContacts().size());
	//	      }
}
