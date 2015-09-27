package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void removeSomeContacts () {
		app.navigateTo().mainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size()-1);
		app.getContactHelper()
		.gotoContactUpdatePage(index);
		app.getContactHelper().deleteContact();
		app.navigateTo().mainPage();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		oldList.remove(index);
		Collections.sort(oldList); 
		Collections.sort(newList);
		assertEquals(newList,oldList);
	}
}
