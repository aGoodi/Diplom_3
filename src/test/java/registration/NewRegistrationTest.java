package registration;

import main.BrowserRule;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.RegistrationPage;

public class NewRegistrationTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void makeSuccessfulRegistration() {
        LoginPage loginPage = new LoginPage(browserRule.getDriver());
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());

        registrationPage.open()
                .setUserRegistrationData(RandomStringUtils.randomAlphabetic(12), RandomStringUtils.randomAlphabetic(12), RandomStringUtils.randomAlphabetic(12))
                .clickRegisterButton();

        Assert.assertTrue(loginPage.isLoginPageOpen());
    }

    @Test
    public void makeFailedRegistrationWithInvalidPassword() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());

        registrationPage.open()
                .setUserRegistrationData(RandomStringUtils.randomAlphabetic(12), RandomStringUtils.randomAlphabetic(12), RandomStringUtils.randomAlphabetic(5))
                .clickRegisterButton();

        Assert.assertTrue(registrationPage.isPasswordErrorDisplayed());
    }

}
