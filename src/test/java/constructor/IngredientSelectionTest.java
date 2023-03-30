package constructor;

import org.junit.Assert;
import org.junit.Test;
import pom.HomePage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class IngredientSelectionTest {

    HomePage homePage = new HomePage();

    @Test
    public void switchingFillingTabsSuccessfully() {
        open(baseUrl);
        homePage.clickFillingsTab();

        Assert.assertTrue(homePage.isFillingsTabSelected());
    }

    @Test
    public void switchingSaucesTabsSuccessfully() {
        open(baseUrl);
        homePage.clickSaucesTab();

        Assert.assertTrue(homePage.isSaucesTabSelected());
    }

    @Test
    public void switchingBunsTabsSuccessfully() {
        open(baseUrl);
        homePage.clickSaucesTab()
                .clickBunsTab();

        Assert.assertTrue(homePage.isBunsTabSelected());
    }
}
