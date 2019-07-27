package best;

import best.data_pool.DataPool;
import best.utils.ConfigFileReader;
import data_model.AccountData;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Listeners(SimpleTestListener.class)
public class BaseTest {

    static final Logger LOGGER = Logger.getLogger(AccountCreationPage.class);
    WebDriver driver;

    DataPool dataPool;

    @BeforeClass
    public void beforeClassMethod(ITestContext testContext) throws IOException {
        dataPool = new DataPool("dataFile", testContext, AccountData.class);
        //HashMap<String,String> parameters = new HashMap<>( testContext.getCurrentXmlTest().getAllParameters());
        //dataPool.processDataFile(parameters.get( "dataFile"), AccountData.class);

        System.setProperty("webdriver.chrome.driver", ConfigFileReader.readDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.readImplicitlyWait(), TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        driver.get(ConfigFileReader.readUrl());
        PropertyConfigurator.configure(ConfigFileReader.readLog());

    }

    @AfterClass
    public void afterClassMethod(){

        //driver.close();
    }
}
