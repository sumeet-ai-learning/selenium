import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
The purpose of this class is to run independent tests. It doesn't extend the BaseTest for this purpose.
 */

public class UnitTest {

    Page page;

    @BeforeTest
    public  void setUp(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }


    @Test(enabled = false)
    public void openHomePage(){
        page.navigate("https://www.indiatoday.in/");
    }

    @Test(enabled = false)
    public void testing(){
        page.evaluate("window.scrollBy(0,1000)");
        page.evaluate("window.scrollBy(0,1000)");
    }
}