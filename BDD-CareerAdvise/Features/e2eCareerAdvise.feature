Feature: e2e test for Career Advise-ezway2connect

  Scenario: End-to-End test
    Given the user enters into the website
    And the user hits book-now
    When the user clicks any date and picks time
    Then the user should be able to fillup the payment form
