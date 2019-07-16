
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegistrationTest {

    private static WebDriver driver = new ChromeDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeClass
    public static void reg() {
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
    }

    @Test
    public void positiveTest() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("galinaprokofevna99@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")));

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).isDisplayed());
    }

    @Test
    public void negativeTest() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("galinaprokofevna@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("create_account_error")));

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"create_account_error\"]")).isDisplayed());
    }

    @Test
    public void positiveCreateAccountTest() {
        By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a").findElement(driver).click();

        By.xpath("//*[@id=\"email_create\"]").findElement(driver).sendKeys("jinnokumas123789@gmail.com");
        By.xpath("//*[@id=\"SubmitCreate\"]/span").findElement(driver).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@id='id_gender2']")));

        By.xpath(".//input[@id='id_gender2']").findElement(driver).click();

        By.name("customer_firstname").findElement(driver).sendKeys("Daria");
        By.xpath("//*[@id=\"customer_lastname\"]").findElement(driver).sendKeys("Kalinina");
        By.xpath("//*[@id=\"passwd\"]").findElement(driver).sendKeys("12345");

        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        dropdown1.selectByValue("9");

        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        dropdown2.selectByValue("1");

        Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        dropdown3.selectByValue("1996");

        By.id("newsletter").findElement(driver).click();
        By.id("optin").findElement(driver).click();

        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
        By.xpath("//*[@id=\"firstname\"]").findElement(driver).sendKeys("Daria");

        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
        By.xpath("//*[@id=\"lastname\"]").findElement(driver).sendKeys("Kalinina");

        By.xpath("//*[@id=\"company\"]").findElement(driver).sendKeys("Sperasoft");

        By.xpath("//*[@id=\"address1\"]").findElement(driver).sendKeys("Bulvar 30-letiya Pobedi, 111");
        By.xpath("//*[@id=\"address2\"]").findElement(driver).sendKeys("23, 15, 3а");
        By.xpath("//*[@id=\"city\"]").findElement(driver).sendKeys("Volgograd");

        Select dropdown4 = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        dropdown4.selectByValue("32");

        By.xpath("//*[@id=\"postcode\"]").findElement(driver).sendKeys("40013");

        Select dropdown5 = new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
        dropdown5.selectByValue("21");

        By.id("other").findElement(driver).sendKeys("Hello!");
        By.id("phone").findElement(driver).sendKeys("34-23-56");
        By.id("phone_mobile").findElement(driver).sendKeys("89365748234");


        driver.findElement(By.xpath("//*[@id=\"alias\"]")).clear();
        By.xpath("//*[@id=\"alias\"]").findElement(driver).sendKeys("Address");

        By.xpath("//*[@id=\"submitAccount\"]/span").findElement(driver).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).isDisplayed());
    }

    @Test
    public void negativeCreateAccountTest() {
        By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a").findElement(driver).click();

        By.xpath("//*[@id=\"email_create\"]").findElement(driver).sendKeys("jinnokumas123789@gmail.com");
        By.xpath("//*[@id=\"SubmitCreate\"]/span").findElement(driver).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@id='id_gender2']")));

        By.xpath(".//input[@id='id_gender2']").findElement(driver).click();


        // All works without "wait". Is this normal? Or need to do just in case?

        By.name("customer_firstname").findElement(driver).sendKeys("Daria");
        By.xpath("//*[@id=\"customer_lastname\"]").findElement(driver).sendKeys("Kalinina");
        By.xpath("//*[@id=\"passwd\"]").findElement(driver).sendKeys("12345");

        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        dropdown1.selectByValue("9");

        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        dropdown2.selectByValue("1");

        Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        dropdown3.selectByValue("1996");

        By.id("newsletter").findElement(driver).click();
        By.id("optin").findElement(driver).click();

        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
        By.xpath("//*[@id=\"firstname\"]").findElement(driver).sendKeys("Daria");

        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
        By.xpath("//*[@id=\"lastname\"]").findElement(driver).sendKeys("Kalinina");

        By.xpath("//*[@id=\"company\"]").findElement(driver).sendKeys("Sperasoft");

        By.xpath("//*[@id=\"address1\"]").findElement(driver).sendKeys("Bulvar 30-letiya Pobedi, 111");
        By.xpath("//*[@id=\"address2\"]").findElement(driver).sendKeys("23, 15, 3а");
        By.xpath("//*[@id=\"city\"]").findElement(driver).sendKeys("Volgograd");

        Select dropdown4 = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        dropdown4.selectByValue("32");

        By.xpath("//*[@id=\"postcode\"]").findElement(driver).sendKeys("4001389867");

        Select dropdown5 = new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
        dropdown5.selectByValue("21");

        By.id("other").findElement(driver).sendKeys("Hello!");
        By.id("phone").findElement(driver).sendKeys("34-23-56");
        By.id("phone_mobile").findElement(driver).sendKeys("89365748234");


        driver.findElement(By.xpath("//*[@id=\"alias\"]")).clear();
        By.xpath("//*[@id=\"alias\"]").findElement(driver).sendKeys("Address");

        By.xpath("//*[@id=\"submitAccount\"]/span").findElement(driver).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).isDisplayed(), "Wrong ZIP");
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }

}
