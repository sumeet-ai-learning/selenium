package com.triscent.utilities;

import com.microsoft.playwright.*;

public final class DriverSetup {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    //      Hiding the Constructor
    private DriverSetup() {
    }

    //Method to invoke Firefox Driver
    public static Page openFirefox() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setStrictSelectors(false));
        page = context.newPage();
        return page;
    }

    //Method to invoke Chrome Driver
    public static Page openChrome() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setStrictSelectors(false));
        page = context.newPage();
        return page;
    }

    public static void closeBrowser() {
        if (page != null) page.close();
    }

    public static void quitBrowser() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public static Page getPage() {
        return page;
    }

    public static BrowserContext getContext() {
        return context;
    }
}