package com.example.tests;

import com.example.utils.SortedListOf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;

public class GroupCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
		//		return wrapGroupsForDataProvider(loadGroupsFromCsvFile (new File ("groups.txt"))).iterator();
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile (new File ("groups.xml"))).iterator();
	}	

	//		@Test(dataProvider ="randomValidGroupGenerator")
	@Test(dataProvider ="groupsFromFile")
	public void testGroupCreationWithValidDate(GroupData group) throws Exception {

		//save old state

		SortedListOf<GroupData> oldList = app.getModel().getGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		//save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();

		//compare states	
		assertThat(newList,equalTo(oldList.withAdded(group)));

		if (wantToCheck()){
			if("yes".equals(app.getProperty("check.db"))){
				assertThat(app.getModel().getGroups(),equalTo(app.getHibernateHelper().listGroups()));
			}
			if("yes".equals(app.getProperty("check.ui"))){
				assertThat(app.getModel().getGroups(),equalTo(app.getGroupHelper().getUiGroups()));
			}
		}
	} 
}
