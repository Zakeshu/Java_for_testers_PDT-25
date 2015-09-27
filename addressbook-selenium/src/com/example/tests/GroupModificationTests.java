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

public class GroupModificationTests extends TestBase {

	@Test(dataProvider ="randomValidGroupGenerator")
	public void modifySomeGroup (GroupData group){

		//save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		Random rnd = new Random ();
		int index = rnd.nextInt(oldList.size()-1); 

		// actions 
		app.getGroupHelper().modifyGroup(index,group);

		//save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

		//compare states
		assertThat(newList,equalTo(oldList.without(index).withAdded(group)));
	
	}
}
