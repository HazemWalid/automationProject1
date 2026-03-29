@smoke
Feature: F04_wishlist | users could add products to wishlist

  Scenario: user could add product to wishlist
    Given user add product to wishlist
    Then success message is displayed with green color

  Scenario: user could see wishlist quantity
    Given user add product to wishlist
    When user open wishlist page
    Then wishlist quantity should be greater than 0