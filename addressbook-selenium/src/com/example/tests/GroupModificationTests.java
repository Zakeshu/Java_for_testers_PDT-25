package com.example.tests;

import java.util.Random;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider ="randomValidGroupGenerator")
	public void modifySomeGroup (GroupData group){

		//save old state
//		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		
		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size()-1); 

		// actions 
		app.getGroupHelper().modifyGroup(index,group);

		//save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();

		//compare states
		assertThat(newList,equalTo(oldList.without(index).withAdded(group)));
		
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
