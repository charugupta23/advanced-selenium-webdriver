package com.herokuapp.theinternet.draganddroppagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {
    @Test
    public void DragAToBTest(){
        log.info("draging A to B test.");

        //open drag and drop page
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver,log);
        dragAndDropPage.openPage();

        sleep(3000);
        //drag box A abd drop to to box B
        dragAndDropPage.dragAtoB();

        sleep(3000);
        //verify correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"),"column A text should be B");

        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"),"column B text should be A");
    }
}
