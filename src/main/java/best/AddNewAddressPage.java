package best;

import data_model.AccountData;
import data_model.UserAddress;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AddNewAddressPage extends  AccountCreationPage {
    //WebDriver driver;

    public AddNewAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

    @FindBy(css = "h3")
    List<WebElement> aliasTitles;


    @FindBy(css = "a[title = \"Update\"]")
    List<WebElement> updateButtons;

    private boolean aliasIsOnThePage(String alias, List<WebElement> webElements){
        for(WebElement web : webElements){
            //System.out.println(web.getText());
            //System.out.println(alias);
            //System.out.println(web.getText());
            if(alias.toUpperCase().compareTo(web.getText()) == 0){
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> aliasArray = new ArrayList<>();

    public void addAliasArray(AccountData accountData){
        for (int i = 0; i < accountData.getAddressMap().size(); i++) {
            aliasArray.add(accountData.getAddressMap().get(i).getAlias());
        }
    }
    public void addNewAddress(AccountData accountData) {

        addAliasArray(accountData);

        for (int i = 0; i < aliasArray.size(); i++) {

            if (!aliasIsOnThePage(accountData.getAddressMap().get(i).getAlias(), aliasTitles)) {

                MyAddressesPage myAddressesPage = PageFactory.initElements(driver, MyAddressesPage.class);
                myAddressesPage.clickAddNewAddress();


                sendToForm(getFirstNameInAdressForm(), accountData.getAddressMap().get(i).getAddressFirstName());
                sendToForm(getLastNameInAdressForm(), accountData.getAddressMap().get(i).getAddressLastName());
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

                AddNewAddressPage addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);
                addNewAddressPage.saveNewAddress();
            }
        }
    }

    public void saveNewAddress() {
        click(save);
    }
}


