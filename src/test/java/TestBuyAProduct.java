import com.triscent.pages.*;
import com.triscent.support.ProductType;
import com.triscent.support.SortBy;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.triscent.pages.CartPage.checkTermsAndConditions;
import static com.triscent.pages.CartPage.checkout;
import static com.triscent.pages.CheckoutPage.*;
import static com.triscent.pages.CreditCardPayment.*;
import static com.triscent.pages.HeaderLinksSupport.clickShoppingCartButton;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.OrderConfirmPage.verifySuccessfulMessage;
import static com.triscent.pages.OrderProduct.addToCart;
import static com.triscent.pages.OrderProduct.setQuantity;
import static com.triscent.pages.ProductHome.selectProduct;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.pages.WebShopHome.selectProductType;
import static com.triscent.support.ProductSelectorHelperMenu.sortBy;
import static org.testng.Assert.assertTrue;

public class TestBuyAProduct extends BaseTest{

    @Test(description = "To test the order functionality end-to-end")
    public void testOrderAPrdoduct(){
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        assertTrue (verifyUserLoggedIn());
        System.out.println("Logged in successfully");

        selectProductType(ProductType.APPARELS);
        sortBy(SortBy.priceByAscending);
        selectProduct("Casual Golf Belt");
        System.out.println("Product selected");

        setQuantity(4);
        addToCart();
        System.out.println("Added to cart");

        clickShoppingCartButton();
        checkTermsAndConditions();
        checkout();
        System.out.println("Proceeded to checkout");

        selectBillingAddressByIndex(0);
        clickBillingAddressContinueButton();
        System.out.println("Billing address submitted");

        clickShippingAddressContinueButton();
        System.out.println("Shipping address submitted");

        selectShippingMethod(ShippingMethod.ONE_DAY_AIR);
        clickShippingMethodContinueButton();
        System.out.println("Shipping method submitted");

        selectPaymentMethod(PaymentMethod.CREDITCARD);
        clickPaymentMethodContinueButton();
        System.out.println("Payment method submitted");

        selectCreditCardType(CreditCardPayment.CreditCardType.AMEX);
        sendCardHolderName("ABCDEF");
        sendCardNumber("12341234123");
        selectExpiryYear(String.valueOf(LocalDate.now().getYear() + 1)); // Use next year just in case
        selectExpiryMonth("03");
        sendCardCode("1234");
        clickPaymentInformationContinueButton();
        System.out.println("Payment info submitted");

        clickConfirmOrderContinueButton();
        System.out.println("Confirm order clicked");

        assertTrue(verifySuccessfulMessage());
    }
}
