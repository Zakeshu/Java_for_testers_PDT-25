package com.example.tests;


import java.util.Random;
import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
public class GroupRemovalTests  extends TestBase {
	@Test
	public void deleteSomeGroup (){

		//save old state
//		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		
		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size()-1); 
		
		// actions
		app.getGroupHelper().deleteGroup(index);
		
		//save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		
		//compare states
		assertThat(newList,equalTo(oldList.without(index)));
		
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
