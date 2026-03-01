package com.triscent.support;

import com.microsoft.playwright.Page;

public class ProductSelectorHelperMenu {

    private static Page page;

    public ProductSelectorHelperMenu(Page page) {
        this.page = page;
    }

    public static void sortBy(SortBy sortBy) {
        System.out.println(sortBy.getValue());
        page.selectOption("select[name='products-orderby']", new String[]{sortBy.getValue()});
    }

}