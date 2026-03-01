# GEMINI.md - Project Context

This file provides comprehensive context for the `selenium-new` project (which is actually a Playwright-based automation framework).

## Project Overview

This is a **Playwright-based end-to-end test automation framework** for the [Demo Web Shop](http://demowebshop.tricentis.com/) e-commerce application. Despite the directory name `selenium-new`, the framework has been migrated to Playwright.

### Core Tech Stack
- **Language:** Java 25
- **Browser Automation:** Playwright (Chromium, Firefox)
- **Test Runner:** TestNG
- **Build Tool:** Maven
- **Data-Driven Testing:** Apache POI (Excel), CSV utilities, Properties files
- **Logging:** Log4j2
- **Design Pattern:** Page Object Model (POM) with a Fluent API style

### Architecture
- **`src/main/java/com/triscent/pages/`**: Page Object Model classes. Each class typically uses a static `Page` instance and returns `this` for method chaining.
- **`src/main/java/com/triscent/support/`**: Data models (`Address`, `Product`), Enums (`ProductType`, `Categories`), and helper classes.
- **`src/main/java/com/triscent/utilities/`**: Infrastructure including `DriverSetup` (Playwright lifecycle), `LogUtility`, and data parsers (`ExcelUtils`, `CSVUtils`).
- **`src/test/java/`**: Test classes extending `BaseTest`.
- **`src/main/resources/`**: Test data and configuration files (`UserDetails.properties`, `userdetails.xlsx`).

## Building and Running

### Build Commands
- **Compile:** `mvn clean compile`
- **Install/Build:** `mvn clean install`

### Running Tests
- **All Tests:** `mvn test`
- **Single Test Class:** `mvn test -Dtest=TestBuyAProduct`
- **Single Test Method:** `mvn test -Dtest=TestBuyAProduct#testOrderAPrdoduct`
- **TestNG Suite:** `mvn test -Dsuite=testng.xml` (or `registerTest.xml`, `productsTest.xml`)

### Debugging
- **Playwright Traces:** Traces are automatically recorded per test method and saved to `target/traces/{testMethodName}.zip`. These can be viewed using the [Playwright Trace Viewer](https://trace.playwright.dev/).
- **Logs:** Check the console output or logs configured via `src/main/resources/log4j2.xml`.

## Development Conventions

### Page Object Pattern
- Follow the **Fluent API** pattern. Methods that perform actions on a page should return `this` or the next page object to allow chaining.
- Example: `loginPage.withUsername(user).andPassword(pass).login();`
- Page objects are initialized in `BaseTest.setUpSuite()`.

### Driver Management
- Use `DriverSetup` to access the current `Page` or `BrowserContext`.
- Browser lifecycle (start/stop) is managed in `BaseTest` via `@BeforeSuite` and `@AfterSuite`.

### Test Data
- Externalize test data into `src/main/resources/`.
- Use `UserDetailsPropertiesLoad` for credentials and `ExcelUtils`/`CSVUtils` for larger datasets.

### Testing Standards
- All test classes **must** extend `BaseTest`.
- Use TestNG assertions (`org.testng.Assert`).
- Tracing is enabled by default in `BaseTest` to aid in debugging failures.

## Key Files
- `pom.xml`: Project dependencies and Maven configuration.
- `src/test/java/BaseTest.java`: Global setup/teardown, tracing logic, and page object initialization.
- `src/main/java/com/triscent/utilities/DriverSetup.java`: Playwright initialization logic.
- `testng.xml`: Main test suite configuration.
- `CLAUDE.md`: Additional technical guidance for AI assistants.
