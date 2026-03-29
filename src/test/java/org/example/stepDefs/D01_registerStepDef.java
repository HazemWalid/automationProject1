package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D01_registerStepDef {

  P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }
  @When("user select gender type")
  public void selectGender() {
    register.genderMale().click();
  }

  @And("user enter first name {string} and last name {string}")
  public void enterName(String first, String last) {
    register.firstName().sendKeys(first);
    register.lastName().sendKeys(last);
  }

 /* @And("user enter date of birth")
  public void dob() {
    new Select(Hooks.driver.findElement(By.name("DateOfBirthDay"))).selectByValue("10");
    new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth"))).selectByValue("5");
    new Select(Hooks.driver.findElement(By.name("DateOfBirthYear"))).selectByValue("1995");
  }*/

  @And("user enter email {string}")
  public void email(String email) {
    register.email().sendKeys(email);
  }

  @And("user fills Password fields {string} {string}")
  public void password(String pass, String confirm) {
    register.password().sendKeys(pass);
    register.confirmPassword().sendKeys(confirm);
  }

  @And("user clicks on register button")
  public void clickRegister() {
    register.registerBtn().click();
  }

  @Then("success message is displayed")
  public void success() {
    SoftAssert soft = new SoftAssert();

    soft.assertTrue(register.successMessage().isDisplayed());
    soft.assertTrue(register.successMessage().getText().contains("Your registration completed"));

    String color = register.successMessage().getCssValue("color");
    soft.assertEquals(color, "rgba(76, 177, 124, 1)");

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(register.successMessage()));

    soft.assertAll();

}
}



