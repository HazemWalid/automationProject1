@smoke
Feature: F07_followUs | users could open follow us links

  Scenario: user opens facebook link
    Given user opens facebook link
    Then facebook page should be opened

  Scenario: user opens twitter link
    Given user opens twitter link
    Then twitter page should be opened

  Scenario: user opens rss link
    Given user opens rss link
    Then rss page should be opened

  Scenario: user opens youtube link
    Given user opens youtube link
    Then youtube page should be opened