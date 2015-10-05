package com.example.tests;

import com.example.utils.SortedListOf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static org.hamcrest.Matchers.*;

public class GroupCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> groupsFromFile(){
		return wrapGroupsForDataProvider(LoadGroupsFromFile (5)).iterator();
	}	

	//	@Test(dataProvider ="randomValidGroupGenerator")
	@Test(dataProvider ="groupsFromFile")
	public void testGroupCreationWithValidDate(GroupData group) throws Exception {

		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		//compare states	
		assertThat(newList,equalTo(oldList.withAdded(group)));

	}
}
