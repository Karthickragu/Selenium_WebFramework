package com.radio.report;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporters {
	
	protected static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public void reportLocation(String device_Name, String folder_TStamp, String timeStamp) {

		String fileName = device_Name+"_"+timeStamp;
		
		File file = new File(System.getProperty("user.dir") + "/test-output/Reports/"+folder_TStamp);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
		
		
		//htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Reports/" +folder_TStamp+ "/" + fileName + ".html");
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Reports/"+ folder_TStamp+ "/" + fileName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		
		htmlreport.config().setDocumentTitle(device_Name);
		htmlreport.config().setReportName("REPORT For " +device_Name + " Device");
		
	}
}
