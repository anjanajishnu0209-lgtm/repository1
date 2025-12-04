package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	WebDriver driver;
	PageUtility pageUtilityObj = new PageUtility(); 
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//i[@class='fas fa-edit']") WebElement clickBtn;
	@FindBy(xpath="//input[@id='phone']") WebElement phone;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//textarea[@name='address']") WebElement address;
	@FindBy(xpath="//textarea[@name='del_time']") WebElement deliveryTime;
	@FindBy(xpath="//input[@id='del_limit']") WebElement deliveryChargeLimit;
	@FindBy(xpath="//button[@type='submit']") WebElement updateBtn;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alertMessage;
	
	public ManageContactPage clickOnAction() {
		clickBtn.click();
		return this;
	}
	
	public ManageContactPage enterPhoneNumber(String phoneNumber) {
		phone.clear();
		phone.sendKeys(phoneNumber);
		return this;
	}
	public ManageContactPage enterEmail(String emailId) {
		email.clear();
		email.sendKeys(emailId);
		return this;
	}
	public ManageContactPage enterAddress(String addressField) {
		address.clear();
		address.sendKeys(addressField);
		return this;
	}
	public ManageContactPage enterDeliveryTime(String deliveryTimeNeeded) {
		deliveryTime.clear();
		deliveryTime.sendKeys(deliveryTimeNeeded);
		return this;
	}
	public ManageContactPage enterDeliveryChargeLimit(String deliveryChargeLimitAppiled) {
		deliveryChargeLimit.clear();
		deliveryChargeLimit.sendKeys(deliveryChargeLimitAppiled);
		return this;
	}
	public ManageContactPage clickOnUpdateBtn() {
		pageUtilityObj.javaScriptExecutor(driver, updateBtn);
		return this;
	}
	public String getAlertMessage() {
        return alertMessage.getText().trim();
    }
}
