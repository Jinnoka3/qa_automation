package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAddresseUpdatePage extends AccountCreationPage {

    public MyAddresseUpdatePage(WebDriver driver) {
        super(driver);
    }

   /* @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;

    public void clickSave() {
        click(saveButton);
    }*/

    @FindBy(xpath = " //span[contains(text(),'Save')]")
    private WebElement saveButton;

    public void clickSave() {
        click(saveButton);
    }

    private boolean aliasIsOnThePage(String alias, List<WebElement> webElements) {
        for (WebElement web : webElements) {
            //System.out.println(web.getText());
            //System.out.println(alias);
            //System.out.println(web.getText());
            if (alias.toUpperCase().compareTo(web.getText()) == 0) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> aliseArray = new ArrayList<>();

    public void addAlisesArray(AccountData accountData) {
        for (int i = 0; i < accountData.getAddressMap().size(); i++) {
            aliseArray.add(accountData.getAddressMap().get(i).getAlias());
        }
    }
}
