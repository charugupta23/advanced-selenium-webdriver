package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, org.apache.logging.log4j.Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //get url of current page from browser
    public String getcurrenturl(){
        return driver.getCurrentUrl();
    }

    protected void openUrl(String url){
        driver.get(url);
    }

    //find elements using given locator
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    //find all elements using given locator
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    /** click on element with given locator when its visible **/
    protected void click(By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    /**Type given text into element with given locator **/
    protected void type(String text, By locator){
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    protected void waitForVisibilityOf(By locator, int timeOutInSeconds) {
        int attemps = 0;
        while (attemps < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds > 0 ? timeOutInSeconds : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attemps++;
        }
    }

    protected void waitFor(ExpectedCondition<WebElement> condition,
                           Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }

    //wait for alert to present and switch to it
  /*  protected Alert switchToAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();

    }*/
    public void switchToWindowWithTitle(String expectedTitle){
        //swithching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()){
            String windowHandle = windowsIterator.next().toString();
            if(!windowHandle.equals(firstWindow)){
                driver.switchTo().window(windowHandle);
                if(getCurrentPageTitle().equals(expectedTitle)){
                    break;
                }
            }
        }
    }

    //get url of current page from browser
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    //get title of current page
    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    //get source of current page
    public String getCurrentPageSource(){
        return  driver.getPageSource();
    }

    //swith to iFrame using its locator
    protected void switchToFrame(By frameLocator){
        driver.switchTo().frame(find(frameLocator));
    }

    //Press key on locator
    protected  void pressKey(By locator, Keys key){
        find(locator).sendKeys(key);
    }

    //press key using action class
    public void pressKeyWithActions(Keys key){
        log.info("pressing "+ key.name() + " using action class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    //perform scroll to bottom
    public  void scrollToBottom(){
        log.info("scrolling to the bottom of the page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollheight)");

    }

    //perform drag and drop
    //drag 'from' element to 'to' element
    public  void performDragAndDrop(By from, By to) {
        //Actions action = new Actions(driver);
        //action.dragAndDrop(find(from), find(to)).build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                find(from), find(to));

    }

    //perform mouse hover over element
    protected void hoverOverElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
