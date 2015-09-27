package com.example.tests;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTests extends TestBase {

	@Test(dataProvider ="randomValidGroupGenerator")
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
