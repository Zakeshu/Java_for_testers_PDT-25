package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.example.tests.GroupData;
import com.example.tests.ContactData;
import com.example.fw.ApplicationManager;
public class TestBase {

	protected ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager ();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop ();

	}
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random ();
		for (int i=0;i<5;i++){
			GroupData group = new GroupData()
			.withName (generateRandomString())
			.withHeader (generateRandomString())
			.withFooter (generateRandomString());
			/*
			 * group.name = generateRandomString();
			 */
			list.add(new Object[]{group});
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		Random rnd = new Random ();
		for (int i=0;i<2;i++){
			ContactData contact = new ContactData ()
			.withFirstName  (generateRandomString())
			.withLastName  (generateRandomString())
			.withAddress  (generateRandomString())
			.withPhoneHome  (generateRandomString())
			.withPhoneMobile  (generateRandomString())
			.withPhoneWork  (generateRandomString())
			.withEmail_1  (generateRandomMail())
			.withEmail_2  (generateRandomMail())
			.withAddress_2  (generateRandomString())
			.withPhoneOther  (generateRandomString())
			.withBDay  (generateRandomDay())
			.withBMonth  (generateRandomMonth())
			.withBYear (generateRandomYear());
			/*
			contact.firstName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.address = generateRandomString();
			contact.phoneHome = generateRandomString();
			contact.phoneMobile = generateRandomString();
			contact.phoneWork = generateRandomString();
			contact.email_1 = generateRandomMail();
			contact.email_2 = generateRandomMail();
			contact.address_2 = generateRandomString();
			contact.phoneOther = generateRandomString();
			contact.bDay =generateRandomDay();
			contact.bMonth =generateRandomMonth();
			contact.bYear =generateRandomYear();
		*/
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	public String generateRandomString(){
		Random rnd = new Random ();
		if(rnd.nextInt(3) == 0 ){
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	public String generateRandomMail(){
		Random rnd = new Random ();
		if(rnd.nextInt(2) == 0 ){
			return "";
		} else {
			return "mail" + rnd.nextInt()+ "@aol.com";
		}
	}
	public String generateRandomDay() {
		Random rnd =new Random();
		return Integer.toString(rnd.nextInt(31));
	}
	public String generateRandomMonth() {
		Random rnd =new Random();
		String[] monthList = new String[] {"January","February","March","April","May","June","July", "August","September","October", "November", "December"};
		int index = rnd.nextInt(11);
		return monthList[index];
	}
	public String generateRandomYear() {
		Random rnd =new Random();
		return Integer.toString(1900+rnd.nextInt(100));
	}

}
