package registration;

import main.user.UserGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.LoginPage;
import pom.RegistrationPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class NewRegistrationTest {
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    UserGenerator userData = new UserGenerator();

    @After
    public void tearDown() {
        clearBrowserLocalStorage();
    }

    @Test
    public void makeSuccessfulRegistration() {
        open(baseUrl + "register");
        registrationPage.setUserRegistrationData(userData.randomRegister())
                .clickRegisterButton();

        loginPage.waitUntilLoginPageIsVisible();

        Assert.assertFalse(registrationPage.isPasswordErrorDisplayed());
        Assert.assertEquals((baseUrl + "account/profile"), url());
    }

    @Test
    public void makeFailedRegistrationWithInvalidPassword() {
        open(baseUrl + "register");
        registrationPage.setUserRegistrationData(userData.randomRegisterWithShortPassword())
                .clickRegisterButton();

        Assert.assertTrue(registrationPage.isPasswordErrorDisplayed());
    }

}
