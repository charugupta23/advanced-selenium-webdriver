package com.herokuapp.theinternet.pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject{

    private String pageUrl = "https://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By alertLinkLocator = By.linkText("JavaScript Alerts");
    private By windowLinkLocator = By.linkText("Multiple Windows");
    private By WYSIWYGEditorLinkLocator = By.linkText("WYSIWYG Editor");
    private By fileUploadLinkLocator = By.linkText("File Upload");


    public WelcomePage(WebDriver driver, Logger log) {
       super(driver, log);
    }

    /** OPEN WELCOME PAGE WITH ITS URL **/
    public  void  openPage(){
        log.info("opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("page opened!");
    }

    /** OPEN LOGIN PAGE BY CLICKING ON FORM AUTHENTICATION LINK **/
    public  LoginPage clickFormAuthenticationLink(){
        log.info("clicking Form Authentication link on Welcome Page");
        driver.findElement(formAuthenticationLinkLocator).click();
        return  new LoginPage(driver,log);
    }

    /** OPEN CHECKBOX PAGE BY CLICKING ON FORM AUTHENTICATION LINK **/
    public  CheckboxesPage clickCheckboxLink(){
        log.info("clicking Checkbox link on Welcome Page");
        //driver.findElement(checkboxLinkLocator).click();
        click(checkboxLinkLocator);
        return  new CheckboxesPage(driver,log);
    }

    /** OPEN DROPDOWN PAGE BY CLICKING ON FORM AUTHENTICATION LINK **/
    public  DropdownPage clickDropdownLink(){
        log.info("clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return  new DropdownPage(driver,log);
    }

    /** OPEN Alert PAGE BY CLICKING ON FORM AUTHENTICATION LINK **/
    public JaveScriptAlertPage clickAlertLink(){
        log.info("clicking javascript alert link on Welcome Page");
        click(alertLinkLocator);
        return  new JaveScriptAlertPage(driver,log);
    }

    /** OPEN MULTIPLE WINDOW PAGE BY CLICKING ON FORM AUTHENTICATION LINK **/
    public WindowPage clickWindowLink(){
        log.info("clicking WYSIWYGEditorLink link on Welcome Page");
        click(windowLinkLocator);
        return  new WindowPage(driver,log);
    }

    /** OPEN WYSIWYG Editor page by clicking on welcome page **/
    public EditorPage WYSIWYGEditorLink(){
        log.info("clicking WYSIWYGEditorLink on Welcome Page");
        click(WYSIWYGEditorLinkLocator);
        return  new EditorPage(driver,log);
    }

    /** OPEN FILE UPLOAD PAGE BY CLICKING ON WELCOME PAGE **/
    public FileUploadPage clickFileUploadLink(){
        log.info("clicking FileUploadLink on Welcome Page");
        click(fileUploadLinkLocator);
        return  new FileUploadPage(driver,log);
    }
}
