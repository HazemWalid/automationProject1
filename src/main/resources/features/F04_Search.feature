@smoke
Feature: F04_Search | users could search for products

  Scenario Outline: user could search using product name
    Given user go to home page
    When user search for "<productName>"
    Then search results should be displayed

    Examples:
      | productName |
      | book        |
      | laptop      |
      | nike        |

  Scenario Outline: user could search for product using sku
    Given user go to home page
    When user search for "<sku>"
    And user click on product in search result
    Then user should see correct sku "<sku>"

    Examples:
      | sku         |
      | SCI_FAITH   |
      | APPLE_CAM   |
      | SF_PRO_11   |