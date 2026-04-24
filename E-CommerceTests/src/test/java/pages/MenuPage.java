package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class MenuPage {
	
	public AppiumDriver driver;
	
	public MenuPage (AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void sidebar () {
		openMenu();
//		webView();
//		
//		openMenu();
//		qrCode();
//		
//		openMenu();
//		geoLocation();
//		
//		openMenu();
//		drawing();
//		
//		openMenu();
//		allItems();
	}
	
	public void openMenu () {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)")).click();
	}
	
	public void webView () {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WEBVIEW\")")).click();
	}
	public void qrCode () {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"QR CODE SCANNER\")")).click();
	}
	public void geoLocation () {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"GEO LOCATION\")")).click();
	}
	public void drawing () {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"DRAWING\")")).click();
	}
	public void allItems () {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ALL ITEMS\")")).click();
	}
	
	
}
