package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath="//a[@class='dropdown-item'][2]") WebElement logout;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][1]//child::a") WebElement adminUsers;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][9]//child::a") WebElement manageCategory;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][7]//child::a") WebElement manageNews;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][3]//child::a") WebElement manageContact;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][8]//child::a") WebElement manageFooterText;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][6]//child::a") WebElement manageProduct;
	public HomePage clickOnAdmin() {
		admin.click();
		return this;
	}
	
	public HomePage clickOnLogout() {
		logout.click();
		return this;
	}
	
	 public AdminUsersPage clickOnAdminUsers() {
	    	adminUsers.click();
			return new AdminUsersPage(driver);
	    }
	 
	 public ManageCategoryPage clickOnManageCategory() {
		 manageCategory.click();
			return new ManageCategoryPage(driver);
	    }
	 
	 public ManageNewsPage clickOnManageNews() {
		 manageNews.click();
			return new ManageNewsPage(driver);
	    }
	 
	 public ManageContactPage clickOnManageContact() {
		 manageContact.click();
			return new ManageContactPage(driver);
	    }
	 public ManageFooterTextPage clickOnManageFooterText() {
		 manageFooterText.click();
			return new ManageFooterTextPage(driver);
	    }
	 public ManageProductPage clickOnManageProduct() {
		 manageProduct.click();
		return new ManageProductPage(driver);
	 }
}
