@smoke
Feature: F06_homeSliders | users could open sliders

  Scenario: first slider is clickable on home page
    Given user click on first slider
    Then user should be redirected to first slider page

  Scenario: second slider is clickable on home page
    Given user click on second slider
    Then user should be redirected to second slider page