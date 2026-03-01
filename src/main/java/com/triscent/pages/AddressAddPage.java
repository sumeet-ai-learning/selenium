package com.triscent.pages;

import com.microsoft.playwright.Page;
import static com.triscent.utilities.LogUtility.log;

public class AddressAddPage {

    private static final String TITLE= "Demo Web Shop. Account";
    private static final String URL = "http://demowebshop.tricentis.com/customer/addressadd";

    private static Page page;

    public AddressAddPage(Page page) {
    AddressAddPage.page = page;
    }

    public static void setFirstName(String firstName) {
        page.fill("name=Address.FirstName", firstName);
        log.info("First Name set as "+firstName);
    }

    public static void setLastName(String lastName) {
        page.fill("name=Address.LastName", lastName);
        log.info("Last Name set as "+lastName);
    }

    public static void setEmail(String email) {
        page.fill("name=Address.Email", email);
        log.info("Email set as "+email);
    }

    public static void setCompany(String company) {
        page.fill("name=Address.Company", company);
        log.info("Company Name Set as "+company);
    }

    public static void setCountry(String country) {
        page.selectOption("select[name='Address.CountryId']", new String[]{country});
        log.info("Country set as "+country);
    }

    public static void setState(String state) {
        page.selectOption("select[name='Address.StateProvinceId']", new String[]{state});
        log.info("State set as "+state);
    }

    public static void setCity(String city) {
        page.fill("name=Address.City", city);
        log.info("City set as "+city);
    }

    public static void setAddressLine1(String addressLine1) {
        page.fill("name=Address.Address1", addressLine1);
        log.info("Address Line 1 set as "+addressLine1);
    }

    public static void setAddressLine2(String addressLine2) {
        page.fill("name=Address.Address2", addressLine2);
        log.info("Address Line 2 set as "+addressLine2);

    }

    public static void setPostalCode(String postalCode) {
        page.fill("name=Address.ZipPostalCode", postalCode);
        log.info("Postal Code set as "+postalCode);
    }

    public static void setPhoneNumber(String phoneNumber) {
        page.fill("name=Address.PhoneNumber", phoneNumber);
        log.info("Phone Number set as"+phoneNumber);
    }

    public static void setFaxNumber(String faxNumber) {
        page.fill("name=Address.FaxNumber", faxNumber);
        log.info("Fax Number set as "+faxNumber);
    }

    public static void clickSaveButton() {
        page.click("input[type='submit'][value='Save']");
        log.info("Saved button clicked.");
    }
}