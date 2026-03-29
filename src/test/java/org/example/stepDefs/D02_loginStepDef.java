package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;

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

        // URL check
        String currentUrl = Hooks.driver.getCurrentUrl();
        soft.assertEquals(currentUrl, "https://demo.nopcommerce.com/");

        // My account displayed
        soft.assertTrue(login.myAccountTab().isDisplayed());

        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void failedLogin() {
        SoftAssert soft = new SoftAssert();

        String errorText = login.errorMessage().getText();
        soft.assertTrue(errorText.contains("Login was unsuccessful"));

        String color = login.errorMessage().getCssValue("color");

        // convert RGBA to HEX
        String hex = org.openqa.selenium.support.Color.fromString(color).asHex();
        soft.assertEquals(hex, "#e4434b");

        soft.assertAll();
    }
}