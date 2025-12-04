package testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;

public class ManageCategoryPageTest extends Base{
	HomePage homePage;
	ManageCategoryPage manageCategoryPage;

  @Test(retryAnalyzer = retry.Retry.class,priority=1)
  @Parameters({"username","password"})
  public void moveToManageCategoryInfo(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageCategoryPage = homePage.clickOnManageCategory();
	  String expected = "List Categories | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected, Constants.ERROR);
  }
@Test(priority=2)
@Parameters({"username","password","categoryValue"})
public void addCategoryInfo(String username, String password,String categoryValue) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageCategoryPage = homePage.clickOnManageCategory();
	  manageCategoryPage = manageCategoryPage.clickOnNew().enterCategory(categoryValue).selectGroups().selectImage().clickOnSave();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageCategoryPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
}
@Test(priority=3)
@Parameters({"username","password"})
public void updateCategoryInfo(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageCategoryPage = homePage.clickOnManageCategory();
	  manageCategoryPage.updateCategory();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageCategoryPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
}
@Test(priority=4)
@Parameters({"username","password"})
public void deleteCategoryInfo(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageCategoryPage = homePage.clickOnManageCategory();
	  manageCategoryPage.deleteCategory();
	  String expectedMessage = Constants.ALERT;
	  String actualMessage = manageCategoryPage.getAlertMessage();
	  Assert.assertEquals(actualMessage, expectedMessage, Constants.ERROR);
}
}
