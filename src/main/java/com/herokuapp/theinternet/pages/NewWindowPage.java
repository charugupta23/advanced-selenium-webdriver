package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePageObject{
    WindowPage windowPage = new WindowPage(driver,log);

    public NewWindowPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
}
