package org.example.stepDefs;

import io.cucumber.java.en.*;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {

    P03_homePage home = new P03_homePage();

    WebElement selectedMain;
    String selectedSubText;

    @Given("user hover on random category")
    public void hoverRandomCategory() {

        List<WebElement> categories = home.mainCategories();

        Random rand = new Random();
        int index = rand.nextInt(3); // only first 3 have subcategories

        selectedMain = categories.get(index);

        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(selectedMain).perform();
    }

    @When("user select random sub-category")
    public void selectSubCategory() {

        List<WebElement> subs = home.subCategories(selectedMain);

        Random rand = new Random();
        int index = rand.nextInt(subs.size());

        WebElement sub = subs.get(index);

        selectedSubText = sub.getText().toLowerCase().trim();

        sub.click();
    }

    @Then("sub-category page should be opened successfully")
    public void verifySubCategoryPage() {

        String pageTitle = home.pageTitle().getText().toLowerCase().trim();

        Assert.assertTrue(pageTitle.contains(selectedSubText));
    }
}