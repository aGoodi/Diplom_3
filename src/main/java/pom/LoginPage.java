package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import main.user.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement pageHeading = $(By.xpath(".//main/div/h2"));

    private final SelenideElement passwordField = $(By.xpath(".//input[@type = 'password']"));

    private final SelenideElement loginButton = $(By.xpath(".//button[text() = 'Войти']"));

    private final SelenideElement registrationButton = $(By.xpath(".//a[text() = 'Зарегистрироваться']"));

    private final SelenideElement emailField = $(by("name", "name"));

    public LoginPage() {
    }

    public LoginPage waitUntilLoginPageIsVisible() {
        pageHeading.shouldBe(Condition.visible);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public LoginPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    public LoginPage setUserLoginData(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        return this;
    }

}
