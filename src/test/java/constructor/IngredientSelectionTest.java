package constructor;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import pom.HomePage;

public class IngredientSelectionTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void switchingFillingTabsSuccessfully() {
        HomePage homePage = new HomePage(browserRule.getDriver());

        homePage.open()
                .clickFillingsTab();

        Assert.assertTrue(homePage.isFillingsTabSelected());
    }

    @Test
    public void switchingSaucesTabsSuccessfully() {
        HomePage homePage = new HomePage(browserRule.getDriver());

        homePage.open()
                .clickSaucesTab();

        Assert.assertTrue(homePage.isSaucesTabSelected());
    }

    @Test
    public void switchingBunsTabsSuccessfully() {
        HomePage homePage = new HomePage(browserRule.getDriver());

        homePage.open()
                .clickSaucesTab()
                .clickBunsTab();

        Assert.assertTrue(homePage.isBunsTabSelected());
    }
}
