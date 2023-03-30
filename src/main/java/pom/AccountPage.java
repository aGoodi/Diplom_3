package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private final SelenideElement profileButton = $(By.xpath(".//a[text()='Профиль']"));

    private final SelenideElement logoutButton = $(By.xpath(".//button[text()='Выход']"));

    private final SelenideElement logoButton = $(By.xpath(".//nav/div/a"));

    public AccountPage() {
    }

    public AccountPage clickLogoutButton() {
        logoutButton.click();
        return this;
    }

    public AccountPage clickLogoButton() {
        logoButton.click();
        return this;
    }

    public AccountPage waitUntilAccountPageIsVisible() {
        profileButton.shouldBe(Condition.visible);
        return this;
    }
}
