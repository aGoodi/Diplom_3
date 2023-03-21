package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private final WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/account/profile";

    private final By profileButton = By.xpath(".//a[text()='Профиль']");

    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    private final By logoButton = By.xpath(".//nav/div/a");

    private final By constructorButton = By.xpath(".//a/p[text()='Конструктор']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountPageOpen() {
        return driver.findElement(profileButton).isDisplayed();
    }

    public AccountPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return this;
    }

    public AccountPage clickLogoButton() {
        driver.findElement(logoButton).click();
        return this;
    }
}
