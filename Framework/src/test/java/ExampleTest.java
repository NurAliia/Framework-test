import org.testng.annotations.*;

public class ExampleTest extends A_BaseTest {

    @BeforeClass
    public void beforeSuite()
    {
        app.loginPage.open();
    }
    @AfterClass
    public void afterSuite()
    {
        app.loginPage.logout();
    }
    @Test
    public void loginViaEmail() {
        app.loginPage.login("abc", "abc@mail.ru", "123");

        logger.info("Sample info message");

        softAssert.assertEquals(2,2);
        softAssert.assertAll();
    }

    @Test
    public void gadgets() {
        app.loginPage.login("abc", "abc@mail.ru", "123");
        app.catalogPage.gadgets();

        logger.info("Sample info message");

        softAssert.assertEquals(2,2);
        softAssert.assertAll();
    }

    @Test
    @Parameters({"maxPrice"})
    public void searchByPrice(String maxPrice) {
        app.loginPage.login("abc", "abc@mail.ru", "123");
        app.catalogPage.searchByPrice(maxPrice);

        logger.info("Sample info message");

        softAssert.assertEquals(2,2);
        softAssert.assertAll();
    }
}
