package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base{
	HomePage homePage;
  @Test(priority=1, groups = "smoke")
  @Parameters({"username","password"})
  public void verifyValidUsernameAndPassword(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  boolean dashboardDisplyed = loginPageObj.isDashboardDisplayed();
	  Assert.assertTrue(dashboardDisplyed, Constants.ERRORMESSAGE);
  }
  
  @Test(dataProvider="credentials",priority=2, groups = "smoke")
  public void invalidUsernameAndValidPassword(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  loginPageObj.signIn();
	  String actualMessage = loginPageObj.invalidSignin();
	  String expectedMessage = Constants.ALERT;
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
  
  @Test(priority=3)
  public void invalidPasswordAndValidUsername() throws IOException {
	  LoginPage loginPageObj = new LoginPage(driver);
	  String username = ExcelUtility.readStringData(1, 0, "LoginPageTestSheet");
	  String password = ExcelUtility.readStringData(1, 1, "LoginPageTestSheet");
	  loginPageObj.enterUsernameAndPassword(username,password);
	  loginPageObj.signIn();
	  String actualMessage = loginPageObj.invalidSignin();
	  String expectedMessage = Constants.ALERT;
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
  
  @Test(priority=4)
  public void invalidUsernameAndPassqord() throws IOException {
	  LoginPage loginPageObj = new LoginPage(driver);
	  String username = ExcelUtility.readStringData(2, 0, "LoginPageTestSheet");
	  String password = ExcelUtility.readStringData(2, 1, "LoginPageTestSheet");
	  loginPageObj.enterUsernameAndPassword(username,password);
	  loginPageObj.signIn();
	  String actualMessage = loginPageObj.invalidSignin();
	  String expectedMessage = Constants.ALERT;
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
  @DataProvider(name="credentials")
  public Object[][] testData(){
	  Object data[][] = {{"testt","admin"}};
	  return data;
  }
  
}
