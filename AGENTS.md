# AGENTS.md - AI Agent Guidance for Playwright Test Automation Framework

## Project Overview
This is a Playwright-based end-to-end test automation framework for the Demo Web Shop e-commerce app, using Page Object Model with fluent API, TestNG runner, and Maven build system. Despite the "selenium-new" name, it's fully migrated to Playwright.

**Tech Stack:** Java 25, Playwright 1.41.0, TestNG 6.14.3, Maven, Log4j2, Apache POI for Excel/CSV data.

## Architecture
- **Page Objects** (`src/main/java/com/triscent/pages/`): Each class uses a static `Page` instance, fluent method chaining (e.g., `loginPage.withUsername(user).andPassword(pass).login()`), and returns `this` for chaining. Static methods for verifications/actions.
- **BaseTest** (`src/test/java/BaseTest.java`): Initializes all page objects in `@BeforeSuite`, enables Playwright tracing per test method (saved to `target/traces/{method}.zip`).
- **Driver Management** (`src/main/java/com/triscent/utilities/DriverSetup.java`): Static methods for browser lifecycle; context has `setStrictSelectors(false)` for flexible selectors.
- **Data Sources** (`src/main/resources/`): Credentials from `UserDetails.properties`, test data from `userdetails.xlsx`/`userdetails.csv` via `ExcelUtils`/`CSVUtils`.

## Critical Workflows
- **Build:** `mvn clean compile` or `mvn clean install`
- **Run Tests:** `mvn test` (all), `mvn test -Dtest=TestBuyAProduct` (class), `mvn test -Dtest=TestBuyAProduct#testOrderAPrdoduct` (method), `mvn test -Dsuite=testng.xml` (suite)
- **Debug:** View traces in `target/traces/` using Playwright Trace Viewer; logs via `log4j2.xml`

## Project-Specific Patterns
- **Fluent API in Pages:** Methods like `withUsername(String)` return `this`; chain actions before calling static `login()`. Example: `new LoginPage(page).withUsername("user").andPassword("pass").login();`
- **Static State:** Page objects share static `Page` instance; initialized once in `BaseTest.setUpSuite()`.
- **Tracing:** Automatic per-method traces with screenshots/snapshots/sources; inspect failures via `playwright show-trace target/traces/trace.zip`
- **Test Structure:** Extend `BaseTest`; use static imports for page methods; assertions via `org.testng.Assert`
- **Data Loading:** Use `UserDetailsPropertiesLoad.getUserName()` for creds; `ExcelUtils.readExcel()` for parameterized tests

## Key Files
- `pom.xml`: Dependencies and Java 25 config
- `BaseTest.java`: Suite setup, tracing logic, page initializations
- `DriverSetup.java`: Browser/context/page management
- `LoginPage.java`: Exemplifies fluent API pattern
- `testng.xml`: Suite configs for different test groups

Follow fluent chaining in page objects, enable tracing for debugging, and use Maven commands for builds/tests.
