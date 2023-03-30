package pom;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPage {
    public PasswordRecoveryPage() {
    }

    private final SelenideElement loginButton = $(by("href", "/login"));

    public PasswordRecoveryPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
