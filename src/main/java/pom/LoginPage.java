package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LoginPage {

    private final WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/login";
    private final By pageHeading = By.xpath(".//main/div/h2");

    private final By passwordField = By.xpath(".//input[@type = 'password']");

    private final By loginButton = By.xpath(".//button[text() = 'Войти']");

    private final By registrationLink = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By textFields = By.xpath(".//input[@type = 'text']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(url);
        return this;
    }

    public boolean isLoginPageOpen() {
        return driver.findElement(pageHeading).isDisplayed();
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage setUserLoginData(String email, String password) {
        List<WebElement> elements = driver.findElements(textFields);
        elements.get(0).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

}
