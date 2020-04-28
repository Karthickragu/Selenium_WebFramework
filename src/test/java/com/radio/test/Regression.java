package com.radio.test;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.radio.base.Testengine;
import com.radio.pages.APICalls;
import com.radio.pages.Homepage;
import com.radio.pages.JDScreen;
import com.radio.pages.SearchResult;
import com.radio.pages.Signup;
import com.radio.report.Reporters;

public class Regression extends Testengine {
	
	//protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static Homepage home;
	public static SearchResult searchpage;
	public static JDScreen jdscreen;
	public static Signup signup;
	public static APICalls apiTest; 
	
	public Boolean result;
	
	@BeforeClass
	public void set_Prerequisite() {
		home = new Homepage(driver);
		searchpage = new SearchResult(driver);
		jdscreen = new JDScreen(driver);
		signup = new Signup(driver);
		apiTest = new APICalls();
		test = Reporters.test;
		
	}
	
	
	
	@Test(priority = 0)
	public void verify_Login_API() {
		System.out.println(apiTest.getValue());
	}
	
	
	@Test(priority=1)
	public void test1() throws ParseException {
		System.out.println("555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
		apiTest.getValue_Login("admin", "admin123");
		System.out.println("555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
		String value = home.enterDescription(test, "Developer");
		System.out.println(value);
		Assert.assertEquals(value, "Developer");
	}
/*
	@Test(priority=2)
	public void test2() {
		result = home.pick_Country("India");
		System.out.println(result);
		Assert.assertTrue(result);
		log.info("");
	}
	
	@Test(priority=3)
	public void test3() {
		result = home.pick_State("Karnataka");
		System.out.println(result);
		Assert.assertTrue(result);
		log.info("");
	}
	
	@Test(priority=4)
	public void test4() {
		result = home.pick_City("Bengaluru");
		System.out.println(result);
		Assert.assertTrue(result);
		log.info("");
	}
	
	@Test(priority=5)
	public void test5() {
		result = home.start_Search();
		Assert.assertTrue(result);
	}
	
	@Test(priority=6)
	public void test6() {
	//	result = searchpage.verifySearchGrid("Systems Development Engineer 4", "Bengaluru, Karnataka; Chennai, Tamil Nadu; Hyderabad, Telangana", "10/09/2019");
		result = searchpage.verifySearchGrid("Tech Development Sr Mgr 1", "Bengaluru, Karnataka; Hyderabad, Telangana", "02/04/2020");
		Assert.assertTrue(result);
	}
	
	
	@Test(priority=7) // Priority chagne
	public void testa1() throws InterruptedException {
		String value = home.enterDescription(test,"Developer");
		System.out.println(value);
		Assert.assertEquals(value, "Developer");
		home.clearCountyRegion();
		Thread.sleep(2000);
		home.start_Search();
		
		searchpage.verifySearchGrid("Sr. Ab Initio Developer / Technical Lead (Apps Systems Engineer 5)", "Concord, California", "04/22/2020");
	}
	
	
	@Test(priority=8)
	public void test7() {
		jdscreen.jdScreen_SignupUI("Sr. Ab Initio Developer / Technical Lead (Apps Systems Engineer 5)");
	}
	
	@Test(priority=9)
	public void test8() throws InterruptedException {
		jdscreen.jdScreen_Signup();
	}
	
	@Test(priority=10)
	public void test9() throws InterruptedException {
		 signup.verifyAllLabels();
	}
	
	
	@Test(priority=11)
	public void test10() throws InterruptedException {
		result =signup.select_MeetinPerson("Canada & Latin America");
		Assert.assertTrue(result);
		result = signup.select_MeetinEvents("Conference or Seminar");
		Assert.assertTrue(result);
		String value = signup.enter_currOrg("Personal Org");
		Assert.assertEquals(value, "Personal Org");
	}
*/
}
