import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    static final Logger LOGGER = Logger.getLogger(AccountCreationPage.class);
    WebDriver driver;

    @BeforeClass
    public void beforeClassMethod() throws IOException {

        System.setProperty("webdriver.chrome.driver", ConfigFileReader.readDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.readImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigFileReader.readUrl());
        PropertyConfigurator.configure(ConfigFileReader.readLog());
        LOGGER.info("Start");
    }

    @AfterClass
    public void afterClassMethod(){
        driver.close();
        LOGGER.info("End");
    }
}
