package com.triscent.pages;

import com.microsoft.playwright.Page;
import com.triscent.exceptions.LoginError;
import com.triscent.support.Categories;
import com.triscent.support.ProductType;
import static com.triscent.utilities.LogUtility.log;

public class WebShopHome {

    private static Page page;

    private static final String url = "http://demowebshop.tricentis.com/";
    private static final String TITLE = "Demo Web Shop";

    private static boolean isUserLoggedIn;

    public static boolean verifyUserLogin() {
        return isUserLoggedIn;
    }

    public WebShopHome(Page page) {
        this.page = page;
    }

    public static void openWebShopHomePage() {
        page.navigate(url);
    }

    public static boolean verifyTitle() {
        return TITLE.equals(page.title());
    }

    public static void selectProductType(Categories categories) {
        if (categories.getCategory().equals(ProductType.APPARELS.getCategory())) {
            page.click("text=" + ProductType.APPARELS.category);
        } else if (categories.getCategory().equals(ProductType.BOOKS.getCategory())) {
            page.click("text=" + ProductType.BOOKS.category);
        } else if (categories.getCategory().equals(ProductType.DIGITAL_DOWNLOADS.getCategory())) {
            page.click("text=" + ProductType.DIGITAL_DOWNLOADS.category);
        } else if (categories.getCategory().equals(ProductType.GIFT_CARDS.getCategory())) {
            page.click("text=" + ProductType.GIFT_CARDS.category);
        } else if (categories.getCategory().equals(ProductType.JEWELRY.getCategory())) {
            page.click("text=" + ProductType.JEWELRY.category);
        } else if (categories.getCategory().equals(ProductType.COMPUTERS.ACCESSORIES.getCategory())) {
            page.hover("text=COMPUTERS");
            page.click("text=Accessories");
        } else if (categories.getCategory().equals(ProductType.COMPUTERS.DESKTOPS.getCategory())) {
            page.hover("text=COMPUTERS");
            page.click("text=Desktops");
        } else if (categories.getCategory().equals(ProductType.COMPUTERS.NOTEBOOKS.getCategory())) {
            page.hover("text=COMPUTERS");
            page.click("text=Notebooks");
        } else if (categories.getCategory().equals(ProductType.ELECTONICS.CAMERA.getCategory())) {
            page.hover("text=ELECTRONICS");
            page.click("text=Camera, photo");
        } else if (categories.getCategory().equals(ProductType.ELECTONICS.CELLPHONES.getCategory())) {
            page.hover("text=ELECTRONICS");
            page.click("text=Cell phones");
        }
        log.info("Product "+categories.getCategory()+ " is selected");
    }

    public static void clickLogin() {
        if (page.isVisible("text=Log out")) {
             new LoginError("A user is already logged in.");
        } else {
            page.click(".ico-login");
            isUserLoggedIn = true;
        }
    }
}