package com.herokuapp.theinternet.windowpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void WindowsTests(){
        log.info("starting new window test");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //clicking on multiple window page on welcome page
        WindowPage windowPage = welcomePage.clickWindowLink();

        //clicking on click here link on multiple window link
        windowPage.openNewWindow();
        sleep(3000);
        //find and switch to new window
        NewWindowPage newWindowPage = windowPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();

        log.info("================");
        //verification that new pagecontains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"),"=======");
        log.info("================");
    }
}
