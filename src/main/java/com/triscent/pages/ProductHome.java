package com.triscent.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProductHome {
    private static Page page;

    public ProductHome(Page page) {
        this.page = page;
    }

    public static void selectProduct(String product) {
        page.click("//h2/a[text()='" + product + "']");
    }

    public static List<String> listAllProductNames(){
        List<ElementHandle> elementList = page.querySelectorAll("//div[@class='item-box']//descendant::h2[@class]/a");
        return elementList.stream()
                .map(ElementHandle::innerText)
                .collect(Collectors.toList());
    }

    public static List<String> listAllProductPrices(){
        List<ElementHandle> elementList = page.querySelectorAll("//div[@class='item-box']//descendant::span[@class]");
        return elementList.stream()
                .map(ElementHandle::innerText)
                .collect(Collectors.toList());
    }
}