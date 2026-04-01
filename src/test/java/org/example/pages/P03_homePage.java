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
        return Hooks.driver.findElement(By.cssSelector("button[type='submit']"));
    }

    public List<WebElement> searchResults() {
        return Hooks.driver.findElements(By.cssSelector("h2.product-title a"));
    }

    public WebElement skuOnProductPage() {
        return Hooks.driver.findElement(By.cssSelector("span.sku-number"));
    }

    public WebElement currencyDropdown() {
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> productPrices() {
        return Hooks.driver.findElements(By.cssSelector("span.price.actual-price"));
    }

    // Feature 5
    public List<WebElement> mainCategories() {
        return Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
    }

    public List<WebElement> subCategories(int selectedCategory) {
        int index = selectedCategory + 1;
        return Hooks.driver.findElements(
                By.cssSelector("ul.top-menu.notmobile > li:nth-child(" + index + ") ul.sublist.first-level > li > a")
        );
    }

    public WebElement pageTitle() {
        return Hooks.driver.findElement(By.cssSelector("div.page-title h1"));
    }

    // Feature 6
    public List<WebElement> sliderAnchors() {
        return Hooks.driver.findElements(By.cssSelector("#nivo-slider a"));
    }

    public WebElement firstSlider() {
        return sliderAnchors().get(0);
    }

    public WebElement secondSlider() {
        return sliderAnchors().get(1);
    }

    // Feature 7
    public WebElement facebookIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href='https://www.facebook.com/nopCommerce']"));
    }

    public WebElement twitterIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href='https://twitter.com/nopCommerce']"));
    }

    public WebElement rssIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href*='rss']"));
    }

    public WebElement youtubeIcon() {
        return Hooks.driver.findElement(By.cssSelector("a[href='https://www.youtube.com/user/nopCommerce']"));
    }

    // Wishlist
    public WebElement addToWishlistBtn() {
        return Hooks.driver.findElement(By.cssSelector("button[class='button-2 add-to-wishlist-button']"));
    }

    public WebElement successMessage() {
        return Hooks.driver.findElement(By.cssSelector("div.bar-notification.success"));
    }

    public WebElement wishlistTab() {
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }

    public WebElement wishlistQty() {
        return Hooks.driver.findElement(By.cssSelector("span.wishlist-qty"));
    }
}