package best;

import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    private SignInPage signInPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void signInTest(AccountData accountData) {

        signInPage = PageFactory.initElements(driver, SignInPage.class);

        signInPage.signIn(accountData);

        Assert.assertEquals("Authentication", signInPage.getTitle());
    }

}

