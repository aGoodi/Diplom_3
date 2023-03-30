package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement loginButton = $(By.xpath(".//button[text() = 'Войти в аккаунт']"));

    private final SelenideElement orderButton = $(By.xpath(".//button[text() = 'Оформить заказ']"));

    private final SelenideElement accountButton = $(by("href", "/account"));

    private final SelenideElement currentTab = $(By.xpath(".//div[contains(@class, 'current')]/span"));

    private final SelenideElement bunsTab = $(By.xpath(".//span[text()='Булки']"));

    private final SelenideElement saucesTab = $(By.xpath(".//span[text()='Соусы']"));

    private final SelenideElement fillingsTab = $(By.xpath(".//span[text()='Начинки']"));

    public HomePage() {
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public HomePage clickAccountButton() {
        accountButton.click();
        return this;
    }

    public HomePage clickSaucesTab() {
        saucesTab.click();
        return this;
    }

    public HomePage clickBunsTab() {
        bunsTab.click();
        return this;
    }

    public boolean isBunsTabSelected() {
        return currentTab.getText().equals("Булки");
    }

    public boolean isSaucesTabSelected() {
        return currentTab.getText().equals("Соусы");
    }

    public HomePage clickFillingsTab() {
        fillingsTab.click();
        return this;
    }

    public boolean isFillingsTabSelected() {
        return currentTab.getText().equals("Начинки");
    }

    public HomePage waitUntilHomePageAfterLoginIsVisible() {
        orderButton.shouldBe(Condition.visible);
        return this;
    }

}
