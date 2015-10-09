package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

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
	protected Logger log = Logger.getLogger("TEST");

	@BeforeTest
	@Parameters({"ConfigFile"})
	
	public void setUp(@Optional String configFile) throws Exception { 
		if (configFile == null) {
			configFile = System.getProperty("configFile");
		}
		if (configFile == null) {
			configFile = System.getenv("configFile");
		}
		if (configFile == null) {
			configFile = "application.properties";
		}
		Properties props = new Properties();
		props.load(new FileReader (configFile));
		log.info("setUp start");
		app = ApplicationManager.getInstance();
		app.setProperties (props);
		log.info("setUp end");
		
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		log.info("setUp start");
		app = ApplicationManager.getInstance().stop();
		log.info("setUp end");
	}
}
