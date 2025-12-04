package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertUtility {

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
}
