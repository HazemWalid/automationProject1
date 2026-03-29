package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement loginLink() {
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement email() {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement password() {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement loginBtn() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement myAccountTab() {
        return Hooks.driver.findElement(By.className("ico-account"));
    }

    public WebElement errorMessage() {
        return Hooks.driver.findElement(By.cssSelector("div.message-error"));
    }
}