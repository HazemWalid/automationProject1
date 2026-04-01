package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class D07_followUsStepDef {

    P03_homePage homePage = new P03_homePage();
    String actualUrl;
    String mainTab;

    @Given("user opens facebook link")
    public void openFacebook() throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/");
        scrollToFooter();
        mainTab = Hooks.driver.getWindowHandle();
        homePage.facebookIcon().click();
        switchToNewTabAndGetUrl();
    }

    @Given("user opens twitter link")
    public void openTwitter() throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/");
        scrollToFooter();
        mainTab = Hooks.driver.getWindowHandle();
        homePage.twitterIcon().click();
        switchToNewTabAndGetUrl();
    }

    @Given("user opens rss link")
    public void openRss() throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/");
        scrollToFooter();
        mainTab = Hooks.driver.getWindowHandle();
        homePage.rssIcon().click();
        switchToNewTabAndGetUrl();
    }

    @Given("user opens youtube link")
    public void openYoutube() throws InterruptedException {
        Hooks.driver.get("https://demo.nopcommerce.com/");
        scrollToFooter();
        mainTab = Hooks.driver.getWindowHandle();
        homePage.youtubeIcon().click();
        switchToNewTabAndGetUrl();
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String expectedUrl) {
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    private void scrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    private void switchToNewTabAndGetUrl() throws InterruptedException {
        Thread.sleep(2000);

        Set<String> tabs = Hooks.driver.getWindowHandles();

        for (String tab : tabs) {
            if (!tab.equals(mainTab)) {
                Hooks.driver.switchTo().window(tab);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        actualUrl = Hooks.driver.getCurrentUrl();
    }
}