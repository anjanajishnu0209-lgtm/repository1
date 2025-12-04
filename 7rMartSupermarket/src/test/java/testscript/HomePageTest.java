package testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base{
	HomePage homePage;
  @Test(description = "verify logout")
  @Parameters({"username","password"})
  public void verifyLogout(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  homePage.clickOnAdmin().clickOnLogout();
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected, Constants.LOGOUTFAILED);
  }
}
