package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {

    P03_homePage home = new P03_homePage();

    String newTabUrl;

    // ---------------- FACEBOOK ----------------

    @Given("user opens facebook link")
    public void openFacebook() {
        home.facebookIcon().click();
        switchToNewTab();
    }

    @Then("facebook page should be opened")
    public void verifyFacebook() {
        Assert.assertTrue(newTabUrl.contains("facebook"));
    }

    // ---------------- TWITTER ----------------

    @Given("user opens twitter link")
    public void openTwitter() {
        home.twitterIcon().click();
        switchToNewTab();
    }

    @Then("twitter page should be opened")
    public void verifyTwitter() {
        Assert.assertTrue(newTabUrl.contains("twitter"));
    }

    // ---------------- RSS ----------------

    @Given("user opens rss link")
    public void openRSS() {
        home.rssIcon().click();

        // RSS opens in same tab
        newTabUrl = Hooks.driver.getCurrentUrl();
    }

    @Then("rss page should be opened")
    public void verifyRSS() {
        Assert.assertTrue(newTabUrl.contains("rss"));
    }

    // ---------------- YOUTUBE ----------------

    @Given("user opens youtube link")
    public void openYoutube() {
        home.youtubeIcon().click();
        switchToNewTab();
    }

    @Then("youtube page should be opened")
    public void verifyYoutube() {
        Assert.assertTrue(newTabUrl.contains("youtube"));
    }

    // ---------------- HELPER ----------------

    public void switchToNewTab() {

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        Hooks.driver.switchTo().window(tabs.get(1));

        newTabUrl = Hooks.driver.getCurrentUrl();
    }
}