package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user click on first slider")
    public void clickFirstSlider() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(home.firstSlider()));

        home.firstSlider().click();
    }

    @Then("user should be redirected to first slider page")
    public void verifyFirstSlider() {

        String url = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(url.contains("iphone"));
    }

    // -------------------------

    @Given("user click on second slider")
    public void clickSecondSlider() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(home.secondSlider()));

        home.secondSlider().click();
    }

    @Then("user should be redirected to second slider page")
    public void verifySecondSlider() {

        String url = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(url.contains("samsung"));
    }
}