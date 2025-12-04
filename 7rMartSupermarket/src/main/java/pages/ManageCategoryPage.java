package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.AlertUtility;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	WebDriver driver;
	PageUtility pageUtilityObj;
	FileUploadUtility fileUploadUtilityObj = new FileUploadUtility();
	AlertUtility alert = new AlertUtility();
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(xpath="//input[@id='category']") WebElement category;
	@FindBy(xpath="//li[@id='134-selectable']") WebElement groups;
	@FindBy(xpath="//input[@id='main_img']") WebElement image;
	@FindBy(xpath="//button[@type='submit']") WebElement saveBtn;
	@FindBy(xpath="//table/tbody/tr/td[1]") List<WebElement> allCategories;
	@FindBy(xpath="//input[@id='category']") WebElement updateCategoryText;
	 @FindBy(xpath="//h5[text()=' Alert!']") WebElement alertMessage;
	
	public ManageCategoryPage clickOnNew() {
    	newBtn.click();
    	return this;
    }
	public ManageCategoryPage enterCategory(String categoryVal) {
		category.sendKeys(categoryVal);
		return this;
	}
	public ManageCategoryPage selectGroups() {
		groups.click();
		return this;	
	}
	public ManageCategoryPage selectImage() {
		fileUploadUtilityObj.sendKeysForFileUpload(image, Constants.IMAGEPATH);
		return this;	
	}
	public ManageCategoryPage clickOnSave() {
		pageUtilityObj.javaScriptExecutor(driver, saveBtn);
		return this;
	}
	public ManageCategoryPage updateCategory() {
		WebElement categoryElement= pageUtilityObj.searchElement(allCategories,Constants.CATEGORY);
		WebElement updateBtn = categoryElement.findElement(By.xpath(".//parent::tr/td[4]/a/i"));
		updateBtn.click();
		updateCategoryText.clear();
		updateCategoryText.sendKeys(Constants.NEW_CATEGORY);
		pageUtilityObj.javaScriptExecutor(driver, saveBtn);
		return this;	
	}
	public ManageCategoryPage deleteCategory() {
		WebElement deleteElement= pageUtilityObj.searchElement(allCategories,Constants.NEW_CATEGORY);
		WebElement deleteBtn = deleteElement.findElement(By.xpath(".//parent::tr/td[4]/a[2]/i"));
		pageUtilityObj.javaScriptExecutor(driver, deleteBtn);
		alert.acceptAlert(driver);
		return this;
		
	}
	public String getAlertMessage() {
        return alertMessage.getText().trim();
    }
}
