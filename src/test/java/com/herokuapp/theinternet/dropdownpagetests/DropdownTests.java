package com.herokuapp.theinternet.dropdownpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {
    @Test
    public void selectingDropdownTests(){
        log.info("Starting selecting option2 from dropdown list.");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        log.info("aaaaaaaaaaaaaa==========================");
        sleep(3000);
        //click on dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();
        log.info("aaaaaaaaaaaaaa==========================");
        sleep(3000);
        //select option 2 from from dropdown
        dropdownPage.selectOption(2);
        log.info("aaaaaaaaaaaaaa==========================");
        sleep(3000);
        //verify option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "option 2 is not selected. Insted selected - " +
                selectedOption);
    }
}
