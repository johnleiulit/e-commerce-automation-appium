# E-Commerce Mobile App Test Automation Framework

E-Commerce Mobile App Test Automation Framework built with Java, Appium, and TestNG for automated testing of the Sauce Labs Mobile Demo App on Android devices.

## Project Overview

This framework implements the Page Object Model (POM) design pattern to test an e-commerce mobile application. It provides automated test coverage for core user flows including login, product browsing, cart management, and checkout processes.

## Technology Stack

- **Java** - Programming language
- **Appium** (v10.0.0) - Mobile automation framework
- **Selenium** (v4.39.0) - WebDriver for browser automation
- **TestNG** (v7.11.0) - Testing framework
- **Maven** - Build and dependency management

## Project Structure

```
E-CommerceTests/
├── src/
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java          # Base configuration for all tests
│           ├── pages/                      # Page Object Model classes
│           │   ├── LoginPage.java
│           │   ├── ProductPage.java
│           │   ├── CartPage.java
│           │   ├── CheckoutPage.java
│           │   └── MenuPage.java
│           └── tests/                      # Test classes
│               ├── E2ETest.java           # End-to-end shopping flow
│               ├── LaunchAppTest.java     # App launch verification
│               └── SideBarTest.java       # Sidebar navigation tests
├── pom.xml                                 # Maven configuration
└── README.md
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6+
- Node.js and npm
- Appium Server 2.x
- Android SDK
- Android device or emulator
- ADB (Android Debug Bridge)

## Setup Instructions

### 1. Install Appium

```bash
npm install -g appium
appium driver install uiautomator2
```

### 2. Configure Device

Update the device configuration in `BaseTest.java`:

```java
caps.setCapability("appium:deviceName", "YOUR_DEVICE_NAME");
caps.setCapability("appium:udid", "YOUR_DEVICE_UDID");
caps.setCapability("appium:platformVersion", "YOUR_ANDROID_VERSION");
```

To get your device UDID:
```bash
adb devices
```

### 3. Install Dependencies

```bash
cd E-CommerceTests
mvn clean install
```

### 4. Start Appium Server

```bash
appium
```

The server will start on `http://127.0.0.1:4723`

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=E2ETest
mvn test -Dtest=LaunchAppTest
mvn test -Dtest=SideBarTest
```

## Test Coverage

### E2ETest
Complete end-to-end shopping flow covering:
- User login with credentials
- Product sorting (by price and name)
- Product selection and navigation
- Add/remove items from cart
- Cart management with swipe gestures
- Checkout process with user information
- Order completion

### LaunchAppTest
- Verifies successful app launch
- Basic smoke test

### SideBarTest
- Tests sidebar menu navigation
- Validates menu accessibility

## Page Objects

### LoginPage
- `login(username, password)` - Authenticates user

### ProductPage
- `sortingProduct()` - Tests all sorting options
- `selectProduct()` - Selects a product
- `addToCart()` - Adds product to cart
- `removeProduct()` - Removes product from cart
- `scrollDown(maxScrolls)` - Scrolls down the product list
- `scrollUp()` - Scrolls up to top

### CartPage
- `addProduct()` - Manages cart operations
- `swipeLeftToRight()` - Swipe gesture to delete items

### CheckoutPage
- `checkoutProduct(firstname, lastname, zipcode)` - Completes checkout

### MenuPage
- `sidebar()` - Navigates sidebar menu
- `openMenu()` - Opens the menu drawer

## Configuration

### Device Configuration Options

The framework supports both physical devices and emulators:

**Physical Device (WiFi):**
```java
caps.setCapability("appium:udid", "192.168.18.101:5555");
```

**Physical Device (USB):**
```java
caps.setCapability("appium:udid", "8LKN45IBCABAOBZ9");
```

### App Configuration
```java
caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
caps.setCapability("appium:noReset", true);
```

## Test Credentials

Default test user:
- **Username:** `standard_user`
- **Password:** `secret_sauce`

## Features

- **Page Object Model (POM)** - Maintainable and reusable code structure
- **Implicit Waits** - 5-second timeout for element interactions
- **Gesture Support** - Swipe actions for cart item deletion
- **Scroll Automation** - UiScrollable for product list navigation
- **Multiple Locator Strategies** - AccessibilityId, AndroidUIAutomator, XPath
- **Session Persistence** - `noReset: true` maintains app state

## Troubleshooting

### Common Issues

**Appium server not starting:**
```bash
# Check if port 4723 is in use
netstat -ano | findstr :4723
# Kill the process if needed
taskkill /PID <process_id> /F
```

**Device not detected:**
```bash
adb devices
adb kill-server
adb start-server
```

**Element not found:**
- Increase implicit wait duration in `BaseTest.java`
- Verify element locators using Appium Inspector

## Best Practices

- Keep page objects focused on single pages
- Use meaningful method and variable names
- Add explicit waits for dynamic elements
- Implement proper exception handling
- Use TestNG annotations for test lifecycle management
- Maintain separate test data from test logic

## Future Enhancements

- [ ] Add TestNG XML suite configuration
- [ ] Implement parallel test execution
- [ ] Add screenshot capture on test failure
- [ ] Integrate with CI/CD pipeline
- [ ] Add extent reports for better test reporting
- [ ] Implement data-driven testing with external data sources
- [ ] Add iOS support

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is for educational and testing purposes.

## Contact

**Author:** John Lei Ulit

---

**Note:** This framework is designed for the Sauce Labs Mobile Demo App. Ensure you have the app installed on your test device before running tests.
