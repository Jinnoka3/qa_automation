package best;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInTest extends BaseTest{

    private SignInPage signInPage;

    @Override
    @BeforeClass
    public void beforeClassMethod() throws IOException {
        super.beforeClassMethod();
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }

    @Test(dataProvider = "personalInformation", dataProviderClass = AccountData.class)
    public void signIn(AccountData obj){
        signInPage.clickSignIn();
        LOGGER.info("email: " + obj.getEmail());
        signInPage.sendEmailFirstPage(obj.getEmail());
        signInPage.clickCreateAnAccount();

        String text = signInPage.getTitle();

        try {
            Assert.assertEquals("Authentication", text);
            LOGGER.info("Correct email");
        }
        catch (Error error){
            LOGGER.error("Uncorrect email");
        }
    }

    @Test(dataProvider = "personalInformation", dataProviderClass = AccountData.class)
    public void signInError(AccountData obj){
        signInPage.clickSignIn();
        LOGGER.info("email: " + obj.getWrongEmail());
        signInPage.sendEmailFirstPage(obj.getWrongEmail());
        signInPage.clickCreateAnAccount();

        String text = signInPage.getInvalidEmail();

        try {
            Assert.assertEquals("Invalid email address.", text);
            LOGGER.info("Uncorrect email");
        }
        catch (Error error){
            LOGGER.error("Correct email");
        }
    }
}
