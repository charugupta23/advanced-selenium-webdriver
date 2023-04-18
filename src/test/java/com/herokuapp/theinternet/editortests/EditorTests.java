package com.herokuapp.theinternet.editortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest(){
    log.info("starting defaultEditorValueTest.");
        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //scroll to bottom
        sleep(1000);
        welcomePage.scrollToBottom();

        //clicking WYSIWYG Editor link
        EditorPage editorPage = welcomePage.WYSIWYGEditorLink();
        //get text from editor
        String editorText = editorPage.getTextFromeEditor();
        //verification that new page contains expected source in text
        Assert.assertTrue(editorText.equals("Your content goes here."),"editor text is not expected : " + editorText);

    }
}
