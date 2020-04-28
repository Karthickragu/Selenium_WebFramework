package com.radio.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.radio.base.Testengine;

public class Signup extends Testengine {

	WebDriver driver;
	//protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Select select;

	public Signup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		e_wait = new WebDriverWait(driver, 30);
	}

	@FindBy(xpath = "//h2[contains(text(),'Sign up for our Talent Community')]")
	WebElement signup_Form_Header_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Where did we meet you in-person')]")
	WebElement signup_Form_meet_in_Person_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//select[@id='form-field-96164c2dd1']")
	WebElement signup_Form_meet_in_Person_dropdown;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Current organization')]")
	WebElement signup_Form_currentOrg_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@id='form-field-71dfd8666d']")
	WebElement signup_Form_currentOrg_Textbox;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Skills')]")
	WebElement signup_Form_Skills_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@id='form-field-7dd1074365']")
	WebElement signup_Form_Skills_Textbox;

	@FindBy(xpath = "//label[contains(text(),'Last Name')]")
	WebElement signup_Form_LastName_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@id='form-field-11a4d1d9e2']")
	WebElement signup_Form_LastName_Textbox;

	@FindBy(xpath = "//label[contains(text(),'Category')]")
	WebElement signup_Form_JobCategory_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//select[@id='form-field-0d417da01d-category']")
	WebElement signup_Form_JobCategory_dropdown;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Did we meet at any of the below events')]")
	WebElement signup_Form_meet_in_Events_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//select[@id='form-field-9a2823a407']")
	WebElement signup_Form_meet_in_Events_dropdown;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Number of years of experience')]")
	WebElement signup_Form_Experience_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@id='form-field-e4e7be4417']")
	WebElement signup_Form_Experience_Textbox;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Location')]")
	WebElement signup_Form_Location_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@id='form-field-0d417da01d-location']")
	WebElement signup_Form_Location_Textbox;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//label[contains(text(),'Phone Number')]")
	WebElement signup_Form_PhoneNumber_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@id='form-field-8c0f237607']")
	WebElement signup_Form_PhoneNumber_Textbox;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//span[contains(text(),'Select a job category from the list of options. Se')]")
	WebElement signup_Form_GeneralText_AddJob_label;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//input[@class='submit-button']")
	WebElement signup_Form_Submit_Button;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//button[@class='reset-form']")
	WebElement signup_Form_Reset_Button;

	@FindBy(xpath = "//form[@class = 'data-form hidden-ja-form ']//button[@class='keyword-add']")
	WebElement signup_Form_Add_Button;

	public void verifyAllLabels() {
		e_wait.until(ExpectedConditions.visibilityOf(signup_Form_Header_label));
		Assert.assertEquals(signup_Form_Header_label.getText(), "Sign up for our Talent Community");
		//Assert.assertEquals(signup_Form_meet_in_Person_label.getText(), "Where did we meet you in-person");
		//Assert.assertEquals(signup_Form_currentOrg_label.getText(), "Current organization");
		//Assert.assertEquals(signup_Form_Skills_label.getText(), "Skills");
		Assert.assertEquals(signup_Form_LastName_label.getText(), "Last Name");
		Assert.assertEquals(signup_Form_JobCategory_label.getText(), "Job Category");
		//Assert.assertEquals(signup_Form_meet_in_Events_label.getText(), "Did we meet at any of the below events");
		//Assert.assertEquals(signup_Form_Experience_label.getText(), "Number of years of experience");
		Assert.assertEquals(signup_Form_Location_label.getText(), "Location");
		//Assert.assertEquals(signup_Form_PhoneNumber_label.getText(), "Phone Number");
		//Assert.assertEquals(signup_Form_GeneralText_AddJob_label.getText(),
			//	"Select a job category from the list of options. Search for a location and select one from the list of suggestions. Finally, click “Add” to create your job alert.");
	}

	public Boolean select_MeetinPerson(String country) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.visibilityOf(signup_Form_meet_in_Person_dropdown));
		select = new Select(signup_Form_meet_in_Person_dropdown);
		signup_Form_meet_in_Person_dropdown.click();
		try {
			List<WebElement> options = select.getOptions();
			for (WebElement entries : options) {
				if (entries.getText().equals(country)) {
					entries.click();
					assertion = true;
					log.info("Country selected as " + country);
				}
			}
		} catch (Exception e) {
			log.fatal("Unable to find the country " + country + " in the dropdownlist");
			assertion = false;
		}
		return assertion;
	}

	public Boolean select_MeetinEvents(String event) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.visibilityOf(signup_Form_meet_in_Events_dropdown));
		select = new Select(signup_Form_meet_in_Events_dropdown);
		signup_Form_meet_in_Events_dropdown.click();
		try {
			List<WebElement> options = select.getOptions();
			for (WebElement entries : options) {
				if (entries.getText().equals(event)) {
					entries.click();
					assertion = true;
					log.info("Event selected as " + event);
				}
			}
		} catch (Exception e) {
			log.fatal("Unable to find the Event " + event + " in the dropdownlist");
			assertion = false;
		}
		return assertion;
	}

	public String enter_currOrg(String org) {
		e_wait.until(ExpectedConditions.visibilityOf(signup_Form_currentOrg_Textbox));
		signup_Form_currentOrg_Textbox.click();
		signup_Form_currentOrg_Textbox.clear();
		try {
			signup_Form_currentOrg_Textbox.sendKeys("Personal Org");
			log.info("Value entered as " + org );
		} catch (Exception e) {
			log.error("Unable to enter the value in \"Current Organization\" textbox ");
		}
		return signup_Form_currentOrg_Textbox.getAttribute("value");
	}
}
