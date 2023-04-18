package com.herokuapp.theinternet.presskeyspagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PressKeysTests extends TestUtilities {

    @Test
    public void pressKeyTest(){
        log.info("Starting press key test.");

        //open key press page
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver,log);
        keyPressesPage.openPage();

        //push keyboard key
        keyPressesPage.pressKey(Keys.ENTER);

        // get result text
        String result = keyPressesPage.getResultText();

        //verification
        Assert.assertTrue(result.equals("You entered: ENTER"));
    }

    @Test
    public void pressKeyWithActionsTest(){
        log.info("Starting pressKeyWithActionsTest!");

        //open key press page
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver,log);
        keyPressesPage.openPage();

        //push keyboard key
        keyPressesPage.pressKey(Keys.SPACE);

        // get result text
        String result = keyPressesPage.getResultText();

        //verification
        Assert.assertTrue(result.equals("You entered: SPACE"));


    }
}
