package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class NegativeLogInTests extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeTest(Map<String, String> testData) {
		//data
		String no = testData.get("no");
		String username= testData.get("username");
		String password= testData.get("password");
		String expectedErrorMessage= testData.get("expectedMessage");
		String description= testData.get("description");

		log.info("Log INFO : " + "Starting negativeLoginTest" + no + " for " + description);

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute negativeLogin
		loginPage.negativeLogIn(username,password);

		//wait for errorMsg
		loginPage.waitForErrorMsg();
		String errorMsg = loginPage.getErrorMsgTxt();

		// Verification
		Assert.assertTrue(errorMsg.contains(expectedErrorMessage),"Message doesn't contain actual message.");
	}
}
