package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openContactPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.phoneHome);
		type(By.name("mobile"), contact.phoneMobile);
		type(By.name("work"), contact.phoneWork);
		type(By.name("email"), contact.email_1);
		type(By.name("email2"), contact.email_2);
		selectByText(By.name("bday"), contact.bDay);
		selectByText(By.name("bmonth"), contact.bMonth);
		type(By.name("byear"), contact.bYear);
		//selectByText(By.name("new_group"), contact.groupName);
		type(By.name("address2"), contact.address_2);
		type(By.name("phone2"), contact.phoneOther);

	}

	public void submitContactCreation() {
		click (By.name("submit"));
	}

	public void returnToHomePage() {
		click (By.linkText("home"));
	}

	//public void deleteContact(int index ) {
	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void initContactModification() {
		click(By.xpath("//input[@value='Update']"));
	}

	public void gotoContactUpdatePage() {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
	}
	
	public List<ContactData> getContacts() {
				List<ContactData> contacts = new ArrayList<ContactData>();
				int numberRows = driver.findElements(By.xpath("//tr[@name='entry']")).size();
				for (int i = 0; i < numberRows; i++) {
					ContactData contact = new ContactData();
					contact.firstName  = driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[3]")).getText();
					contact.lastName  =  driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[2]")).getText();
					contacts.add(contact);
				}
				return contacts;
		 	}

	public int getSumCountContacts() {
		int sumCountContacts = Integer.parseInt(driver.findElement(By.id("search_count")).getText());
		return sumCountContacts;	
	}
	
	
}
