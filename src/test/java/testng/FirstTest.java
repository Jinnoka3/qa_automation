package testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class FirstTest {

    @DataProvider(name = "someDataProvider")
        public Object[][] simpleDataProvider () {
            return new Object[][]{
                    {1, -1},
                    {-2, 2},
                    {2, 3}
            };
        }

    @DataProvider(name = "someDataProviderTrue")
    public Object[] simpleDataProviderTrue () {
        return new Object[]{
                false
        };
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite actions");
    }

    @DataProvider(name = "someDataProviderFail")
    public Object[] simpleDataProviderFail () {
        return new Object[]{
                "Fail!"
        };
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite actions");
    }

    @Test
    @Parameters({"first", "second"})
    public void testWithSoftAssert(Integer c, Integer d){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(c, d,"Pair is not equals");

        c = 5;
        d = 5;
        softAssert.assertEquals(c, d,"Pair is not equals");

        softAssert.assertAll();
    }

    @Test(dataProvider = "someDataProvider")
    public void test1(Integer a, Integer b){
        Assert.assertEquals(Math.pow(a, 2), Math.pow(b, 2),"Provided members are not equals");

    }

   @Test(dataProvider = "someDataProvider")
    public void test2(Integer a, Integer b){
        Assert.assertNotEquals(Math.abs(a), Math.abs(b), "Provided members are equals");
    }

    @Test(dataProvider = "someDataProviderTrue")
    public void test3(boolean a){
        Assert.assertTrue(a, "False");
    }

    @Test (dataProvider = "someDataProviderTrue")
    public void test4(boolean a){
        Assert.assertFalse(a, "True");
    }

    @Test (dataProvider = "someDataProviderFail")
    public void test5(String a){
        Assert.fail(a);
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method actions");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method actions");
    }
}
