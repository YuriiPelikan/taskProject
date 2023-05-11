package amazonTests;

import amazonPages.LoginPage;
import amazonPages.MainPage;
import core.BaseSeleniumTest;
import org.junit.jupiter.api.Test;

public class FilterByGoodTest extends BaseSeleniumTest {

    @Test
    public void filterByGoodTest() {
        new MainPage().openLoginPage();

        new LoginPage().login();
        new LoginPage().ver_LoginSuccessful();

        new MainPage().selectFilterByOption("Books");
        new MainPage().ver_FilterByBooksSelected();
    }
}
