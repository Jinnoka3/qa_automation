package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MyAddresseUpdate extends AccountCreationPage{

    public MyAddresseUpdate(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[title = \"Update\"]")
    List<WebElement> updateButtons;

    public void clickUpdate(){

        //click(updateButtons);
    }

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

    private ArrayList<String> aliseArray = new ArrayList<>();

    public void addAlisesArray(AccountData accountData){
        for (int i = 0; i < accountData.getAddressMap().size(); i++) {
            aliseArray.add(accountData.getAddressMap().get(i).getAlias());
        }
    }
}
