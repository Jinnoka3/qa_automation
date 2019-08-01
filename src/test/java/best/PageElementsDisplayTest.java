package best;

import best.data_pool.DataPool;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PageElementsDisplayTest extends BaseTest{

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;

    @BeforeClass
    protected void beforeSuite( ITestContext testContext ) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void pageElementShown(AccountData accountData) throws IllegalAccessException {

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        Assert.assertTrue(accountCreationPage.correctPageElementsAreShown());
    }
}
