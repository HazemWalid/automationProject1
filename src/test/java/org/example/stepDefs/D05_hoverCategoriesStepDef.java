package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {

    P03_homePage homePage = new P03_homePage();
    String selectedName;
    int selectedCategoryIndex;

    @Given("user hover on random category")
    public void hoverRandomCategory() {
        Hooks.driver.get("https://demo.nopcommerce.com/");

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul[@class='top-menu notmobile']/li/a")
        ));

        List<WebElement> categories = homePage.mainCategories();
        Assert.assertTrue(categories.size() >= 3, "Main categories were not found");

        selectedCategoryIndex = new Random().nextInt(3);
        WebElement target = categories.get(selectedCategoryIndex);

        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(target).perform();
    }

    @When("user select random sub-category")
    public void selectRandomSubCategory() {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        List<WebElement> subCategories = homePage.subCategories(selectedCategoryIndex);

        if (!subCategories.isEmpty()) {
            int randomSubCategory = new Random().nextInt(subCategories.size());
            WebElement chosenSubCategory = subCategories.get(randomSubCategory);

            selectedName = chosenSubCategory.getText().toLowerCase().trim();
            chosenSubCategory.click();
        } else {
            WebElement mainCategory = homePage.mainCategories().get(selectedCategoryIndex);

            selectedName = mainCategory.getText().toLowerCase().trim();
            mainCategory.click();
        }

        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("sub-category page should be opened successfully")
    public void verifyTitle() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.pageTitle()));

        String actualTitle = homePage.pageTitle().getText().toLowerCase().trim();

        Assert.assertTrue(
                actualTitle.contains(selectedName),
                "Expected title to contain: " + selectedName + " but found: " + actualTitle
        );
    }
}