package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.PageUtility;

public class ManageNewsPage {

	WebDriver driver;
	PageUtility pageUtilityObj = new PageUtility();
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(xpath="//textarea[@id='news']") WebElement news;
	@FindBy(xpath="//button[@type='submit']") WebElement saveBtn;
	@FindBy(xpath="//table/tbody/tr/td[1]") List<WebElement> allNews;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alertMessage;
	
	public ManageNewsPage clickOnNew() {
    	newBtn.click();
    	return this;
    }
	public ManageNewsPage enterNews() {
		news.sendKeys(Constants.CURRENT_NEWS);
		return this;	
	}
	public ManageNewsPage clickOnSave() {
		saveBtn.click();
		return this;	
	}
	public ManageNewsPage updateNews() {
		WebElement newsElement= pageUtilityObj.searchElement(allNews,Constants.CURRENT_NEWS);
		WebElement updateBtn = newsElement.findElement(By.xpath(".//parent::tr/td[2]/a/i"));
		updateBtn.click();
		news.clear();
		news.sendKeys(Constants.NEW_NEWS);
		saveBtn.click();
		return this;	
	}
	public String getAlertMessage() {
        return alertMessage.getText().trim();
    }
}
