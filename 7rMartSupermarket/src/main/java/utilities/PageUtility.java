package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectByVisibleText(WebElement element,String text) {
		Select textValue = new Select(element);
		textValue.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement element,Integer index) {
		Select textValue = new Select(element);
		textValue.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value) {
		Select textValue = new Select(element);
		textValue.selectByValue(value);
	}
	
	public void selectFirstSelected(WebElement element) {
		Select textValue = new Select(element);
		textValue.getFirstSelectedOption();
	}
	
	public void selectAllSelected(WebElement element) {
		Select textValue = new Select(element);
		textValue.getAllSelectedOptions();
	}
	
	public void javaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public WebElement searchElement(List<WebElement> elements, String value) {
		for(WebElement element: elements) {
			if(element.getText().equals(value)) {
				return element;
			}
		}
		return null;
	}
}
