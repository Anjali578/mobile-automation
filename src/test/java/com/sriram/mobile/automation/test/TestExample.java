package com.sriram.mobile.automation.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestExample extends BaseTest{

    @Test(testName = "Verify Title",description = "Verify Title")
    public void verifyTile(){

        System.out.println(driver.getPageSource());

        Assert.assertEquals("ABC test",homePage.getTest());
    }
}
