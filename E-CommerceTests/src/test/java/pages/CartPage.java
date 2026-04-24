package pages;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CartPage {
	
	public AppiumDriver driver;
	
	public CartPage (AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void addProduct() {
		// click continue
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE SHOPPING\")")).click();
		// click add to cart
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\").instance(0)")).click();
		// click cart
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)")).click();
		
		// swipe product to delete
		swipeLeftToRight();
		// delete
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(27)")).click();
//		// click checkout
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"CHECKOUT\")")).click();
	}
	
	public void scrollDown(int maxScrolls) {
	    driver.findElement(
	        AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))"
	          + ".scrollToEnd(" + maxScrolls + ")"
	        )
	    );
	}
	public void swipeLeftToRight() {

	    // target table container by its content-desc (header row)
	    WebElement cartItem = driver.findElement(
	        AppiumBy.androidUIAutomator("new UiSelector().description(\"test-Item\").instance(0)")
	    );

	    // coordinates inside table container
	    int startX = cartItem.getLocation().getX() + cartItem.getSize().getWidth() - 20;  // start from RIGHT
	    int endX   = cartItem.getLocation().getX() + 1;                              // move to LEFT
	    int y      = cartItem.getLocation().getY() + (cartItem.getSize().getHeight() / 3);

	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence swipe = new Sequence(finger, 1);

	    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Collections.singletonList(swipe));
	}
}
