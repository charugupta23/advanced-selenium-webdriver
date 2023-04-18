package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject{
    private  String pageUrl = "https://the-internet.herokuapp.com/key_presses";
    private By body = By.xpath("//body");
    private By resultTextLocator = By.id("result");

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //open key press page with its url
    public  void openPage(){
        log.info("opening page: "+ pageUrl);
        openUrl(pageUrl);
        log.info("page opend!");
    }

    //press given key while on this page
    public void pressKey(Keys key){
        log.info("Pressing "+ key.name());
        pressKey(body,key);
    }

    //get result text
    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("result text : " + result);
        return result;
    }
}
