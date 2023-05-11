package amazonPages;

import core.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BaseSeleniumPage {
    @FindBy(id = "nav-link-accountList")
    private WebElement navigationToLoginButton;

    @FindBy(id = "nav-item-signout")
    private WebElement signOutButton;

    @FindBy(id = "searchDropdownBox")
    private WebElement filterDropdown;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//h3[contains(text(),'Popular in Books')]")
    private WebElement popularInBooks;

    @FindBy(xpath = "//h3[contains(text(),'More in Books')]")
    private WebElement moreInBooks;

    @FindBy(xpath = "//h3[contains(text(),'Textbooks')]")
    private WebElement textbooks;

    @FindBy(id = "icp-nav-flyout")
    private WebElement languageField;

    @FindBy(xpath = "//span[contains(text(),'español')]")
    private WebElement spanish;

    @FindBy(xpath = "//span[contains(text(),'English')]")
    private WebElement english;

    @FindBy(xpath = "//h2[contains(text(),'Compra por Categoría')]")
    private WebElement shopByCategoryOnSpanish;

    @FindBy(xpath = "//h2[contains(text(),'Shop by Category')]")
    private WebElement shopByCategory;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        navigationToLoginButton.click();
        new MainPage();
    }

    public void hoverToAccountListMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(navigationToLoginButton).perform();
        new MainPage();
    }

    public void signOut() {
        signOutButton.click();
        new MainPage();
    }

    public void selectFilterByOption(String option) {
        Select elements = new Select(filterDropdown);
        elements.selectByVisibleText(option);
        searchButton.click();
    }

    public void ver_FilterByBooksSelected() {
        Assertions.assertTrue(popularInBooks.isDisplayed());
        Assertions.assertTrue(moreInBooks.isDisplayed());
        Assertions.assertTrue(textbooks.isDisplayed());
    }

    public void changeLanguageToSpanish() {
        Actions actions = new Actions(driver);
        actions.moveToElement(languageField).perform();
        spanish.click();
    }

    public void changeLanguageToEnglish() {
        Actions actions = new Actions(driver);
        actions.moveToElement(languageField).perform();
        english.click();
    }

    public void ver_LanguageChangedToSpanish() {
        Assertions.assertTrue(shopByCategoryOnSpanish.isDisplayed());
    }

    public void ver_LanguageChangedToEnglish() {
        Assertions.assertTrue(shopByCategory.isDisplayed());
    }
}
