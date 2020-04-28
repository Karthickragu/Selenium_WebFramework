package com.radio.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.radio.base.Testengine;


public class TestListener extends Testengine implements ITestListener  {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Test started successfully for the method: " );
		totalTCs = totalTCs + 1;

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		passedTCs = passedTCs + 1;
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.fatal("Test step Failed: " );
		failedTCs = failedTCs + 1;
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		skippedTCs = skippedTCs + 1;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		log.info("Test completed successfully for the method: " );
		
	}

}
