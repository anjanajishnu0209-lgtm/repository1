package testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsPageTest extends Base{
	HomePage homePage;
	ManageNewsPage manageNewsPage;

  @Test(priority=1)
  @Parameters({"username","password"})
  public void moveToManageNewsPage(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageNewsPage = homePage.clickOnManageNews();
	  String expected = "Manage News | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected, Constants.ERROR);
  }
  @Test(priority=2)
  @Parameters({"username","password"})
  public void addNewsInfo(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageNewsPage = homePage.clickOnManageNews();
	  manageNewsPage.clickOnNew().enterNews().clickOnSave();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageNewsPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
  @Test(priority=3)
  @Parameters({"username","password"})
  public void UpdateNewsInfo(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageNewsPage = homePage.clickOnManageNews();
	  manageNewsPage.updateNews();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageNewsPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
  }
}
