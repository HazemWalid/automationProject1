package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {

    P03_homePage home = new P03_homePage();

    WebElement selectedMain;
    String selectedSubText;

    @When("user hover on random category")
    public void hoverRandomCategory() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

        // ✅ WAIT using SAME locator from Page Object
        List<WebElement> categories = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.cssSelector("ul.top-menu.notmobile > li > a"), 0
                )
        );

        System.out.println("Categories size = " + categories.size());

        Random random = new Random();
        WebElement selectedCategory = categories.get(random.nextInt(categories.size()));

        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(selectedCategory).perform();

        // ✅ NOW get subcategories from SAME element
        List<WebElement> subCategories = home.subCategories(selectedCategory);

        if (subCategories.size() > 0) {
            subCategories.get(0).click();
        } else {
            Assert.fail("No subcategories found");
        }
    }

    @When("user select random sub-category")
    public void selectSubCategory() {
        List<WebElement> subs = home.subCategories(selectedMain);

        if (subs.isEmpty()) {
            Assert.fail("No sub-categories found for the selected main category.");
        }

        Random rand = new Random();
        int index = rand.nextInt(subs.size()); // Dynamically handle the list size

        WebElement sub = subs.get(index);

        selectedSubText = sub.getText().toLowerCase().trim();

        sub.click();
    }

    @Then("sub-category page should be opened successfully")
    public void verifySubCategoryPage() {
        WebElement pageTitleElement = home.pageTitle();
        Assert.assertNotNull(pageTitleElement, "Page title is not displayed on the sub-category page.");

        String pageTitle = pageTitleElement.getText().toLowerCase().trim();

        Assert.assertTrue(pageTitle.contains(selectedSubText),
                String.format("Expected page title to contain '%s', but was '%s'", selectedSubText, pageTitle));
    }
}