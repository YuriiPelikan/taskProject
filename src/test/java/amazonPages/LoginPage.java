package amazonPages;

import core.BaseSeleniumPage;
import core.Helpers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static readProperties.ConfigProvider.readConfig;

public class LoginPage extends BaseSeleniumPage {
    Helpers helpers = new Helpers();

    @FindBy(id = "ap_email")
    private WebElement loginField;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    @FindBy(id = "ap-account-fixup-phone-skip-link")
    private WebElement notNowNumberButton;

    @FindBy(id = "nav-logo-sprites")
    private WebElement amazonIcon;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String password) {
        loginField.sendKeys(login);
        continueButton.click();
        passwordField.sendKeys(password, Keys.ENTER);
    }

    public void login() {
        loginField.sendKeys(readConfig().getString("login"));
        continueButton.click();
        passwordField.sendKeys(readConfig().getString("password")/*, Keys.ENTER*/);
        signInButton.click();
        helpers.clickElementIfVisible(notNowNumberButton);
    }

    public void ver_LoginSuccessful() {
        Assertions.assertTrue(amazonIcon.isDisplayed());
    }

    public void ver_SignOutSuccessfully() {
        Assertions.assertTrue(loginField.isDisplayed());
    }
}
