package com.herokuapp.theinternet.horizontalslidertests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {

    @Test
    public void sliderTest(){
        log.info("starting slider test");

        //open horizontal slider page
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver,log);
        horizontalSliderPage.openPage();

        String value = "3.5";

        //set slider value
        sleep(2000);
        horizontalSliderPage.setSliderTo(value);
        sleep(5000);

        //verify slider value
        String sliderValue = horizontalSliderPage.getSliderValue();
        Assert.assertTrue(sliderValue.equals(value),"range is not correct.");
    }
}
