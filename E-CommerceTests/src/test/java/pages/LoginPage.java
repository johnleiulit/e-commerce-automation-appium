package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


public class LoginPage {
	
	public AppiumDriver driver;
	
	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys(username);
		driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys(password);
		driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
		System.out.println("Successfully Login");
		
	}
}
