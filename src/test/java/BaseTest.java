import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Tracing;
import com.triscent.pages.*;
import com.triscent.support.ProductSelectorHelperMenu;
import com.triscent.utilities.BrowserHelper;
import com.triscent.utilities.DriverSetup;
import com.microsoft.playwright.Page;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.lang.reflect.Method;

import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.utilities.DriverSetup.quitBrowser;
import static org.testng.Assert.assertTrue;

/*
*This is a base test class. It will initialize setups for drivers as well as invoke all the Page Object Class.
 */

public class BaseTest {

    protected Page page;
    protected LoginPage loginPage;
    protected static final String username = UserDetailsPropertiesLoad.getUserName();
    protected static final String password = UserDetailsPropertiesLoad.getPassword();

    @BeforeSuite
    public void setUpSuite(){
        page = DriverSetup.openChrome();
        new WebShopHome(page);
        new MyAccountOptions(page);
        loginPage = new LoginPage(page);
        new ProductHome(page);
        new OrderProduct(page);
        new CartPage(page);
        new HeaderLinksSupport(page);
        new ProductSelectorHelperMenu(page);
        new RegisterPage(page);
        new BrowserHelper();
        new AddressAddPage(page);
        new AddressHomePage(page);
        new CheckoutPage(page);
        new CreditCardPayment(page);
        new OrderConfirmPage(page);
    }

    /*
    *The purpose of the following test is verify whether the browser is opening and the homepage is successfullly getting opened.
     */

    @Test(enabled = false)
    public void test(){
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
    }

    @BeforeMethod
    public void setupTrace() {
        BrowserContext context = DriverSetup.getContext();
        if (context != null) {
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
    }

    @AfterMethod
    public void recordTrace(Method method) {
        BrowserContext context = DriverSetup.getContext();
        if (context != null) {
            java.nio.file.Path tracePath = Paths.get("target/traces/" + method.getName() + ".zip");
            tracePath.getParent().toFile().mkdirs();
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(tracePath));
        }
    }

   @AfterSuite
    public void cleanUp(){
        quitBrowser();
    }
}