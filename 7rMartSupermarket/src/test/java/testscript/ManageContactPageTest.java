package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactPageTest extends Base{
	HomePage homePage;
	ManageContactPage manageContactPage;
  @Test
  @Parameters({"username","password"})
  public void moveToManageContactnfo(String username, String password) throws IOException {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageContactPage = homePage.clickOnManageContact();
	  String phoneNumber = ExcelUtility.readIntegerData(1, 0, "ContactPageTestSheet").toString();
	  String emailId = ExcelUtility.readStringData(1, 1, "ContactPageTestSheet");
	  String address = ExcelUtility.readStringData(1, 2, "ContactPageTestSheet");
	  String deliveryTime = ExcelUtility.readIntegerData(1, 3, "ContactPageTestSheet").toString();
	  String deliveryChargeLimit = ExcelUtility.readIntegerData(1, 4, "ContactPageTestSheet").toString();
	  manageContactPage.clickOnAction().enterPhoneNumber(phoneNumber).enterEmail(emailId)
	  .enterAddress(address).enterDeliveryTime(deliveryTime).enterDeliveryChargeLimit(deliveryChargeLimit).clickOnUpdateBtn();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageContactPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
}
