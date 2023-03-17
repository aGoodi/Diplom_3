package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {

    private final WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/forgot-password";

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginButton = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecoveryPage open() {
        driver.get(url);
        return this;
    }

    public PasswordRecoveryPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
}
