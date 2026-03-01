package com.triscent.pages;

import com.microsoft.playwright.Page;

public class MyAccountOptions {

    private static Page page;

    public MyAccountOptions(Page page) {
        this.page = page;
    }

    public static void clickAddresses(){
        page.click("text=Addresses");
    }

}