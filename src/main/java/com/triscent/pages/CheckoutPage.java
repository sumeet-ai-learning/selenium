package com.triscent.pages;

import com.microsoft.playwright.Page;
import static com.triscent.utilities.LogUtility.log;

public class CheckoutPage {

    private static Page page;

    public CheckoutPage(Page page) {
        if (page == null)
            log.error("page object is null at Checkout Page");
        this.page = page;
    }

    public static void selectBillingAddressByValue(String address) {
        page.selectOption("select[name='billing_address_id']", new String[]{address});
    }

    /*
     *@param int index begins from '0'
     */

    public static void selectBillingAddressByIndex(int index) {
        page.selectOption("select[name='billing_address_id']", new com.microsoft.playwright.options.SelectOption().setIndex(index));
    }

    public static void selectShippingingAddressByValue(String address) {
        page.selectOption("select[name='shipping_address_id']", new String[]{address});
    }

    /*
     *@param int index begins from '0'
     */

    public static void selectShippingAddressByIndex(int index) {
        page.selectOption("select[name='shipping_address_id']", new com.microsoft.playwright.options.SelectOption().setIndex(index));
    }

    public static void selectShippingMethod(ShippingMethod shippingMethod) {
        if (shippingMethod.name().equals("GROUND"))
            page.click("#shippingoption_0");
        else if (shippingMethod.name().equals("ONE_DAY_AIR"))
            page.click("#shippingoption_1");
        else if (shippingMethod.name().equals("TWO_DAY_AIR"))
            page.click("#shippingoption_2");
    }

    public static void selectPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod.name().equals("COD"))
            page.click("#paymentmethod_0");
        else if (paymentMethod.name().equals("CHECK"))
            page.click("#paymentmethod_1");
        else if (paymentMethod.name().equals("CREDITCARD"))
            page.click("#paymentmethod_2");
        else if (paymentMethod.name().equals("PURCHASEORDER"))
            page.click("#paymentmethod_3");
    }

    public static void clickBackButton() {
        page.click("text=Back");
    }

    public static void clickBillingAddressContinueButton() {
        page.waitForSelector("//input[@onclick='Billing.save()']");
        page.click("//input[@onclick='Billing.save()']");
    }

    public static void clickShippingAddressContinueButton() {
        page.waitForTimeout(1000);
        page.waitForSelector("//input[@onclick='Shipping.save()']");
        page.click("//input[@onclick='Shipping.save()']");
    }

    public static void clickShippingMethodContinueButton() {
        page.waitForSelector("//input[@onclick='ShippingMethod.save()']");
        page.click("//input[@onclick='ShippingMethod.save()']");
    }

    public static void clickPaymentMethodContinueButton() {
        page.waitForSelector("//input[@onclick='PaymentMethod.save()']");
        page.click("//input[@onclick='PaymentMethod.save()']");
    }

    public static void clickPaymentInformationContinueButton() {
        page.waitForSelector("//input[@onclick='PaymentInfo.save()']");
        page.click("//input[@onclick='PaymentInfo.save()']");
    }

    public static void clickConfirmOrderContinueButton() {
        page.waitForTimeout(1000);
        page.click("//input[@onclick='ConfirmOrder.save()']");
    }

}