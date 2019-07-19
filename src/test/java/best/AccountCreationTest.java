package best;

import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountCreationTest extends BaseTest{

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void personalInfoTest(AccountData accountData){

        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);

        signInPage.signIn(accountData);
        accountCreationPage.accountCreate(accountData);

        Assert.assertEquals("> My account", accountCreationPage.getInvalidData());
    }
}
