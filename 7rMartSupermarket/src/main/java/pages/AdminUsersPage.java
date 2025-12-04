package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageUtilityObj = new PageUtility();
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//select[@id='user_type']") WebElement userType;
    @FindBy(xpath="//button[@name='Create']") WebElement saveBtn;
    @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchBtn;
    @FindBy(xpath="//input[@id='un']") WebElement searchUsername;
    @FindBy(xpath="//select[@id='ut']") WebElement searchUserType;
    @FindBy(xpath="//button[@name='Search']") WebElement searchClick;
    @FindBy(xpath="//h5[text()=' Alert!']") WebElement alertMessage;
    @FindBy(xpath="//table/tbody/tr/td") List<WebElement> userDetails;
   
    public AdminUsersPage clickOnNew() {
    	newBtn.click();
		return this;
    }
    public AdminUsersPage enterUserNameAndPassword(String usernameField, String passwordField) {
    	username.sendKeys(usernameField);
    	password.sendKeys(passwordField);
    	return this;
    }
    public AdminUsersPage selectUserType() {
    	pageUtilityObj.selectByVisibleText(userType, Constants.USERTYPE);
    	return this;
    }
    public AdminUsersPage clickOnSave() {
    	saveBtn.click();
    	return this;
    }
    public AdminUsersPage searchAnyUserWithUsernameAndType() {
    	searchBtn.click();
    	searchUsername.sendKeys(Constants.USERNAME);
    	pageUtilityObj.selectByVisibleText(searchUserType, Constants.USERTYPE);
    	searchClick.click();
		return null;	
    }
    public AdminUsersPage searchAnyUserWithUsername() {
    	searchBtn.click();
    	searchUsername.sendKeys(Constants.USERNAME);
    	searchClick.click();
		return null;	
    }
    public String getAlertMessage() {
        return alertMessage.getText().trim();
    }
    public String searchForUserDetails() {
		for (WebElement row : userDetails) {
	        if (row.getText().contains(Constants.USERNAME)) {
	            return row.getText();
	        }
	    }
		try {
	        WebElement notFound = driver.findElement(By.xpath("//span/center[contains(text(),'RESULT NOT FOUND')]"));
	        return notFound.getText();
	    } catch (Exception e) {
	        return "User not found and no 'RESULT NOT FOUND' message is displayed.";
	    }
	}
}
