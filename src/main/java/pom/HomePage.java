package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");
    private final By accountButton = By.xpath(".//nav/a/p");
    private final By pageHeading = By.xpath(".//h1[text()='Соберите бургер']");
    private final By currentTab = By.xpath(".//div[contains(@class, 'current')]/span");
    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open() {
        driver.get(url);
        return this;
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public HomePage clickAccountButton() {
        driver.findElement(accountButton).click();
        return this;
    }

    public HomePage clickSaucesTab() {
        driver.findElement(saucesTab).click();
        return this;
    }

    public HomePage clickBunsTab() {
        driver.findElement(bunsTab).click();
        return this;
    }

    public boolean isBunsTabSelected() {
        return driver.findElement(currentTab).getText().equals("Булки");
    }

    public boolean isSaucesTabSelected() {
        return driver.findElement(currentTab).getText().equals("Соусы");
    }

    public HomePage clickFillingsTab() {
        driver.findElement(fillingsTab).click();
        return this;
    }

    public boolean isFillingsTabSelected() {
        return driver.findElement(currentTab).getText().equals("Начинки");
    }

    public boolean isHomePageOpen() {
        return driver.findElement(pageHeading).isDisplayed();
    }

    public boolean isDisplayedOrderButton() {
        return driver.findElement(orderButton).isDisplayed();
    }

}
