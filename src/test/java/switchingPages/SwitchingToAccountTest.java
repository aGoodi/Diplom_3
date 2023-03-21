package switchingPages;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.AccountPage;
import pom.HomePage;
import pom.LoginPage;

public class SwitchingToAccountTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void switchingSuccessfullyToAccountPageWithAuth() {
        HomePage homePage = new HomePage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        AccountPage accountPage = new AccountPage(browserRule.getDriver());

        homePage.open()
                .clickLoginButton();
        loginPage.setUserLoginData("fds423423423@ya.ru","56782y349uie0")
                .clickLoginButton();
        homePage.clickAccountButton();

        Assert.assertTrue(accountPage.isAccountPageOpen());
    }

    @Test
    public void switchingSuccessfullyToAccountPageWithoutAuth() {
        HomePage homePage = new HomePage(browserRule.getDriver());
        LoginPage loginPage = new LoginPage(browserRule.getDriver());

        homePage.open()
                .clickAccountButton();

        Assert.assertTrue(loginPage.isLoginPageOpen());
    }
}
