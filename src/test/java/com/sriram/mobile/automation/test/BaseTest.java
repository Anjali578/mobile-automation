package com.sriram.mobile.automation.test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.BaseOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sriram.mobile.automation.page.HomePage;

//@Listeners({com.sriram.mobile.automation.listner.Listeners.class})
public abstract class BaseTest {
    public AppiumDriver driver;

    protected HomePage homePage;


    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"deviceTpe"})
    public void beforeSetup(@Optional("IOS") String deviceTpe) throws MalformedURLException {
        System.out.println("*****test::::"+deviceTpe);
        if(deviceTpe.equals("IOS")){
            XCUITestOptions options = new XCUITestOptions()
                 .amend("platformName", "iOS")
                .amend("appium:deviceName", "iPhone 15 Pro")
                .amend("appium:platformVersion", "17.2")
                .amend("appium:automationName", "XCUITest")
                .amend("appium:newCommandTimeout", 3000)
                .amend("appium:app", "/Users/sriramasunkara/Library/Developer/Xcode/DerivedData/AwesomeProjectTestOne-avdmtshuadkhewbzqaxdhqsygiaj/Build/Products/Debug-iphonesimulator/AwesomeProjectTestOne.app")
                .amend("appium:includeSafariInWebviews", true)
                .amend("appium:connectHardwareKeyboard", true);
            URL url=new URL("http://127.0.0.1:4723/wd/hub");
            driver=new IOSDriver(url, options);
        }else if(deviceTpe.equals("IOS16")){
            XCUITestOptions options = new XCUITestOptions()
                .amend("platformName", "iOS")
                .amend("appium:deviceName", "iPhone SE (3rd generation)")
                .amend("appium:platformVersion", "16.4")
                .amend("appium:automationName", "XCUITest")
                .amend("appium:newCommandTimeout", 3000)
                .amend("appium:app", "/Users/sriramasunkara/Library/Developer/Xcode/DerivedData/AwesomeProjectTestOne-avdmtshuadkhewbzqaxdhqsygiaj/Build/Products/Debug-iphonesimulator/AwesomeProjectTestOne.app")
                .amend("appium:includeSafariInWebviews", true)
                .amend("appium:connectHardwareKeyboard", true);
            URL url=new URL("http://127.0.0.1:4723/wd/hub");
            driver=new IOSDriver(url, options);
        }else{
            UiAutomator2Options options = new UiAutomator2Options();
            options.amend("platformName", "Android");
            options.amend("appium:deviceName", "emulator-5554");
            options.amend("appium:automationName", "UiAutomator2");
            options.amend("appium:newCommandTimeout", 3000);
            options.amend("appium:app", "/Users/sriramasunkara/Documents/AwesomeProjectTestOne/android/app/build/outputs/apk/debug/app-debug.apk");
            options.amend("appium:ensureWebviewsHavePages", true);
            options.amend("appium:nativeWebScreenshot", true);
            options.amend("appium:connectHardwareKeyboard", true);

            URL url=new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, options);

        }
        homePage=new HomePage(driver);
    }
}
