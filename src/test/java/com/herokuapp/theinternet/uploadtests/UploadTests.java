package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileploadTest(int no, String fileName){
        log.info("starting file upload test #" + no + "name :" +fileName);

        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        welcomePage.clickFileUploadLink();

        //open file uploader page
        FileUploadPage fileUploadPage = new FileUploadPage(driver,log);

        //select file
        fileUploadPage.selectFile(fileName);

        //push upload button
        fileUploadPage.pushUploadButton();

        //get uploaded file
        String fileNames = fileUploadPage.getUploadedFilesNames();

        //verification
        Assert.assertTrue(fileNames.contains(fileName));
    }
}
