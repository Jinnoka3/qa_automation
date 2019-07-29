package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewAddressPage extends  AccountCreationPage {


    public AddNewAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

    public void saveNewAddress() {
        click(save);
    }

    public void addNewAddress(int i, AccountData accountData) {

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
    }

}


