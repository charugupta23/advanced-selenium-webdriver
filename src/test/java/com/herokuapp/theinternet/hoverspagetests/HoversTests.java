package com.herokuapp.theinternet.hoverspagetests;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {

    @Test
    public void user2PrifileTest(){
        log.info("starting userprofile test");

        //open hovers page
        HoversPage hoversPage = new HoversPage(driver,log);
        hoversPage.openPage();

        //open user2 profile
        hoversPage.openUserProfile(2);

        //verify correct user profile open
        Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"));
    }
}

