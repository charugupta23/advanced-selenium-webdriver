package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

    private String pageUrl = "https://the-internet.herokuapp.com/secure";
    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    private By message = By.id("flash");
    private By logInButton =By.xpath("//*[@id=\"login\"]/button");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //get url variable from page object
    public String getPageUrl(){
        return pageUrl;
    }

    //verification if logout button is visible on the page
    public boolean isLogOutButtonVisible(){
        return find(logOutButton).isDisplayed();
    }

    public String getSuccessMsgText(){
        return find(message).getText();
    }
}
