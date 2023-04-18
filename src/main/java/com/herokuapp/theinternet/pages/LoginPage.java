package com.herokuapp.theinternet.pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By logInButtonLocator = By.xpath("//*[@id=\"login\"]/button");
    private By errorMsgLoginLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver,log);
    }

    /** execute login **/
    public  SecureAreaPage logIn(String username, String password){
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPage(driver,log);
    }

    /** execute negativelogin **/
    public  void negativeLogIn(String username, String password){
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(logInButtonLocator);
    }

    //wait for error message visible on the page
    public void  waitForErrorMsg(){
        waitForVisibilityOf(errorMsgLoginLocator,5);
    }

    public String getErrorMsgTxt(){
        return find(errorMsgLoginLocator).getText();
    }
}
