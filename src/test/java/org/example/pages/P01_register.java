
package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {

    public WebElement registerlink()
    {
        return  Hooks.getDriver().findElement(By.className("ico-register"));
    }

    public WebElement genderMale() {
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement firstName() {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName() {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement email() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement password() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword() {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerBtn() {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement successMessage() {
        return Hooks.driver.findElement(By.className("result"));
    }
}
