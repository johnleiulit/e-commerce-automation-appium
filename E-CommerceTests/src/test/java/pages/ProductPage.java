package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ProductPage {
	
	public AppiumDriver driver;
	
	public ProductPage (AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void sortingProduct() {
		// click button to sort the products
		WebElement sortingBtn = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)"));
		sortingBtn.click();
																		
//		driver.findElement(AppiumBy.accessibilityId("test-Modal Selector Button")).click();

		// click high to low
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Price (high to low)\")")).click();
		System.out.println("Sort items by Price(High to Low)");
		scrollDown(2);
		
		// click button to sort the products
		sortingBtn.click();
		// click to low to high
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Price (low to high)\")")).click();
		System.out.println("Sort items by Price(Low to High)");
		scrollUp();
		
		sortingBtn.click();
		// click to name Z to A
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Name (Z to A)\")")).click();
		System.out.println("Sort items by Name(Z to A)");
		scrollDown(2);
		
		sortingBtn.click();
		// click to name A to Z
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Name (A to Z)\")")).click();
		System.out.println("Sort items by Name(A to Z)");
		scrollUp();
		
		sortingBtn.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Cancel\")")).click();
		System.out.println("Clicked cancel button");
	}
	
	public void selectProduct() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)")).click();
		System.out.println("Select Product");
	}
	public void backToProducts() {						
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK TO PRODUCTS\"]/android.widget.ImageView")).click();
		System.out.println("Back to product list");
	}
	public void addToCart() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"test-ADD TO CART\")")).click();
		System.out.println("Clicked add to cart");
	}
	public void removeProduct() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"REMOVE\")")).click();
		System.out.println("Clicked remove");
	}
	public void openCart() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(13)")).click();
		System.out.println("Open cart");
	}
	
	public void scrollDown(int maxScrolls) {
	    driver.findElement(
	        AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))"
	          + ".scrollToEnd(" + maxScrolls + ")"
	        )
	    );
	}
	public void scrollUp() {
	    driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToBeginning(5)"
	    ));
	}
}
