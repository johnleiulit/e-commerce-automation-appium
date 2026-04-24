package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CheckoutPage {
	
	public AppiumDriver driver;
	
	public CheckoutPage (AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void checkoutProduct(String firstname, String lastname, int zipcode) throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("test-First Name")).sendKeys(firstname);
		driver.findElement(AppiumBy.accessibilityId("test-Last Name")).sendKeys(lastname);
		driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code")).sendKeys(String.valueOf(zipcode));
		
		// click continue
		driver.findElement(AppiumBy.accessibilityId("test-CONTINUE")).click();
		Thread.sleep(2000);
		// scrolldown
		scrollDown(1);
		
		// click finish
		driver.findElement(AppiumBy.accessibilityId("test-FINISH")).click();
		
		// back home
		driver.findElement(AppiumBy.accessibilityId("test-BACK HOME")).click();
		System.out.println("Back to home");

	}
	
	public void scrollDown(int maxScrolls) {
	    driver.findElement(
	        AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))"
	          + ".scrollToEnd(" + maxScrolls + ")"
	        )
	    );
	}
}
