package com.radio.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends Testengine {
	
	public static WebDriver createInstance(String preferredBrowser, String platformVersion) {
		WebDriver driver = null;
		
		try {
			log.info("Initiating Browser Driver");
			if (preferredBrowser.equalsIgnoreCase("Chrome")) {
				log.info("Initiating Chrome Browser Driver");
				try {
					WebDriverManager.chromedriver().setup();
					if (platformVersion != "") {
						WebDriverManager.chromedriver().version(platformVersion).setup();
					}
					driver = new ChromeDriver();
				} catch (Exception e) {
					log.fatal("Unable to initialize the driver");
				}
			}

			if (preferredBrowser.equalsIgnoreCase("Firefox") || preferredBrowser.equalsIgnoreCase("Fire fox")) {
				log.info("Initiating Firefox Browser Driver");
				try {
					WebDriverManager.firefoxdriver().setup();
					if (platformVersion != "") {
						WebDriverManager.firefoxdriver().version(platformVersion).setup();
					}
					driver = new FirefoxDriver();

				} catch (Exception e) {
					log.fatal("Unable to initialize the driver");
				}
			}

			if (preferredBrowser.equalsIgnoreCase("edge")) {
				log.info("Initiating Edge Browser Driver");
				try {
					WebDriverManager.edgedriver().setup();
					if (platformVersion != "") {
						WebDriverManager.edgedriver().version(platformVersion).setup();
					}
					driver = new EdgeDriver();
				} catch (Exception e) {
					log.fatal("Unable to initialize the driver");
				}
			}

			if (preferredBrowser.equalsIgnoreCase("ie") || preferredBrowser.equalsIgnoreCase("Internet Explorer")) {
				log.info("Initiating Internet Explorer Browser Driver");
				try {
					WebDriverManager.iedriver().setup();
					if (platformVersion != " ") {
						WebDriverManager.iedriver().version(platformVersion).setup();
					}
					driver = new InternetExplorerDriver();
				} catch (Exception e) {
					log.fatal("Unable to initialize the driver");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			return driver;
		}
		return driver;
	}

}
