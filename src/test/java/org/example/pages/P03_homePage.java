package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {

    public WebElement searchBox() {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchBtn() {
        return Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public List<WebElement> searchResults() {
        return Hooks.driver.findElements(By.cssSelector("h2.product-title a"));
    }

    public WebElement skuOnProductPage() {
        return Hooks.driver.findElement(By.cssSelector("span.sku-number"));
    }
    // currency dropdown
    public WebElement currencyDropdown() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    // list of product prices
    public List<WebElement> productPrices() {
        return Hooks.driver.findElements(By.cssSelector("span.price.actual-price"));
    }
    // main categories (Computers, Electronics, Apparel)
    public List<WebElement> mainCategories() {
        return Hooks.driver.findElements(By.cssSelector("ul.top-menu.notmobile > li > a"));
    }

    // sub categories
    public List<WebElement> subCategories(WebElement mainCategory) {
        return mainCategory.findElements(By.xpath("following-sibling::ul/li/a"));
    }

    // page title
    public WebElement pageTitle() {
        return Hooks.driver.findElement(By.cssSelector("div.page-title h1"));
    }
    // first slider (iPhone)
    public WebElement firstSlider() {
        return Hooks.driver.findElement(By.cssSelector("div.nivo-slider a:nth-of-type(1)"));
    }

    // second slider (Samsung)
    public WebElement secondSlider() {
        return Hooks.driver.findElement(By.cssSelector("div.nivo-slider a:nth-of-type(2)"));
    }
    public WebElement facebookIcon() {
        return Hooks.driver.findElement(By.cssSelector("a.facebook"));
    }

    public WebElement twitterIcon() {
        return Hooks.driver.findElement(By.cssSelector("a.twitter"));
    }

    public WebElement rssIcon() {
        return Hooks.driver.findElement(By.cssSelector("a.rss"));
    }

    public WebElement youtubeIcon() {
        return Hooks.driver.findElement(By.cssSelector("a.youtube"));
    }
    // add to wishlist button (first product)
    public WebElement addToWishlistBtn() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    // success message
    public WebElement successMessage() {
        return Hooks.driver.findElement(By.cssSelector("div.bar-notification.success"));
    }

    // wishlist tab
    public WebElement wishlistTab() {
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }

    // wishlist quantity
    public WebElement wishlistQty() {
        return Hooks.driver.findElement(By.cssSelector("span.wishlist-qty"));
    }
}