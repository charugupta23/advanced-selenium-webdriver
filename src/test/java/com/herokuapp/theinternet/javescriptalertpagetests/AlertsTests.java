package com.herokuapp.theinternet.javescriptalertpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {

    @Test
    public void javescriptAlertTests(){
      /*  log.info("Starting javascript alerts..");
        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //click on javascriptalert link
        JaveScriptAlertPage alertPage = welcomePage.clickAlertLink();
        alertPage.openJSAlert();

        //get jsalert text
        String alertMessage = alertPage.getAlertText() + "[FAIL]";

        //click ok button
        alertPage.acceptAlert();

        //get result text
        String resultText = alertPage.getResultTxt()+"[FAIL]";

        //Verification -1
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"), "Message is not matched.");

        //Verification -2
        softAssert.assertTrue(resultText.equals("You successfully clicked an alert"),
                "Msg is not expected.");
        softAssert.assertAll();
    }

   @Test
    public void jsConfirmAlertTests(){
        log.info("Starting javascript confirm alerts..");
        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //click on javascriptalert link
        JaveScriptAlertPage alertPage = welcomePage.clickAlertLink();
        alertPage.openJSConfirm();

        //get jsalert text
        String alertMessage = alertPage.getAlertText();

        //click ok button
        alertPage.dismissAlert();

        //get result text
        String resultText = alertPage.getResultTxt();

        //Verification -1
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"), "Message is not matched.");

        //Verification -2
        softAssert.assertTrue(resultText.equals("You clicked: Cancel"),
                "Msg is not expected.");
        softAssert.assertAll();
    }

    @Test
    public void jsPromptAlertTests(){
        log.info("Starting javascript Prompt alerts");
        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //click on javascriptalert link
        JaveScriptAlertPage alertPage = welcomePage.clickAlertLink();
        alertPage.openJSPrompt();
        sleep(5000);
        String txt = "charu";
        alertPage.typeTxtIntoAlert(txt);
        //get jspromtalert text
        //String alertMessage = alertPage.getAlertText();

        //click ok button
        //alertPage.acceptAlert();

        //get result text
        sleep(3000);
        String resultText = alertPage.getResultTxt();

        //Verification -1
        *//*sleep(3000);
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"), "Message is not matched.");
*//*
        //Verification -2
        softAssert.assertEquals(resultText ,"You entered: " +txt);
        softAssert.assertAll();
  */  }
}
