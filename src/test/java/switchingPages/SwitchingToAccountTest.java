package switchingPages;

import main.user.UserGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.AccountPage;
import pom.HomePage;
import pom.LoginPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SwitchingToAccountTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    UserGenerator userData = new UserGenerator();


    @After
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void switchingSuccessfullyToAccountPageWithAuth() {
        open(baseUrl);
        homePage.clickLoginButton();

        loginPage.setUserLoginData(userData.genericLogin())
                .clickLoginButton();

        homePage.clickAccountButton();

        accountPage.waitUntilAccountPageIsVisible();

        Assert.assertEquals((baseUrl + "account/profile"), url());
    }

    @Test
    public void switchingSuccessfullyToAccountPageWithoutAuth() {
        open(baseUrl);
        homePage.clickAccountButton();

        loginPage.waitUntilLoginPageIsVisible();

        Assert.assertEquals((baseUrl + "login"), url());
    }
}
