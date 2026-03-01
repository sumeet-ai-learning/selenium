# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a **Playwright-based end-to-end test automation framework** for the Demo Web Shop e-commerce application. It uses the **Page Object Model** pattern with **TestNG** as the test runner and **Maven** as the build system.

- **Language**: Java 25
- **Browser Automation**: Playwright (Chromium, Firefox)
- **Test Framework**: TestNG
- **Build Tool**: Maven 3.9.11
- **Data Testing**: Apache POI (Excel), CSV utilities, Properties files
- **Logging**: Log4j2

## Common Commands

### Build and Compile
```bash
mvn clean compile                    # Compile the project
mvn clean install                    # Clean build with dependency resolution
```

### Running Tests
```bash
mvn test                             # Run all tests
mvn test -Dtest=TestBuyAProduct      # Run a single test class
mvn test -Dtest=TestBuyAProduct#testOrderAPrdoduct  # Run a specific test method
mvn test -Dsuite=testng.xml         # Run tests from specific TestNG XML suite
```

### Other Useful Commands
```bash
mvn clean                            # Clean target directory
mvn compile -DskipTests             # Compile without running tests
```

## Code Architecture

### Directory Structure

```
src/main/java/com/triscent/
├── pages/              # Page Object Model classes (one per page/component)
├── support/            # Data models, enums, and helper classes
├── utilities/          # Infrastructure: driver setup, logging, data parsing
└── exceptions/         # Custom exception classes

src/main/resources/
├── log4j2.xml         # Logging configuration
├── UserDetails.properties  # Test user credentials and config
├── userdetails.xlsx   # Excel-based test data
└── userdetails.csv    # CSV-based test data

src/test/java/
├── BaseTest.java      # Base class with lifecycle hooks
└── Test*.java         # Individual test classes
```

### Key Components

#### **Page Objects** (`pages/`)
- Implement Page Object Model pattern with Playwright API
- Static `Page` instance passed via constructor
- Methods use fluent API style (e.g., `withUsername().andPassword().login()`)
- Use static methods for actions and verifications
- Selectors as Playwright CSS/XPath locators
- Example pages: `LoginPage`, `ProductHome`, `CartPage`, `CheckoutPage`, `CreditCardPayment`, `OrderConfirmPage`

#### **Support Classes** (`support/`)
- **Data Models**: `Address`, `Product`, `Gender` (with builder patterns)
- **Enums**: `ProductType`, `Categories`, `SortBy`, `ShippingMethod`, `PaymentMethod`
- **Helper**: `ProductSelectorHelperMenu` for menu interactions

#### **Utilities** (`utilities/`)
- **DriverSetup**: Static methods to initialize and manage Playwright browser/context/page lifecycle. Methods: `openChrome()`, `openFirefox()`, `closeBrowser()`, `quitBrowser()`, `getPage()`, `getContext()`
- **BrowserHelper**: Browser interaction utilities
- **LogUtility**: Log4j2 integration with static `log` object
- **ExcelUtils** / **CSVUtils**: Parse test data from Excel/CSV files
- **PropertiesSetUp**: Load configuration from `UserDetails.properties`

#### **BaseTest** (`src/test/java/`)
- Uses TestNG lifecycle annotations: `@BeforeSuite`, `@AfterSuite`, `@BeforeMethod`, `@AfterMethod`
- Initializes `page`, all page objects, and utilities in `@BeforeSuite`
- **Key feature**: Records Playwright **traces** (screenshots, snapshots, sources) in `target/traces/` per test method
- Credentials loaded from `UserDetailsPropertiesLoad.getUserName()` and `.getPassword()`
- All test classes extend `BaseTest`

#### **Test Structure**
- Tests follow fluent API calls across multiple page objects
- Each test method typically represents an end-to-end user workflow
- Uses static imports from page classes for readability
- Assertions via TestNG `Assert` class

### Page Object Patterns
```java
// Fluent API: method chaining
loginPage.withUsername(username).andPassword(password).login();

// Static imports for cleaner test code
selectProductType(ProductType.APPARELS);
addToCart();
checkout();
```

## Important Architectural Details

### Playwright Context and Tracing
- Browser context has `setStrictSelectors(false)` for more flexible selector matching
- **Tracing is enabled per test method** to capture detailed debugging information
- Traces saved to `target/traces/{testName}.zip`
- Use these traces to debug test failures in Playwright Inspector

### Data-Driven Testing
- User credentials and config in `src/main/resources/UserDetails.properties`
- Test data files: `userdetails.xlsx` (Excel) and `userdetails.csv` (CSV)
- Use `ExcelUtils` and `CSVUtils` to read test data in parameterized tests

### Static State Management
- Page objects use static `Page` instance (initialized in BaseTest)
- This pattern supports fluent method chaining but be aware of state sharing between test methods
- All page class references initialized once in `@BeforeSuite`

## TestNG XML Suites

- `testng.xml`: Main test suite (currently runs `TestRemoveItemFromCartDemo`)
- `registerTest.xml`, `productsTest.xml`: Additional test suites
- Specify suite via `-Dsuite=` parameter in Maven command

## Debugging and Troubleshooting

- **Traces**: Check `target/traces/` directory after test runs for Playwright trace files
- **Logs**: Review log4j2 output configured in `src/main/resources/log4j2.xml`
- **Failed tests**: Use Playwright trace inspection to see screenshots and DOM snapshots
- **Selector issues**: Set `setStrictSelectors(false)` already enabled in `DriverSetup`

## Common Task Patterns

### Adding a New Test
1. Create test class extending `BaseTest`
2. Use `@Test` annotation with description
3. Call page object methods in fluent style
4. Use static assertions from TestNG

### Adding a New Page Object
1. Create class in `pages/` package with static `Page` instance
2. Accept `Page` in constructor
3. Use Playwright CSS/XPath selectors: `page.click()`, `page.fill()`, `page.locator()`
4. Return `this` for method chaining (fluent API)
5. Register initialization in `BaseTest.setUpSuite()`

### Data-Driven Testing
1. Place test data in `src/main/resources/`
2. Use `ExcelUtils` or `CSVUtils` to read files
3. Create parameterized tests with `@DataProvider` in TestNG
4. Pass data parameters to test methods

## CI/CD

- Azure Pipelines configured in `azure-pipelines.yml`
- Runs Maven test suite on code push

## Java Version

Target Java version is **25**. Ensure IDE and Maven compiler are configured appropriately.
