package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class E2ETest extends BaseTest{
	
	@Test
	public void e2eShoppingTest() throws InterruptedException {
		 LoginPage login = new LoginPage(driver);
		 ProductPage products = new ProductPage(driver);
		 CartPage cart = new CartPage(driver);
		 CheckoutPage checkout = new CheckoutPage(driver);
		 
		 //login
		 login.login("standard_user", "secret_sauce");
		 
		 //sorting product
		 products.sortingProduct();
		 // select product
		 products.selectProduct();
		 // click back
		 products.backToProducts();
		 // select product
		 products.selectProduct();
		 Thread.sleep(2000);
		 // scroll down
		 products.scrollDown(1);
		 // add to cart
		 products.addToCart();
		 // remove
		 products.removeProduct();
		 // add to cart
		 products.addToCart();
		 // open cart
		 products.openCart();
		 
		 cart.addProduct();
		 
		 //checkout
		 checkout.checkoutProduct("john lei", "ulit", 1234);
	}
}
