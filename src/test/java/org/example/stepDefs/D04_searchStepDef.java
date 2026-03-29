package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {

    P03_homePage home = new P03_homePage();
    String searchValue;

    @Given("user go to home page")
    public void goHome() {
        // already handled in Hooks
    }

    @When("user search for {string}")
    public void search(String value) {
        searchValue = value;
        home.searchBox().sendKeys(value);
        home.searchBtn().click();
    }

    @Then("search results should be displayed")
    public void verifyResults() {

        SoftAssert soft = new SoftAssert();

        // 1- URL contains search
        String currentUrl = Hooks.driver.getCurrentUrl();
        soft.assertTrue(currentUrl.contains("search?q="));

        // 2- results exist
        List results = home.searchResults();
        soft.assertTrue(results.size() > 0);

        // 3- each result contains search word
        for (int i = 0; i < results.size(); i++) {
            String text = home.searchResults().get(i).getText().toLowerCase();
            soft.assertTrue(text.contains(searchValue.toLowerCase()));
        }

        soft.assertAll();
    }

    @And("user click on product in search result")
    public void clickProduct() {
        home.searchResults().get(0).click();
    }

    @Then("user should see correct sku {string}")
    public void verifySku(String expectedSku) {

        String actualSku = home.skuOnProductPage().getText();

        Assert.assertTrue(actualSku.contains(expectedSku));
    }
}