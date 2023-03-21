package login;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.HomePage;
import pom.LoginPage;
import pom.PasswordRecoveryPage;
import pom.RegistrationPage;

public class LoginTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void loginSuccessfullyFromHomePage() {
        HomePage homePage = new HomePage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        homePage.open()
                .clickLoginButton();
        loginPage.setUserLoginData("fds423423423@ya.ru","56782y349uie0")
                .clickLoginButton();

        Assert.assertTrue(homePage.isDisplayedOrderButton());
    }

    @Test
    public void loginSuccessfullyFromAccountButton() {
        HomePage homePage = new HomePage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        homePage.open()
                .clickAccountButton();
        loginPage.setUserLoginData("fds423423423@ya.ru","56782y349uie0")
                .clickLoginButton();

        Assert.assertTrue(homePage.isDisplayedOrderButton());
    }

    @Test
    public void loginSuccessfullyFromRegisterPage() {
        HomePage homePage = new HomePage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());

        registrationPage.open()
                .clickLoginButton();
        loginPage.setUserLoginData("fds423423423@ya.ru","56782y349uie0")
                .clickLoginButton();

        Assert.assertTrue(homePage.isDisplayedOrderButton());
    }

    @Test
    public void loginSuccessfullyFromePasswordRecoveryPage() {
        HomePage homePage = new HomePage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(browserRule.getDriver());

        passwordRecoveryPage.open()
                .clickLoginButton();
        loginPage.setUserLoginData("fds423423423@ya.ru","56782y349uie0")
                .clickLoginButton();

        Assert.assertTrue(homePage.isDisplayedOrderButton());
    }
}
