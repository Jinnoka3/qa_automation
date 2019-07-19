package best;

import best.data_pool.DataPool;
import best.utils.ConfigFileReader;
import data_model.AccountData;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LoginLogoutTest extends BaseTest{

    private SignInPage signInPage;

    @Parameters({"email", "password"})
    @Test()
    public void logInTest(String email, String password) {

        signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.alreadyRegistered(email, password);
        Assert.assertEquals("My account", signInPage.getTitle());
    }

    @Test()
    public void logOutTest() {

        signInPage.clickSignOut();
        Assert.assertEquals("Authentication", signInPage.getTitle());
    }
}
