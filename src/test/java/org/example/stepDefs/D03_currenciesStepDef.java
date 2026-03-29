package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user select Euro currency")
    public void selectEuro() {

        Select select = new Select(home.currencyDropdown());
        select.selectByVisibleText("Euro");
    }

    @Then("Euro symbol is shown on all products")
    public void verifyEuroSymbol() {

        List<WebElement> prices = home.productPrices();

        for (int i = 0; i < prices.size(); i++) {
            String priceText = prices.get(i).getText();

            Assert.assertTrue(priceText.contains("€"));
        }
    }
}