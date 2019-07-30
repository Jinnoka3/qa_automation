package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AddNewAddressPage extends  AccountCreationPage {
    WebDriver driver;
    private MyAddressesPage myAddressesPage;

    public AddNewAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

    @FindBy(css = "h3")
    List<WebElement> aliasTitles;

    private ArrayList<String> aliseArray = new ArrayList<>();

    public void findElements(List<WebElement> webElementsList) {
        for (WebElement webElement : webElementsList) {
            System.out.println(webElement.getText());
        }
    }

    public void addAlisesArray(AccountData accountData){
        for (int i = 0; i < accountData.getAddressMap().size(); i++) {
            aliseArray.add(accountData.getAddressMap().get(i).getAlias());
        }
        //System.out.println(alisesArray);
    }
    public void addNewAddress(AccountData accountData) {
        //myAddressesPage = PageFactory.initElements(driver, MyAddressesPage.class);
        //addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);

        findElements(aliasTitles);
        addAlisesArray(accountData);
        for (int i = 1; i < accountData.getAddressMap().size(); i++) {
            //for (WebElement webElement : aliasTitles) {
                //if (aliseArray.contains(webElement.getText())) {
            myAddressesPage.clickAddNewAddress();
                    //myAddressesPage.clickAddNewAddress();

                    sendToForm(getFirstNameInAdressForm(), accountData.getUserInfo().getFirstName());
                    sendToForm(getLastNameInAdressForm(), accountData.getUserInfo().getLastName());
                    sendToForm(getCompany(), accountData.getAddressMap().get(i).getCompany());
                    sendToForm(getCompany(), accountData.getAddressMap().get(i).getCompany());

                    sendToForm(getAdressLine1(), accountData.getAddressMap().get(i).getAddress1());
                    sendToForm(getAdressLine2(), accountData.getAddressMap().get(i).getAddress2());

                    sendToForm(getCity(), accountData.getAddressMap().get(i).getCity());
                    selectByText(getState(), accountData.getAddressMap().get(i).getState());
                    sendToForm(getZip(), accountData.getAddressMap().get(i).getZip());
                    selectByText(getCountry(), accountData.getAddressMap().get(i).getCountry());

                    sendToForm(getAdditionalInformation(), accountData.getAddressMap().get(i).getInfo());
                    sendToForm(getHomePhone(), accountData.getAddressMap().get(i).getPhone());
                    sendToForm(getMobilePhone(), accountData.getAddressMap().get(i).getMobile());
                    sendToForm(getAnAdressAlias(), accountData.getAddressMap().get(i).getAlias());
                    //addNewAddressPage.saveNewAddress();
            saveNewAddress();
               // }
           // }
        }
    }

    public void saveNewAddress() {
        click(save);
    }
}


