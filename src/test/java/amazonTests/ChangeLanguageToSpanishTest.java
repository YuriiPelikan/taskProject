package amazonTests;

import amazonPages.LoginPage;
import amazonPages.MainPage;
import core.BaseSeleniumTest;
import org.junit.jupiter.api.Test;

public class ChangeLanguageToSpanishTest extends BaseSeleniumTest {

    @Test
    public void changeLanguageToSpanishTest() {
        new MainPage().openLoginPage();

        new LoginPage().login();
        new LoginPage().ver_LoginSuccessful();

        new MainPage().changeLanguageToSpanish();
        new MainPage().ver_LanguageChangedToSpanish();

        new MainPage().changeLanguageToEnglish();
        new MainPage().ver_LanguageChangedToEnglish();
    }
}
