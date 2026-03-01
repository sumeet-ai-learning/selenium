import com.triscent.pages.HeaderLinksSupport;
import com.triscent.pages.ProductHome;
import com.triscent.pages.WebShopHome;
import com.triscent.support.ProductType;
import com.triscent.support.SortBy;
import org.testng.annotations.Test;

import static com.triscent.pages.CartPage.*;
import static com.triscent.pages.HeaderLinksSupport.clickShoppingCartButton;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.OrderProduct.addToCart;
import static com.triscent.pages.OrderProduct.setQuantity;
import static com.triscent.pages.ProductHome.selectProduct;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.pages.WebShopHome.selectProductType;
import static com.triscent.support.ProductSelectorHelperMenu.sortBy;
import static com.triscent.utilities.BrowserHelper.takeScreenShot;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestRemoveItemFromCartDemo extends BaseTest{

    @Test(description = "This test is check the functionality of removing an item.")
    public void ToRemoveAnItem() throws Exception{
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        assertTrue (verifyUserLoggedIn());
        selectProductType(ProductType.APPARELS);
        ProductHome.listAllProductNames()
                            .forEach(System.out::println);
        sortBy(SortBy.priceByAscending);
        selectProduct("Casual Golf Belt");
        setQuantity(4);
        addToCart();
        clickShoppingCartButton();
        checkTermsAndConditions();
        takeScreenShot(page,"filled_cart.png");
        removeItem("Casual Golf Belt");
        assertEquals(getAllCartItems().size(), 0) ;
        takeScreenShot(page,"empty_cart.png");
    }
}