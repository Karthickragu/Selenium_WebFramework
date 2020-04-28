package com.radio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.format.DateTimeFormatter;  

import org.testng.Assert;

import com.radio.base.Testengine;

public class JDScreen extends Testengine {

	WebDriver driver;
	//protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Select select;

	public JDScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		e_wait = new WebDriverWait(driver, 30);
	}

	// 

	
//	@FindBy(xpath = "//button[@class='js-save-job-btn']")
//	WebElement jd_SaveforLater_Button;

	@FindBy(xpath = "//a[@class='button job-apply top']")
	WebElement jd_Save_Button_first;

	@FindBy(xpath = "//a[@class='button job-apply bottom']")
	WebElement jd_Save_Button_second;

	@FindBy(xpath = "//div[@class='talent cell']")
	WebElement jd_signUp_Frame;

	@FindBy(xpath = "//div[@class='talent cell']/h2[contains(text(),'Join our talent community')]")
	WebElement jd_signUp_FramejoinCommunityText1;

	@FindBy(xpath = "//div[@class='talent cell']//p[contains(text(),'Sign up to receive updates and job alerts.')]")
	WebElement jd_signUp_FramejoinCommunityText2;

	@FindBy(xpath = "//a[@class='button-like']//span[contains(text(),'Sign up')]")
	WebElement jd_signUp_Button;

	public void jdScreen_SignupUI(String desc) {
		try {
			System.out.println();
		//	e_wait.until(ExpectedConditions.visibilityOf(jd_SaveforLater_Button));
			log.info("SaveforLater_Button is displaying in the screen");
			Assert.assertTrue(true);
			
			String actualDesc = driver.findElement(By.xpath("//h1[contains(text(),'"+desc +"')]")).getText();
				Assert.assertEquals(actualDesc, desc);
		
			
			//e_wait.until(ExpectedConditions.visibilityOf(jd_Save_Button_first));
			//log.info("Save Button is displaying in the top of the screen");
			//Assert.assertTrue(true);
			//e_wait.until(ExpectedConditions.visibilityOf(jd_Save_Button_second));
			//log.info("Save Button is displaying in the bottom of the screen");
			//Assert.assertTrue(true);
			e_wait.until(ExpectedConditions.visibilityOf(jd_signUp_Frame));
			log.info("SignUP frame is displaying in the top of the screen");
			Assert.assertTrue(true);
			e_wait.until(ExpectedConditions.visibilityOf(jd_signUp_FramejoinCommunityText1));
			Assert.assertEquals(jd_signUp_FramejoinCommunityText1.getText(), "Join our talent community");
			log.info("SignUP text\"Join our talent community\" is displaying the screen");
			e_wait.until(ExpectedConditions.visibilityOf(jd_signUp_FramejoinCommunityText2));
			Assert.assertEquals(jd_signUp_FramejoinCommunityText2.getText(),
					"Sign up to receive updates and job alerts.");
			log.info("SignUP text\"Sign up to receive updates and job alerts.\" is displaying the screen");
			e_wait.until(ExpectedConditions.visibilityOf(jd_signUp_Button));
			Assert.assertTrue(true);
			log.info("SignUP button is displaying in the screen");

		} catch (Exception e) {
			log.fatal(e);
		}

	}
	
	public void jdScreen_Signup() throws InterruptedException {
		try {
			((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", jd_signUp_Button);
			log.info("Page scrolled");
		}catch(Exception e) {
			log.warn("Scrolling Failed");
		}
		e_wait.until(ExpectedConditions.visibilityOf(jd_signUp_Button));
		jd_signUp_Button.click();
		Thread.sleep(10000);
	}
}
