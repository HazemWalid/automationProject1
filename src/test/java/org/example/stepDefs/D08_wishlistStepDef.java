package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class D08_wishlistStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user add product to wishlist")
    public void addToWishlist() {

        home.addToWishlistBtn().click();
    }

    @Then("success message is displayed with green color")
    public void verifySuccessMessage() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(home.successMessage()));

        // text check
        String message = home.successMessage().getText();
        Assert.assertTrue(message.contains("The product has been added"));

        // color check
        String color = home.successMessage().getCssValue("background-color");
        String hex = Color.fromString(color).asHex();

        Assert.assertEquals(hex, "#4bb07a");
    }

    // -----------------------

    @When("user open wishlist page")
    public void openWishlist() {
        home.wishlistTab().click();
    }

    @Then("wishlist quantity should be greater than 0")
    public void verifyWishlistQty() {

        String qtyText = home.wishlistQty().getText(); // (1)

        qtyText = qtyText.replace("(", "").replace(")", "");

        int qty = Integer.parseInt(qtyText);

        Assert.assertTrue(qty > 0);
    }
}