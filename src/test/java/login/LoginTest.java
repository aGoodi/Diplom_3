package login;

import main.user.UserGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


public class LoginTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
    UserGenerator userData = new UserGenerator();

    @After
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void loginSuccessfullyFromHomePage() {
        open(baseUrl);
        homePage.clickLoginButton();

        loginPage.setUserLoginData(userData.genericLogin());
        loginPage.clickLoginButton();

        homePage.waitUntilHomePageAfterLoginIsVisible();

        Assert.assertEquals(baseUrl, url());
    }

    @Test
    public void loginSuccessfullyFromAccountButton() {
        open(baseUrl);
        homePage.clickAccountButton();

        loginPage.setUserLoginData(userData.genericLogin())
                .clickLoginButton();

        homePage.waitUntilHomePageAfterLoginIsVisible();

        Assert.assertEquals(baseUrl, url());
    }

    @Test
    public void loginSuccessfullyFromRegisterPage() {
        open(baseUrl);
        homePage.clickLoginButton();

        loginPage.clickRegistrationButton();

        registrationPage.clickLoginButton();

        loginPage.setUserLoginData(userData.genericLogin())
                .clickLoginButton();

        homePage.waitUntilHomePageAfterLoginIsVisible();

        Assert.assertEquals(baseUrl, url());
    }

    @Test
    public void loginSuccessfullyFromPasswordRecoveryPage() {
        open(baseUrl + "forgot-password");
        passwordRecoveryPage.clickLoginButton();

        loginPage.setUserLoginData(userData.genericLogin());
        loginPage.clickLoginButton();

        homePage.waitUntilHomePageAfterLoginIsVisible();

        Assert.assertEquals(baseUrl, url());
    }
}
