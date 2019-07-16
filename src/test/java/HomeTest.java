import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends BaseTest {

    private HomePage homePage;

    @Override
    @BeforeClass
    public void beforeClassMethod() throws IOException {
        super.beforeClassMethod();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test()
    public void positiveHomePageTest(){
        LOGGER.info("Title: " + homePage.getTitle());

        String text = homePage.getTitle();
        try {
            Assert.assertEquals("My Store", text);
            LOGGER.info("Home page");
        }
        catch (Error error){
            LOGGER.error("Not home page");
        }
    }
}
