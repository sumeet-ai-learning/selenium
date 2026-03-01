import com.triscent.pages.WebShopHome;
import com.triscent.support.ProductType;
import org.testng.annotations.Test;

import static com.triscent.pages.WebShopHome.openWebShopHomePage;
import static com.triscent.pages.WebShopHome.selectProductType;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAllProductCategory extends BaseTest {

    @Test(description = "Test Product Books")
    public void testBooks() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.BOOKS);
        assertEquals(page.url(), ProductType.BOOKS.URL());
    }

    @Test(description = "Test Product Computer Desktops")
    public void testDesktop() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.COMPUTERS.DESKTOPS);
        assertEquals(page.url(), ProductType.COMPUTERS.DESKTOPS.URL());
    }

    @Test(description = "Test Product Computer Notebooks")
    public void testNotebooks() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.COMPUTERS.NOTEBOOKS);
        assertEquals(page.url(), ProductType.COMPUTERS.NOTEBOOKS.URL());
    }

    @Test(description = "Test Product Computer Accessories")
    public void testAccessories() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.COMPUTERS.ACCESSORIES);
        assertEquals(page.url(), ProductType.COMPUTERS.ACCESSORIES.URL());
    }

    @Test(description = "Test Product Electronics Camera")
    public void testCamera() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.ELECTONICS.CAMERA);
        assertEquals(page.url(), ProductType.ELECTONICS.CAMERA.URL());
    }

    @Test(description = "Test Product Electronics Cell Phones")
    public void testCellphones() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.ELECTONICS.CELLPHONES);
        assertEquals(page.url(), ProductType.ELECTONICS.CELLPHONES.URL());
    }

    @Test(description = "Test Product Apparels and Shoes")
    public void testApparels() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.APPARELS);
        assertEquals(page.url(), ProductType.APPARELS.URL());
    }

    @Test(description = "Test Product Digital Downloads")
    public void testDigitalDownloads() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.DIGITAL_DOWNLOADS);
        assertEquals(page.url(), ProductType.DIGITAL_DOWNLOADS.URL());
    }

    @Test(description = "Test Product Digital Downloads")
    public void testJewelry() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.JEWELRY);
        assertEquals(page.url(), ProductType.JEWELRY.URL());
    }

    @Test(description = "Test Product Gift Cards")
    public void testGiftCards() {
        openWebShopHomePage();
        assertTrue(WebShopHome.verifyTitle());
        selectProductType(ProductType.GIFT_CARDS);
        assertEquals(page.url(), ProductType.GIFT_CARDS.URL());
    }
}