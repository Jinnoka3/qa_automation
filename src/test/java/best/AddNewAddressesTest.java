package best;

import best.data_pool.DataPool;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddNewAddressesTest extends BaseTest{

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;

    private AddNewAddressPage addNewAddressPage;

    @BeforeClass
    protected void beforeSuite( ITestContext testContext ) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void addNewAddressesTest(AccountData accountData) {

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        accountCreationPage.accountCreate(accountData);
        accountCreationPage.register();
        myAccountPage.clickMyAddresses();

        //for (int i = 0; i < accountData.getAddressMap().size(); i++) {

            addNewAddressPage.addNewAddress(accountData);
            //addNewAddressPage.saveNewAddress();
       // }

        //myAddressesPage.print();
    }
}
