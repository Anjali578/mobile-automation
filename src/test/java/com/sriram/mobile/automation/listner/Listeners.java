package com.sriram.mobile.automation.listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sriram.mobile.automation.util.AppiumUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.IOException;

public class Listeners extends AppiumUtils implements ITestListener{
	ExtentTest test;
	static final ExtentReports extent = ExtentReporterNG.getReporterObject();
	AppiumDriver driver;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
				.get(result.getInstance());
			String extention=(driver instanceof IOSDriver) ?"ios_":"android_";
			// TODO Auto-generated method stub
			test= extent.createTest(extention+result.getMethod().getMethodName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getDescription()+",Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code
		test.fail(result.getThrowable());
		
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());

			System.out.println("*****driver::::"+driver);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			if(driver!=null) {
				test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
//
	
}
