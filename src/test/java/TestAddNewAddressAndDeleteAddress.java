import com.triscent.pages.HeaderLinksSupport;
import com.triscent.pages.WebShopHome;
import com.triscent.utilities.BrowserHelper;
import org.testng.annotations.Test;

import static com.triscent.pages.AddressAddPage.*;
import static com.triscent.pages.AddressHomePage.*;
import static com.triscent.pages.HeaderLinksSupport.clickEmailId;
import static com.triscent.pages.HeaderLinksSupport.verifyUserLoggedIn;
import static com.triscent.pages.MyAccountOptions.clickAddresses;
import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.utilities.BrowserHelper.wakeUpAfter;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAddNewAddressAndDeleteAddress extends BaseTest {

    @Test(description = "This test case is used to test new Address functionality.")
    public void testNewAddress() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        HeaderLinksSupport.clickLogin();
        loginPage.withUsername(username).andPassword(password).login();
        assertTrue(verifyUserLoggedIn());
        clickEmailId();
        clickAddresses();
        clickAddNewAddressButton();
        setFirstName("First");
        setLastName("Last");
        setEmail("email@email.com");
        setCompany("ABC");
        setCountry("India");
        setCity("City");
        setAddressLine1("Address Line 1");
        setAddressLine2("Address Line 2");
        setPostalCode("Post Code");
        setPhoneNumber("123456789");
        setFaxNumber("12345");
        clickSaveButton();
        //wakeUpAfter(100);
        assertEquals(2, noOfAddresses());
        clickAddresses();
        deleteAddress(2);
        //wakeUpAfter(100);
        assertEquals(1, noOfAddresses());
    }
}