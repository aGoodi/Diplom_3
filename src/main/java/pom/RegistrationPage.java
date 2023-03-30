package pom;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import main.user.User;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {

    private final ElementsCollection textFields = $$(By.xpath(".//input[@type = 'text']"));

    private final SelenideElement passwordField = $(By.xpath(".//input[@type = 'password']"));

    private final SelenideElement registrationButton = $(By.xpath(".//button[text() = 'Зарегистрироваться']"));

    private final SelenideElement loginButton = $(by("href", "/login"));

    private final SelenideElement passwordError = $(By.xpath(".//p[text() = 'Некорректный пароль']"));


    public RegistrationPage() {
    }

    public RegistrationPage setUserRegistrationData(User user) {
        List<SelenideElement> elements = textFields;
        elements.get(0).sendKeys(user.getName());
        elements.get(1).sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        return this;
    }

    public RegistrationPage clickRegisterButton() {
        registrationButton.click();
        return this;
    }

    public RegistrationPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }
}
