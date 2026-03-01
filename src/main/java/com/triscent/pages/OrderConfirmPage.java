package com.triscent.pages;

import com.microsoft.playwright.Page;
import static com.triscent.utilities.LogUtility.log;

public class OrderConfirmPage {

    private static Page page;

    public OrderConfirmPage(Page page) {
        this.page = page;
    }

    private static final String URL ="http://demowebshop.tricentis.com/checkout/completed/";
    private static final String TITLE = "Demo Web Shop. Checkout";

    public static boolean verifySuccessfulMessage(){
        String message = page.innerText("strong");
        if(message.equals("Your order has been successfully processed!"))
            log.info("Order placed successfully.");
        else log.error("Order not placed yet or not successful.");
        return message.equals("Your order has been successfully processed!");
    }

    public static void clickContiniueButton(){
        page.click("input[value='Continue']");
    }
}