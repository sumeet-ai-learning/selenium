package com.triscent.pages;

import com.microsoft.playwright.Page;

public class AddressHomePage {

    private static Page page;

    public AddressHomePage(Page page){
        this.page = page;
    }
    public static void clickAddNewAddressButton(){
        page.click("input[value='Add new']");
    }

    public static int noOfAddresses(){
        return page.querySelectorAll("div[class='section address-item']").size();
    }
    public static void deleteAddress(int addressNumber){
        page.onDialog(dialog -> dialog.accept());
        page.querySelectorAll("//input[@value='Delete']").get(addressNumber-1).click();
    }

    public static void editAddress(int addressNumber){
        page.onDialog(dialog -> dialog.accept());
        page.querySelectorAll("//input[@value='Edit']").get(addressNumber-1).click();
    }
}