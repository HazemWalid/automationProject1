package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user click on first slider")
    public void clickFirstSlider() {
        Hooks.driver.get("https://demo.nopcommerce.com/");

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(driver -> home.sliderAnchors().size() >= 2);
        wait.until(ExpectedConditions.elementToBeClickable(home.firstSlider()));

        home.firstSlider().click();
    }

    @Then("user should be redirected to first slider page")
    public void verifyFirstSlider() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("nokia-lumia-1020"),
                ExpectedConditions.urlToBe("https://demo.nopcommerce.com/")
        ));

        String url = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(
                url.contains("nokia-lumia-1020"),
                "Expected URL to contain nokia-lumia-1020 but was: " + url
        );
    }

    @Given("user click on second slider")
    public void clickSecondSlider() {
        Hooks.driver.get("https://demo.nopcommerce.com/");

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(driver -> home.sliderAnchors().size() >= 2);
        wait.until(ExpectedConditions.elementToBeClickable(home.secondSlider()));

        home.secondSlider().click();
    }

    @Then("user should be redirected to second slider page")
    public void verifySecondSlider() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("iphone-6"),
                ExpectedConditions.urlToBe("https://demo.nopcommerce.com/")
        ));

        String url = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(
                url.contains("iphone-6"),
                "Expected URL to contain iphone-6 but was: " + url
        );
    }
}