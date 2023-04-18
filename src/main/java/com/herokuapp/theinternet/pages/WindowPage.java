package com.herokuapp.theinternet.pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePageObject{

    private By clickhereLink = By.cssSelector("#content > div > a");
    public WindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    //Click "click here" link to open new window
    public void openNewWindow(){
        log.info("clicking click here link");
        click(clickhereLink);
    }
    //find page with title "New Window" and switch to it
    public NewWindowPage switchToNewWindowPage(){
        log.info("looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver,log);
    }
}
