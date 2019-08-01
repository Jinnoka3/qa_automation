package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import data_model.UserAddress;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MyAddressesPage extends AccountCreationPage {

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.col-sm-6")
    private List<WebElement> addresses;

    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private WebElement addNewAddress;

    @FindBy(css = "a[title = \"Update\"]")
    List<WebElement> updateButtons;

    private ArrayList<String> aliseArray = new ArrayList<>();

    public void addAliasesArray(AccountData accountData) {
        for (int i = 0; i < accountData.getAddressMap().size(); i++) {
            aliseArray.add(accountData.getAddressMap().get(i).getAlias());
        }
    }

    public boolean verifyAddAddresses(AccountData accountData) {
        addAliasesArray(accountData);
        return (aliseArray.size() == accountData.getAddressMap().size()) ;
    }

    public void updateAddresses(AccountData accountData) {

        addAliasesArray(accountData);

        for (int i = 0; i < aliseArray.size(); i++) {

                click(updateButtons.get(i));

                sendToForm(getFirstNameInAdressForm(), accountData.getAddressMap().get(i).getAddressFirstName());
                sendToForm(getLastNameInAdressForm(), accountData.getAddressMap().get(i).getAddressLastName());
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

                MyAddresseUpdatePage myAddresseUpdatePage = PageFactory.initElements(driver, MyAddresseUpdatePage.class);
                myAddresseUpdatePage.clickSave();
        }
    }

    public void clickAddNewAddress() {
        click(addNewAddress);
    }


    public String addressesFromToString() {
        StringBuilder text = new StringBuilder();
        for (WebElement webElement : addresses) {
            text.append(webElement.getText()).append("\n");
        }
        return text.toString();
    }

    public String addressesFromUser(AccountData accountData) {
        StringBuilder text = new StringBuilder();
        for(UserAddress address : accountData.getAddressMap()){
            text.append(address).append("\n");
        }
        return text.toString();
    }

    public boolean verifyAddresses(AccountData accountData){
        /*System.out.println(addressesFromUser(accountData).compareTo(addressesFromToString()));
        System.out.println(addressesFromUser(accountData));
        System.out.println("-------------");
        System.out.println(addressesFromToString());*/
        return addressesFromUser(accountData).compareTo(addressesFromToString()) == 0;
    }
}
