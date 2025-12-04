package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {

	WebDriver driver;
	PageUtility pageUtilityObj = new PageUtility(); 
	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table/tbody/tr[1]/td[4]/a/i[@class='fas fa-edit']") WebElement actionBtn;
	@FindBy(xpath="//textarea[@name='address']") WebElement address;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='phone']") WebElement phone;
	@FindBy(xpath="//button[@type='submit']") WebElement updateBtn;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alertMessage;
	
	public ManageFooterTextPage clickOnAction() {
		actionBtn.click();
		return this;
	}
	public ManageFooterTextPage enterAddress(String addressField) {
		address.clear();
		address.sendKeys(addressField);
		return this;
	}
	public ManageFooterTextPage enterEmail(String emailId) {
		email.clear();
		email.sendKeys(emailId);
		return this;
	}
	public ManageFooterTextPage enterPhone(String phoneNumber) {
		phone.clear();
		phone.sendKeys(phoneNumber);
		return this;
	}
	public ManageFooterTextPage clickOnUpdateBtn() {
		pageUtilityObj.javaScriptExecutor(driver, updateBtn);
		return this;
	}
	public String getAlertMessage() {
        return alertMessage.getText().trim();
    }
}
