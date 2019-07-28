package best;

import data_model.AccountData;
import data_model.UserInfo;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerificationInfoTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyPersonalInfoPage myPersonalInfoPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void verificationUserDataTest(AccountData accountData) {

        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myPersonalInfoPage = PageFactory.initElements(driver, MyPersonalInfoPage.class);

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        accountCreationPage.accountCreate(accountData);
        accountCreationPage.register();

        myAccountPage.clickPersonalInfo();
        Assert.assertTrue(myPersonalInfoPage.verificationAllUserInfo(accountData));

        //System.out.println(myPersonalInfoPage.getUserInformation());

        }
    /*private void verifyPersonalInformation(AccountData accountData){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                myPersonalInfoPage.getFirstNameAttribute(),
                accountData.getUserInfo().getFirstName());
        softAssert.assertEquals(
                myPersonalInfoPage.getLastNameAttribute(),
                accountData.getUserInfo().getLastName());
        softAssert.assertEquals(
                myPersonalInfoPage.getEmailAttribute(),
                accountData.getEmail());
        softAssert.assertAll();
    }*/
}

