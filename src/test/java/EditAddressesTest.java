/*
import best.*;
import best.data_pool.DataPool;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditAddressesTest extends BaseTest {
    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private AddNewAddressPage addNewAddressPage;
    private MyAddresseUpdatePage myAddresseUpdatePage;

    @BeforeClass
    protected void beforeSuite( ITestContext testContext ) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAddressesPage = PageFactory.initElements(driver, MyAddressesPage.class);
        addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);
        myAddresseUpdatePage = PageFactory.initElements(driver, MyAddresseUpdatePage.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void editAddressesTest(AccountData accountData) throws IOException {

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        accountCreationPage.accountCreate(accountData);
        accountCreationPage.register();

        myAccountPage.clickMyAddresses();

        addNewAddressPage.addNewAddress(accountData);

        myAddresseUpdatePage.updateAddress(accountData);
    }
}
*/
