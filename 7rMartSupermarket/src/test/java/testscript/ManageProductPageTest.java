package testscript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;

public class ManageProductPageTest extends Base{
	HomePage homePage;
	ManageProductPage manageProductPage;

  @Test
  @Parameters({"username","password"})
  public void moveToManageProductPage(String username, String password) {
	  LoginPage loginPageObj = new LoginPage(driver);
	  loginPageObj.enterUsernameAndPassword(username, password);
	  homePage = loginPageObj.signIn();
	  manageProductPage = homePage.clickOnManageProduct();
	  manageProductPage.clickOnSearchBtn().enterTitleAndProductCode().clickOnSearchItemBtn();
	  boolean product = manageProductPage.searchForProduct() != null;
	  Assert.assertTrue(product, Constants.ERROR);
  }
}
