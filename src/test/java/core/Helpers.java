package core;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    public WebElement waitForElementByTime(int timeInSeconds, WebElement element) {
        return new WebDriverWait(WebDriverRunner.getWebDriver(), timeInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElementIfVisible(WebElement element) {
        try {
            new WebDriverWait(WebDriverRunner.getWebDriver(), 5).until(ExpectedConditions.visibilityOf(element)).click();
        } catch (Exception ignored) {
            //in case when element not found
        }
    }
}
