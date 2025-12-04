package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextPageTest extends Base{
	HomePage homePage;
	ManageFooterTextPage manageFooterTextPage;
  @Test
  @Parameters({"username","password"})
  public void moveToManageFooterTextInfo(String username, String password) throws IOException {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageFooterTextPage = homePage.clickOnManageFooterText();
	  String address = ExcelUtility.readStringData(1, 0, "FooterPageTestSheet");
	  String emailId = ExcelUtility.readStringData(1, 1, "FooterPageTestSheet");
	  String phoneNumber = ExcelUtility.readIntegerData(1, 2, "FooterPageTestSheet").toString();
	  manageFooterTextPage.clickOnAction().enterAddress(address).enterEmail(emailId).enterPhone(phoneNumber).clickOnUpdateBtn();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageFooterTextPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
}
