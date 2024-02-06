package com.sriram.mobile.automation.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class HomePage {

    private AppiumDriver appiumDriver;
    public HomePage(AppiumDriver appiumDriver){
        this.appiumDriver=appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this );
    }


    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"title\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"title\"`]")
    private WebElement element;

    public String getTest(){
       return element.getText();
    }
}
