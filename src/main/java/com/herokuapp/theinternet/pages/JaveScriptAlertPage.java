package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JaveScriptAlertPage extends BasePageObject{

    private By btnJSAlertLocator =
            By.cssSelector("#content > div > ul > li:nth-child(1) > button");
    private By btnJSConfirmLocator =
            By.cssSelector("#content > div > ul > li:nth-child(2) > button");
    private By btnJSPromptLocator =
            By.cssSelector("#content > div > ul > li:nth-child(3) > button");
    private By resultLocator = By.cssSelector("#result");

    public JaveScriptAlertPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJSAlert(){
        log.info("Click on 'Click for JS alert' button to open alert.");
        click(btnJSAlertLocator);
    }
    public void openJSConfirm(){
        log.info("Click on 'Click for JS confirm' button to open alert.");
        click(btnJSConfirmLocator);
    }
    public void openJSPrompt(){
        log.info("Click on 'Click for JS Prompt' button to open alert.");
        click(btnJSPromptLocator);
    }
    /*public String getAlertText(){
        Alert alert = switchToAlert();
        String alertTxt = alert.getText();
        log.info("Alert says : "+ alertTxt);
        return alertTxt;
    }
    public void acceptAlert(){
        log.info("switching to alert and press ok.");
        Alert alert = switchToAlert();
        alert.accept();
    }
    public void dismissAlert(){
        log.info("switching to alert and press cancel.");
        Alert alert = switchToAlert();
        alert.dismiss();
    }*/
    //type text into alert and press ok
   /* public  void typeTxtIntoAlert(String text){
        log.info("typing text into alert and pressing ok");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }*/
    //get result text
    public String getResultTxt(){
        WebElement resultTxt = find(resultLocator);
        String txt = resultTxt.getText();
        log.info("result text : "+ txt);
        return  txt;
    }
}
