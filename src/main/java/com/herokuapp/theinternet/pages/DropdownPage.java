package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject{

    private By dropdown = By.cssSelector("#dropdown");

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //this method selects option from dropdown page
    public void selectOption(int i){
        log.info("selection option " + i + " from drodown.");
        WebElement dropdownElement = find(dropdown);
        Select selectDropdown = new Select(dropdownElement);

        selectDropdown.selectByValue("" + i);
    }

    //this method returns selected option in dropdown as a string
    public String getSelectedOption(){
        WebElement dropdownElement = find(dropdown);
        Select drp = new Select(dropdownElement);
        String getTxt = drp.getFirstSelectedOption().getText();
        return getTxt;
    }
}
