package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {

    private final WebDriver driver;

    private final String url = "https://stellarburgers.nomoreparties.site/register";

    private final By textFields = By.xpath(".//input[@type = 'text']");

    //private final By emailField = By.xpath(".//label[text() = 'Email']/input");

    private final By passwordField = By.xpath(".//input[@type = 'password']");

    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    private final By loginButton = By.xpath(".//a[text() = 'Войти']");

    private final By passwordError = By.xpath(".//p[text() = 'Некорректный пароль']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage open() {
        driver.get(url);
        return this;
    }

    public RegistrationPage setUserRegistrationData(String name, String email, String password) {
        List<WebElement> elements = driver.findElements(textFields);
        elements.get(0).sendKeys(name);
        elements.get(1).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public RegistrationPage clickRegisterButton() {
        driver.findElement(registrationButton).click();
        return this;
    }

    public RegistrationPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }

}
