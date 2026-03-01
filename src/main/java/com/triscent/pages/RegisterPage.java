package com.triscent.pages;

import com.microsoft.playwright.Page;
import com.triscent.support.Gender;

public class RegisterPage {
    private static Page page;

    private static final String TITLE= "Demo Web Shop. Register";

    public RegisterPage(Page page) {
        this.page = page;
    }

    public static boolean verifyTitle(){
        return TITLE.equals(page.title());
    }

    public void init(Page page) { // This method should not be static
        this.page = page;
    }

    public static void clickRegisterButton(){
        page.click("#register-button");
    }

    public static String getErrorMessageForPasswordMatch(){
        return page.innerText("//span[@for='ConfirmPassword']");
    }

    public static void selectGender(Gender gender){
        if (gender.name().equals("MALE")) {
            page.click("#gender-male");
        } else if (gender.name().equals("FEMALE")) {
            page.click("#gender-female");
        }
    }

    public static void selectGender(String gender){
        if (gender.equalsIgnoreCase("MALE")) {
            page.click("#gender-male");
        } else if (gender.equalsIgnoreCase("FEMALE")) {
            page.click("#gender-female");
        }
    }

    public static void enterFirstName(String firstName){
        page.fill("input[name='FirstName']", firstName);
    }

    public static void enterLastName(String lastName){
        page.fill("input[name='LastName']", lastName);
    }

    public static void enterEmail(String email){
        page.fill("input[name='Email']", email);
    }

    public static void enterPassword(String password){
        page.fill("input[name='Password']", password);
    }

    public static void enterConfirmPassword(String repassword){
        page.fill("input[name='ConfirmPassword']", repassword);
    }

    public static boolean verifyRegister(){
            page.waitForSelector(".result");
            return  page.innerText(".result").equals("Your registration completed");
    }

    public static String getRegisterSuccessMessage(){
        return page.innerText(".result");
    }
}