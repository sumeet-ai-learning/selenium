import com.triscent.pages.HeaderLinksSupport;
import com.triscent.pages.WebShopHome;
import com.triscent.utilities.CSVUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.triscent.pages.HeaderLinksSupport.clickLogout;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.utilities.BrowserHelper.wakeUpAfter;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestDDTUserDetails extends BaseTest {

    @DataProvider(name = "userdetails")
    public Object[][] userDetails() {
        return CSVUtils.readCSV("userdetails.csv");
    }

    @Test(dataProvider = "userdetails", description = "This test is used to check user credentials by data driven testing")
    public void testLogin(String username, String password, String expected) {
        assertTrue(WebShopHome.verifyTitle());
        //wakeUpAfter(1000);
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        boolean result = Boolean.parseBoolean(expected);
        if (result)
            assertTrue(verifyUserLoggedIn());
        else
            assertFalse(verifyUserLoggedIn());
        clickLogout();
    }

}