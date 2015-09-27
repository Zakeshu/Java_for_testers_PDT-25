package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void groupPage() {
		click(By.linkText("groups"));
	}

}
