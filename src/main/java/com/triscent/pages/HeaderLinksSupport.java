package com.triscent.pages;

import com.microsoft.playwright.Page;

public class HeaderLinksSupport {

    private static String emailId= LoginPage.getEmailId();
    private static Page page;

    public HeaderLinksSupport(Page page){
    this.page = page;
    }

    public static void clickEmailId() {
        page.click("text=" + LoginPage.getEmailId());
    }

    public static boolean verifyUserLoggedIn(){
        return page.isVisible("text=" + LoginPage.getEmailId());
    }

    public static void clickLogout(){
        if(page.isVisible("text=Log out"))
        page.click("text=Log out");
    }

    public static void clickLogin() {
        page.click("text=Log in");
    }

    public static void clickShoppingCartButton(){
        page.click("//span[text()='Shopping cart']");
    }

    public static void clickRegister() {
        page.click("text=Register");
    }
}