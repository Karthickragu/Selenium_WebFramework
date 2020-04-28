package com.radio.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.radio.base.Testengine;

public class Homepage extends Testengine {

	WebDriver driver;
	//protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Select select;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		e_wait = new WebDriverWait(driver, 30);
	}

	@FindBy(className = "advanced-search-keyword")
	WebElement search_Keyword;

	@FindBy(className = "advanced-search-country")
	WebElement search_Country;

	@FindBy(className = "advanced-search-state")
	WebElement search_State;

	@FindBy(className = "advanced-search-city")
	WebElement search_City;

	@FindBy(xpath = "//button[@type = 'submit']")
	public static WebElement search_Button;

	public String enterDescription(ExtentTest info, String desc) {
		e_wait.until(ExpectedConditions.elementToBeClickable(search_Keyword));
		info.pass("Sending the value " +desc+ " in the Keyword field"  );
		search_Keyword.sendKeys(desc);
		log.info(methodName + " : " + "Description Entered as "+desc );
		return search_Keyword.getAttribute("value");
	}

	public Boolean pick_Country(String country) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.elementToBeClickable(search_Country));
		select = new Select(search_Country);
		search_Country.click();
		try {
			List<WebElement> options = select.getOptions();
			for(WebElement entries: options) {
				if (entries.getText().equals(country)) {
					entries.click();
					assertion = true;
					log.info(methodName + " : " + "Country selected as "+country );
				}
			}
		}catch(Exception e) {
			log.fatal("Unable to find the country " +country + " in the dropdownlist");
			assertion = false;
		}
		
		return assertion;
	}

	public Boolean pick_State(String state) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.elementToBeClickable(search_State));
		select = new Select(search_State);
		search_State.click();
		try {
			List<WebElement> options = select.getOptions();
			for(WebElement entries: options) {
				if (entries.getText().equals(state)) {
					entries.click();
					assertion = true;
					log.info(methodName + " : " + "Country selected as "+state );
				}
			}
		}catch(Exception e) {
			log.fatal("Unable to find the country " +state + " in the dropdownlist");
			assertion = false;
		}
		
		return assertion;
	}

	public Boolean pick_City(String city) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.elementToBeClickable(search_City));
		select = new Select(search_City);
		search_City.click();
		try {
			List<WebElement> options = select.getOptions();
			for(WebElement entries: options) {
				if (entries.getText().equals(city)) {
					entries.click();
					assertion = true;
					log.info(methodName + " : " + "Country selected as "+city );
				}
			}
		}catch(Exception e) {
			log.fatal("Unable to find the country " +city + " in the dropdownlist");
			assertion = false;
		}
		
		return assertion;
	}
	

	public Boolean start_Search() {
		Boolean assertion = false;
		try {
			e_wait.until(ExpectedConditions.elementToBeClickable(search_Button));
			search_Button.click();
			log.info(methodName + " : " + "Clicked on Search button:");
			assertion = true;
		} catch (Exception e) {
			assertion = false;
			log.fatal(methodName + " : " + "Unable to Clicked on Search button:");
		}
		return assertion;
	}
	
	
	public void clearDescription() {
		e_wait.until(ExpectedConditions.elementToBeClickable(search_Keyword));
		search_Keyword.clear();
		log.info(methodName + " : " + "Description cleared ");
	}

	
	public void clearCountyRegion() {
		e_wait.until(ExpectedConditions.elementToBeClickable(search_Country));
		select = new Select(search_Country);
		search_Country.click();
		try {
			List<WebElement> options = select.getOptions();
			for(WebElement entries: options) {
				if (entries.getText().equals("Select Country/Region")) {
					entries.click();
					log.info(methodName + " : " + "Country selected as Select Country/Region" );
					search_Keyword.click();
				}
			}
		}catch(Exception e) {
			log.fatal(methodName + " : " + "Unable to clear the country from the dropdownlist");
		}
	}
	
	public void clearStateProvince() {	
		e_wait.until(ExpectedConditions.elementToBeClickable(search_State));
		select = new Select(search_State);
		search_State.click();
		try {
			List<WebElement> options = select.getOptions();
			for(WebElement entries: options) {
				if (entries.getText().equals("Select State/Province")) {
					entries.click();
					log.info(methodName + " : " + "Country selected as Select State/Province" );
				}
			}
		}catch(Exception e) {
			log.fatal(methodName + " : " + "Unable to clear the State from the dropdownlist");
		}
	}
	
	public void clearCity() {		
		e_wait.until(ExpectedConditions.elementToBeClickable(search_City));
		select = new Select(search_City);
		search_City.click();
		try {
			List<WebElement> options = select.getOptions();
			for(WebElement entries: options) {
				if (entries.getText().equals("Select City")) {
					entries.click();
					log.info(methodName + " : " + "Country selected as Select State/Province" );
				}
			}
		}catch(Exception e) {
			log.fatal(methodName + " : " + "Unable to clear the search_City from the dropdownlist");
		}
	}
}
