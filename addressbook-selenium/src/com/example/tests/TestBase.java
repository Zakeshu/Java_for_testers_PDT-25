package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.example.tests.GroupData;
import com.example.tests.ContactData;
import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {
	
	protected ApplicationManager app;
	private int checkFrequency;
	private int checkCounter;

	@BeforeTest
	public void setUp() throws Exception { 
		String configFile =System.getProperty("configFile","firefox.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new  File(configFile)));
		app = new ApplicationManager (properties);
		checkCounter = 0;
		checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
	}

	protected boolean wantToCheck(){
		checkCounter++ ;
		if(checkCounter > checkFrequency ){
			checkCounter = 0;
			return true;
		} else {
			return false;
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop ();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		//		List<Object[]> list = new ArrayList<Object[]>();
//		Random rnd = new Random ();
//		for (int i=0;i<5;i++){
//			GroupData group = new GroupData()
//			.withName (generateRandomString())
//			.withHeader (generateRandomString())
//			.withFooter (generateRandomString());
//			/*
//			 * group.name = generateRandomString();
//			 */
//			list.add(new Object[]{group});
//		}
		return wrapGroupsForDataProvider(generateRandomGroups (5)).iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList <Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		//		List<Object[]> list = new ArrayList<Object[]>();
//		Random rnd = new Random ();
//		for (int i=0;i<2;i++){
//			ContactData contact = new ContactData ()
//			.withFirstName  (generateRandomString())
//			.withLastName  (generateRandomString())
//			.withAddress  (generateRandomString())
//			.withPhoneHome  (generateRandomString())
//			.withPhoneMobile  (generateRandomString())
//			.withPhoneWork  (generateRandomString())
//			.withEmail_1  (generateRandomMail())
//			.withEmail_2  (generateRandomMail())
//			.withAddress_2  (generateRandomString())
//			.withPhoneOther  (generateRandomString())
//			.withBDay  (generateRandomDay())
//			.withBMonth  (generateRandomMonth())
//			.withBYear (generateRandomYear());
//			list.add(new Object[]{contact});
//		}
		return wrapContactsForDataProvider(generateRandomContacts (5)).iterator();
	}
	
	public static  List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList <Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}

//	public String generateRandomString(){
//		Random rnd = new Random ();
//		if(rnd.nextInt(3) == 0 ){
//			return "";
//		} else {
//			return "test" + rnd.nextInt();
//		}
//	}
	
//	public String generateRandomMail(){
//		Random rnd = new Random ();
//		if(rnd.nextInt(2) == 0 ){
//			return "";
//		} else {
//			return "mail" + rnd.nextInt()+ "@aol.com";
//		}
//	}
//	
//	public String generateRandomDay() {
//		Random rnd =new Random();
//		return Integer.toString(rnd.nextInt(31));
//	}
//	
//	public String generateRandomMonth() {
//		Random rnd =new Random();
//		String[] monthList = new String[] {"January","February","March","April","May","June","July", "August","September","October", "November", "December"};
//		int index = rnd.nextInt(11);
//		return monthList[index];
//	}
//	
//	public String generateRandomYear() {
//		Random rnd =new Random();
//		return Integer.toString(1900+rnd.nextInt(13));
//	}
}
