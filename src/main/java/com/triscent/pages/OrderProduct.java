package com.triscent.pages;

import com.microsoft.playwright.Page;

public class OrderProduct {

    private static Page page;

    public OrderProduct(Page page) {
        this.page = page;
    }

    public static void setQuantity(int quantity) {
        page.fill(".qty-input", String.valueOf(quantity));
    }

    public static String getPrice() {
        return page.innerText("//*[@itemprop='price']");
    }

    public static void addToCart() {
        page.click("//div[@class='add-to-cart-panel']/input[@value='Add to cart']");
    }
}