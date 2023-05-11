package amazonTests;

import amazonPages.LoginPage;
import amazonPages.MainPage;
import core.BaseSeleniumTest;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseSeleniumTest {

    @Test
    public void loginTest() {
        new MainPage().openLoginPage();

        new LoginPage().login();
        new LoginPage().ver_LoginSuccessful();
    }
}
