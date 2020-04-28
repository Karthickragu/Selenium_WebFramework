package com.radio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.radio.base.Testengine;

public class SearchResult extends Testengine {

	WebDriver driver;
	//protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Select select;

	public SearchResult(WebDriver driver) {
		PageFactory.initElements(driver, this);
		e_wait = new WebDriverWait(driver, 30);
	}

	@FindBy(xpath = "//h2[contains(text(),'Matching Jobs Found')]")
	WebElement search_result_summary;

	@FindBy(xpath = "//body[@id='search']/div[@id='page']/main[@id='content']/div[@class='center-content']/section[@id='search-results']/section[@id='search-results-list']/ul/li")
	public static List<WebElement> search_result_Grid;

	@FindBy(xpath = "//a[@class='next']")
	WebElement next_Button;

	@FindBy(xpath = "//a[@class='pagination-show-all']")
	WebElement showAll_Button;

	@FindBy(id = "search-filter-clear")
	WebElement clearAllFilters_Button;

	public Boolean verifySearchGrid(String desc, String location, String dateposted) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.visibilityOf(search_result_summary));
		int pagination_Size = Integer.parseInt(driver.findElement(By.xpath("//span[@class='pagination-total-pages']")).getText().replaceAll("of ", ""));
		System.out.println(pagination_Size);
		
		for(int j=1; j<=pagination_Size; j++) {
			try {
				System.out.println(search_result_Grid.size());
				for(int i=1; i<=search_result_Grid.size(); i++) {
					WebElement e_job_Description = driver.findElement(By.xpath("//body[@id='search']/div[@id='page']/main[@id='content']/div[@class='center-content']/section[@id='search-results']/section[@id='search-results-list']/ul/li["+i+"]/a[1]/h3[1]"));
					WebElement e_job_Location =    driver.findElement(By.xpath("//body[@id='search']/div[@id='page']/main[@id='content']/div[@class='center-content']/section[@id='search-results']/section[@id='search-results-list']/ul/li["+i+"]/a[1]/span[1]"));
					WebElement e_job_PostedOn =    driver.findElement(By.xpath("//body[@id='search']/div[@id='page']/main[@id='content']/div[@class='center-content']/section[@id='search-results']/section[@id='search-results-list']/ul/li["+i+"]/a[1]/span[2]"));
					
					String job_Description = e_job_Description.getText();
					String job_Location =    e_job_Location.getText();
					String job_PostedOn =    e_job_PostedOn.getText();
					
					
					System.out.println("**********************************************************************************************");
					System.out.println(job_Description);
					System.out.println(job_Location);
					System.out.println(job_PostedOn);
					System.out.println("**********************************************************************************************");
				
					if(job_Description.equals(desc) && job_Location.equals(location) && job_PostedOn.equals(dateposted)) {
						log.info("Match found Successfully for the combination : " +job_Description +"\t"+ job_Location +"\t"+ job_PostedOn);
						selectJob_Grid(e_job_Description, e_job_Location, e_job_PostedOn);
						assertion = true;
						break;
					}
				}
				if(next_Button.isEnabled()) {
					next_Button.click();
				}
		     } catch(Exception e) {
		    	 log.error("Unable to find the given Job Details in the search Page");
		    	 assertion = false;
		     }
		}
		
		return assertion;
	}

	public void selectJob_Grid(WebElement desc, WebElement location, WebElement dateposted) {
		Boolean assertion = false;
		e_wait.until(ExpectedConditions.visibilityOf(search_result_summary));
		try {
			desc.click();
			assertion = true;
			log.info("Clicked on the combination : " + desc.getText() + "\t" + location.getText() + "\t"
					+ dateposted.getText());
		} catch (Exception e) {
			assertion = false;
		}

	}

}
