package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;

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
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title"); 
			contact.lastName = title.substring("Select (Alex ".length(), title.length() - ")".length());
			contacts.add(contact);
		}
		return contacts;
	}
}
