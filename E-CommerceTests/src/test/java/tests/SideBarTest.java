package tests;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class SideBarTest extends BaseTest{
	
	@Test
	public void sideBarTest() {
	LoginPage login = new LoginPage(driver);
	MenuPage sidebar = new MenuPage(driver);
	
	login.login("standard_user", "secret_sauce");
	sidebar.sidebar();
	
	}
}
