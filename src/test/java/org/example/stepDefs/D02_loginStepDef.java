package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class D02_loginStepDef {

    P02_login login = new P02_login();

    @Given("user go to login page")
    public void goToLogin() {
        login.loginLink().click();
    }

    @When("user login with {string} {string} and {string}")
    public void loginData(String type, String email, String password) {
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }

    @And("user press on login button")
    public void clickLogin() {
        login.loginBtn().click();
    }

    @Then("user login to the system successfully")
    public void successLogin() {
            SoftAssert soft = new SoftAssert();

            WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

            // wait for URL
            wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/"));

            // wait for My Account tab
            soft.assertTrue(
                    wait.until(ExpectedConditions.visibilityOf(login.myAccountTab())).isDisplayed()
            );

            soft.assertAll();
        }

    @Then("user could not login to the system")
    public void failedLogin() {
        SoftAssert soft = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

        // wait for error message
        String errorText = wait.until(
                ExpectedConditions.visibilityOf(login.errorMessage())
        ).getText();

        soft.assertTrue(errorText.contains("Login was unsuccessful"));

        String color = login.errorMessage().getCssValue("color");
        String hex = org.openqa.selenium.support.Color.fromString(color).asHex();

        soft.assertEquals(hex, "#e4434b");

        soft.assertAll();
    }
}