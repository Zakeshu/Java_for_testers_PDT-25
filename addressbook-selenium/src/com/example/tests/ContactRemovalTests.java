package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactRemovalTests extends TestBase{
	@Test
	public void removeSomeContacts () {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size()-1);
		app.getContactHelper().deleteContact(index);
	//	app.navigateTo().mainPage();
		
		//save new state
		

		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
//		oldList.remove(index);
//		Collections.sort(oldList); 
//		Collections.sort(newList);
//		assertEquals(newList,oldList);
		assertThat(newList,equalTo(oldList.without(index)));
	}
}
