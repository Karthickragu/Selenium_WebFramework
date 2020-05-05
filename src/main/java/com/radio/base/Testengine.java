package com.radio.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.radio.report.Reporters;
import com.radio.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testengine {

	//public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static WebDriver driver;
	public static Logger log;
	public static WebDriverWait e_wait;
	public static Date date;
	public static String testCase;
	public static int totalTCs;
	public static int passedTCs;
	public static int failedTCs;
	public static int skippedTCs;
	public static SoftAssert soft;
	public static String methodName;
	public static String folder_TStamp;
	public static String timeStamp;
	public static ExtentTest test;

	public static String browser;
	protected static Properties properties;
	public static String propertyFilePath;

	public static Utilities util = new Utilities();
	public static Reporters report = new Reporters();

	@BeforeSuite
	public static void start_TestSuite() {

		// log.debug("Currently Executing in method : " + e.getName());

		// log = Logger.getLogger("devpinoyLogger");

		folder_TStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		log = Logger.getLogger(Testengine.class);
		log.debug("--information--");

		log.info(
				"*******************************************\nInitiating Logger.... \n******************************************* \n");

		log.info(
				"*******************************************\nReading Config File.... \n******************************************* \n");
		propertyFilePath = "config//Configuration.properties";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				log.info("Properties file loaded successfully:");
			} catch (IOException ioE) {
				ioE.printStackTrace();
			}
		} catch (FileNotFoundException fnfE) {
			fnfE.printStackTrace();
			log.fatal("Unable to find/Load the Properties file ");
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		log.info(
				"*******************************************\n Setting Up Excel Sheet.... \n******************************************* \n");
	}

	@BeforeTest
	@Parameters({ "preferredBrowser", "platformVersion" })
	public static void setUp_Test(String preferredBrowser, @Optional String platformVersion) {
		// log.debug("Currently Executing in method : " + e.getName());
		log.info("Setting up Test Summary");
		browser = preferredBrowser;
		report.reportLocation(browser, folder_TStamp, timeStamp);
		totalTCs = 0;
		passedTCs = 0;
		failedTCs = 0;
		skippedTCs = 0;

		log.info("Getting the WebDriver Instances for the " +browser+ " browser");
		driver = BrowserFactory.createInstance(browser, platformVersion);
		DriverFactory.getInstance().setDriver(driver);
		driver = DriverFactory.getInstance().getDriver();

		try {
			log.debug("In Debug Mode");
			log.debug("Launching the website \"https://www.gfgfgfg.com/\" ");
			driver.get("https://www.ghghgh.com/");
		} catch (Exception exc) {
			log.fatal("Failed to open the website", exc);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public static void start_Test(Method method) {
		methodName = method.getName().toString();
		log.info("\n" + "****** starting test:" + methodName + "******" + "\n");
		test = Reporters.extent.createTest(methodName);
		test.assignCategory(browser);
		date = new Date();
		log.info("Browser Launched at " + date);

		System.out.println("-------------------------------------------  " + methodName + " Test started at " + date
				+ " -------------------------------------------\n ");
	}

	@AfterMethod
	public static void end_Testcase() {
		log.info("\n" + "****** Finishing test:" + methodName + "******" + "\n");
		// Reporters.extent.endTest(test);
		Reporters.extent.flush();
		// Reporters.extent.
	}

	@AfterTest
	public static void finish_Test() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public static void end_TestSuite() {
		DriverFactory.getInstance().removeDriver();
		log.info(
				"******************************************* // End of the Test // *******************************************\n");
		log.info("Total number of Testcases Executed " + totalTCs);
		log.info("Total number of Testcases Passed " + passedTCs);
		log.info("Total number of Testcases Failed " + failedTCs);
		log.info("Total number of Testcases Skipped " + skippedTCs);
		log.info(
				"*************************************************************************************************************\n");
	}

}
