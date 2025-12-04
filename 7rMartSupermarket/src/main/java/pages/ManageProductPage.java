package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;

public class ManageProductPage {

	WebDriver driver;
	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchBtn;
	@FindBy(xpath="//input[@name='un']") WebElement title;
	@FindBy(xpath="//input[@name='cd']") WebElement productCode;
	@FindBy(xpath="//button[@name='Search']") WebElement searchItem;
	 @FindBy(xpath="//table/tbody/tr/td") List<WebElement> product;
	
	public ManageProductPage clickOnSearchBtn() {
		searchBtn.click();
		return this;
	}
	public ManageProductPage enterTitleAndProductCode() {
		title.sendKeys(Constants.PRODUCT_TITLE);
		productCode.sendKeys(Constants.PRODUCT_CODE);
		return this;	
	}
	public ManageProductPage clickOnSearchItemBtn() {
		searchItem.click();
		return this;	
	}
	public String searchForProduct() {
		for (WebElement row : product) {
	        if (row.getText().contains(Constants.PRODUCT_TITLE)) {
	            return row.getText();
	        }
	    }
		try {
	        WebElement notFound = driver.findElement(By.xpath("//span/center[contains(text(),'RESULT NOT FOUND')]"));
	        return notFound.getText();
	    } catch (Exception e) {
	        return "Product not found and no 'RESULT NOT FOUND' message is displayed.";
	    }
	}
}
