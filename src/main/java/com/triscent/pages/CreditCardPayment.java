package com.triscent.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class CreditCardPayment{

    private static Page page;

    public CreditCardPayment(Page page) {
        this.page = page;
    }

    public enum CreditCardType{
        VISA("Visa"), MASTERCARD("Master Card"), DISCOVER("Discover"), AMEX("Amex");

        private String value;

        CreditCardType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void selectCreditCardType(CreditCardType creditCardType){
        page.selectOption("select[name='CreditCardType']", new String[]{creditCardType.value});
    }


    public static void sendCardHolderName(String cardHolderName){
        page.fill("input[name='CardholderName']", cardHolderName);
    }

    public static void sendCardNumber(String cardNumber){
        page.fill("input[name='CardNumber']", cardNumber);
    }

    public static void selectExpiryMonth(String month){
        try {
        int num = Integer.parseInt(month);
        if(num<0||num>12)
                throw new Exception("Invalid Month");
            } catch (Exception e) {
                e.printStackTrace();
            }
        page.selectOption("select[name='ExpireMonth']", new String[]{month});
    }

    public static void selectExpiryYear(String year){
        page.selectOption("#ExpireYear",new SelectOption().setValue(year));
    }

    public static void sendCardCode(String code){
        page.fill("input[name='CardCode']", code);
    }
}