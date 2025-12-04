package testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.FakerUtility;

public class AdminUsersPageTest extends Base{
	FakerUtility faker = new FakerUtility();
	public HomePage homePage;
	public AdminUsersPage adminUsers;
	
  @Test(priority=1)
  @Parameters({"username","password"})
  public void verifyAdminUserInfo(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  adminUsers = homePage.clickOnAdminUsers();
	  String new_username= faker.getusername();
	  String new_password= faker.getpassword();
	  adminUsers.clickOnNew().enterUserNameAndPassword(new_username, new_password).selectUserType().clickOnSave();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = adminUsers.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
  @Test(priority=2)
  @Parameters({"username","password"})
  public void searchForAUserWithUsernameAndTypeTest(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  adminUsers = homePage.clickOnAdminUsers();
	  adminUsers.searchAnyUserWithUsernameAndType();
	  boolean user = adminUsers.searchForUserDetails() != null;
	  Assert.assertTrue(user, Constants.ERROR);
  }
  @Test(priority=3)
  @Parameters({"username","password"})
  public void searchForAUserWithUsernameTest(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  adminUsers = homePage.clickOnAdminUsers();
	  adminUsers.searchAnyUserWithUsername();
	  boolean user = adminUsers.searchForUserDetails() != null;
	  Assert.assertTrue(user, Constants.ERROR);
  }
}
