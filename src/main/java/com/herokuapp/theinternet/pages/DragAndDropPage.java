package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject{
    private  String pageUrl = "https://the-internet.herokuapp.com/drag_and_drop";
    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //open drag and drop page with its url
    public void openPage(){
        log.info("opening page: "+ pageUrl);
        openUrl(pageUrl);
        log.info("page opened!");
    }

    //drag A box and drop it on B box
    public void dragAtoB(){
        log.info("Drag A box on B box");
        performDragAndDrop(columnA,columnB);
    }

    //getting text from column A
    public String getColumnAText(){
        String text = find(columnA).getText();
        log.info("column A text: "+text);
        return text;
    }

    //getting text from column B
    public String getColumnBText(){
        String text = find(columnB).getText();
        log.info("column B text: "+text);
        return text;
    }
}
