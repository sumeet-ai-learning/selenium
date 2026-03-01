package com.triscent.pages;

import com.microsoft.playwright.Page;
import static com.triscent.utilities.LogUtility.log;

public class LoginPage {

    private static Page page;
    private static String emailId = "";
    private static final String TITLE = "Demo Web Shop. Login";

    public LoginPage(Page page) {
        this.page = page;
    }

    public static boolean verifyTitle() {
        return TITLE.equals(page.title());
    }

    public static String getEmailId() {
        return emailId;
    }

    public LoginPage withUsername(String username) {
        page.fill("input[name='Email']", username);
        emailId = username;
        log.info("User " + username + " tried to login.");
        return this;
    }

    public LoginPage andPassword(String password) {
        page.fill("input[name='Password']", password);
        return this;
    }

    public static void login() {
        page.click("input[value='Log in']");
    }
}