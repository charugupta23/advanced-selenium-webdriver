package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePageObject{

    private By choseFileFieldLocator = By.cssSelector("#file-upload");
    private By uploadBtnLocator = By.id("file-submit");
    private By uploadedFilesLocator = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //push upload button
    public void selectFile(String fileName){
        log.info("selecting '"+ fileName +"' files from file folder");
        //selecting file
        String filePath = System.getProperty("user.dir") +
                "//src//main//resources//files//" + fileName;
        type(filePath,choseFileFieldLocator);
        log.info("File Selected");
    }

    //push upload button
    public void pushUploadButton(){
        log.info("Clicking on upload button");
        click(uploadBtnLocator);
    }

    //get names of uplaoded files
    public String getUploadedFilesNames(){
        String names = find(uploadedFilesLocator).getText();
        log.info("Uploaded files: " + names);
        return names;
    }
}
