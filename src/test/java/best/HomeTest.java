package best;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends BaseTest {

    private HomePage homePage;


    @Test()
    public void positiveHomePageTest(){

        homePage = PageFactory.initElements(driver, HomePage.class);

            Assert.assertEquals("My Store", homePage.getTitle());
    }
}
