package com.example.tests;

import java.util.Random;
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
		
		//save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		assertThat(newList,equalTo(oldList.without(index)));
	}
}
