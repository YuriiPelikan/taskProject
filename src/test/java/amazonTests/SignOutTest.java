package amazonTests;

import amazonPages.LoginPage;
import amazonPages.MainPage;
import core.BaseSeleniumTest;
import org.junit.jupiter.api.Test;

public class SignOutTest extends BaseSeleniumTest {

    @Test
    public void signOutTest() {
        new MainPage().openLoginPage();

        new LoginPage().login();
        new LoginPage().ver_LoginSuccessful();

        new MainPage().hoverToAccountListMenu();
        new MainPage().signOut();

        new LoginPage().ver_SignOutSuccessfully();
    }
}
