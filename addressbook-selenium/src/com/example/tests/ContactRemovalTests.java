package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void modifySomeGroup (){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().gotoContactUpdatePage();
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().openMainPage();
	}
}
