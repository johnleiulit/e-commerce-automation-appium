package base;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        
          caps.setCapability("appium:deviceName", "Poco M7 Pro 5G");
          caps.setCapability("appium:udid", "192.168.18.101:5555");
//          caps.setCapability("appium:udid", "8LKN45IBCABAOBZ9");
          caps.setCapability("platformName", "Android");
          caps.setCapability("appium:platformVersion", "14");
          caps.setCapability("appium:automationName", "UiAutomator2");
          caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
          caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
          caps.setCapability("appium:noReset", true);
          
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("deviceName", "Android Emulator");
//        caps.setCapability("automationName", "UiAutomator2");
//        caps.setCapability("appPackage", "com.swaglabsmobileapp");
//        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
//        caps.setCapability("noReset", true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), caps);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
