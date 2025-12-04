package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//h5[contains(text(),'Alert!')]") WebElement alertMessage;
	
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();	
	}
	
	public LoginPage enterUsernameAndPassword(String usernameField, String passwordField) {
		username.sendKeys(usernameField);
		password.sendKeys(passwordField);
		return this;
	}
	
	public HomePage signIn() {
		waitUtility.waitForElementToBeClicked(driver, signin);
		signin.click();
		return new HomePage(driver);
	}
	public String invalidSignin() {
		waitUtility.waitForElementToBeVisible(driver, alertMessage);
		return alertMessage.getText().trim();
	}
}
