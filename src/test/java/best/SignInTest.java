package best;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest{

    private SignInPage signInPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void signInTest(AccountData accountData){

        LOGGER.info("email: " + accountData.getEmail());
        signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.signIn(accountData);


            Assert.assertEquals("Authentication", signInPage.getTitle());
            //LOGGER.info("Correct email");

            //LOGGER.error("Uncorrect email");
        }
    }

   /* @Test(dataProvider = "personalInformation", dataProviderClass = AccountData.class)
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
    }*/

