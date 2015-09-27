package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import com.example.tests.ContactData;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	public void createContact(ContactData contact) {
		openContactPage();
		fillContactForm(contact,CREATION);
		submitContactCreation();
		returnToHomePage();
	}
	public ContactHelper openContactPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact,boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getPhoneHome());
		type(By.name("mobile"), contact.getPhoneMobile());
		type(By.name("work"), contact.getPhoneWork());
		type(By.name("email"), contact.getEmail_1());
		type(By.name("email2"), contact.getEmail_2());
		selectByText(By.name("bday"), contact.getBDay());
		selectByText(By.name("bmonth"), contact.getBMonth());
		type(By.name("byear"), contact.getBYear());
		//selectByText(By.name("new_group"), contact.groupName);
		if (formType ==CREATION){
			//selectByText(By.name("new_group"), "group_1");
		}else {
			if(driver.findElements(By.name("new_group")).size()!=0){
				throw new Error ("Group selector exists in contact modification form");
			}
		}

		type(By.name("address2"), contact.getAddress_2());
		type(By.name("phone2"), contact.getPhoneOther());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click (By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click (By.linkText("home"));
		return this;
	}

	//public void deleteContact(int index ) {
	public ContactHelper deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		return this;
	}

	public ContactHelper initContactModification() {
		click(By.xpath("//input[@value='Update']"));
		return this;
	}

	public void gotoContactUpdatePage(int index) {
		click(By.xpath("//tr[@name='entry']["+(index+1)+"]/td/a/img[@title='Edit']/.."));
	}
	
	public List<ContactData> getContacts() {
				List<ContactData> contacts = new ArrayList<ContactData>();
				int numberRows = driver.findElements(By.xpath("//tr[@name='entry']")).size();
				for (int i = 0; i < numberRows; i++) {
					ContactData contact = new ContactData();
//					contact.withFirstName  = driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[3]")).getText();
//					contact.withLastName  =  driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[2]")).getText();
					contact.withFirstName  (driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[3]")).getText());
					contact.withLastName ( driver.findElement(By.xpath("//tr[@name='entry']["+(i+1)+"]/td[2]")).getText());
					contacts.add(contact);
				}
				return contacts;
		 	}
/*
 * 	public List<ContactData> getContacts() {
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
*/
	public int getSumCountContacts() {
		int sumCountContacts = Integer.parseInt(driver.findElement(By.id("search_count")).getText());
		return sumCountContacts;	
	}


	
	
}
