package com.sriram.mobile.automation.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class AppiumUtils {

	public void waitForElementToAppear(WebElement ele, AppiumDriver driver)
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele),"text" , "Cart"));
	}
	
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String extention=driver instanceof  IOSDriver?"ios_":"android_";
		String destinationFile = "./build/reports/"+extention+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return extention+testCaseName+".png";
		//1. capture and place in folder //2. extent report pick file and attach to report
		
	}
	
	
}
