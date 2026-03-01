package com.triscent.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import static com.triscent.utilities.LogUtility.log;

import java.util.List;

public class CartPage {
    private static Page page;

    private static final String TITLE = "Demo Web Shop. Shopping Cart";
    private static final String successfulDiscountCodeMessage = "The coupon code was applied";

    public CartPage(Page page) {
        if (page == null)
            log.error("Page is null as Cart Page");
        this.page = page;
    }

    public static boolean verifyTitle() {
        return TITLE.equals(page.title());
    }

    public static void checkTermsAndConditions() {
        page.waitForSelector("#termsofservice");
        page.click("#termsofservice");
    }

    public static void checkout() {
        page.click("#checkout");
    }

    public static boolean removeItem(String productName) throws Exception {
        String xpath = "//*[text()='" + productName + "' and @class='product-name']/ancestor::td/preceding-sibling::td[@class='remove-from-cart']";
        if (page.isVisible(xpath)) {
            page.click(xpath + "/input[@name='removefromcart']");
            page.click("#updatecart");
            page.waitForTimeout(100);
            return true;
        } else {
            log.info("Invalid Product. Product not found.");
            throw new Exception("Product Not Found");
        }
    }

    public static List<ElementHandle> getAllCartItems() {
        return page.querySelectorAll("//input[@name='removefromcart']");
    }

    public static boolean emptyCart() {
        List<ElementHandle> cartItemCheckBox = getAllCartItems();

        if (cartItemCheckBox.size() > 0) {
                cartItemCheckBox.forEach(ElementHandle::click);
                page.click("#updatecart");
                page.waitForTimeout(200);
            return true;
        } else {
            return false;
        }
    }

    public static void applyDiscountCode(String discountCode) {
        page.fill("#discountcouponcode", discountCode);
        page.click("#applydiscountcouponcode");
    }

    public static void removeDiscountCode() {
        page.click("#removediscountcouponcode");
    }

    public static boolean verifyDiscountCode() {
        String messageBox = "div.message";
           if(!page.isVisible(messageBox))
               return false;
        if (page.innerText(messageBox).equals(successfulDiscountCodeMessage))
            return true;
        else
            return false;
    }
}