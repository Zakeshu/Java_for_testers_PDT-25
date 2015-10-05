package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {


	public static void main(String[] args) throws IOException {
		if(args.length < 3){
			System.out.println("Please specify parametes : <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]); 
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()){
			System.out.println("File exists, please remove it manually:" + file);
			return;
		}
		
		List <ContactData> contacts = generateRandomContacts (amount);
		if ("csv".equals(format)){
			saveContactsToCsvFile (contacts, file);
		} else if ("csv".equals(format)){
			saveContactsToXmlFile (contacts, file);
		} else{
			System.out.println("Unknown format " + format);	
		}
	}



	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		Random rnd = new Random ();
		for (int i=0;i<amount;i++){
			ContactData contact = new ContactData()
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
			list.add(contact);
			}
			return list;
		}
	private static void saveContactsToXmlFile (List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub

	}

	private static void saveContactsToCsvFile (List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter (file);
		for (ContactData contact : contacts) {
			writer.write(contact.getLastName() + "," + contact.getAddress() + "," + contact.getPhoneHome() + "," + contact.getPhoneMobile() + "," + contact.getPhoneWork() + "," + contact.getEmail_1() + "," + contact.getEmail_2() + "," + contact.getAddress_2() + "," + contact.getPhoneOther() + "," + contact.getBDay() + "," + contact.getBMonth() + "," + contact.getBYear() + "\n");
		}
		writer.close();
	}
	
		public  static String generateRandomString(){
			Random rnd = new Random ();
			if(rnd.nextInt(3) == 0 ){
				return "";
			} else {
				return "test" + rnd.nextInt();
			}
		}
		
		public static String generateRandomMail(){
			Random rnd = new Random ();
			if(rnd.nextInt(2) == 0 ){
				return "";
			} else {
				return "mail" + rnd.nextInt()+ "@aol.com";
			}
		}
		
		public static String generateRandomDay() {
			Random rnd =new Random();
			return Integer.toString(rnd.nextInt(31));
		}
		
		public static  String generateRandomMonth() {
			Random rnd =new Random();
			String[] monthList = new String[] {"January","February","March","April","May","June","July", "August","September","October", "November", "December"};
			int index = rnd.nextInt(11);
			return monthList[index];
		}
		
		public static String generateRandomYear() {
			Random rnd =new Random();
			return Integer.toString(1900+rnd.nextInt(13));
		}
		

	}
