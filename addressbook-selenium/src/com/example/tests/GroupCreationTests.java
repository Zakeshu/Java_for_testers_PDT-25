package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider ="randomValidGroupGenerator")
	public void testGroupCreationWithValidDate(GroupData group) throws Exception {
		app.navigateTo().mainPage();
		app.navigateTo().groupPage();

		//save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		// actions
		app.getGroupHelper()
		.initGroupCreation()
		.fillGroupForm(group) 
		.submitGroupCreation()
		.returnToGroupsPage();

		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();

		//compare states		
		oldList.add(group);
		Collections.sort(oldList); 
		assertEquals(newList,oldList);
	}
}
