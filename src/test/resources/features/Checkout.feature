Feature: Checkout

  @checkout @smoke
  Scenario: Successful checkout
    Given I have added a product to cart
    When I go to cart
    And I click checkout
    And I enter address "Delhi"
    And I select payment method "Card"
    And I confirm order
    Then the order should be placed successfully

  @checkout @negative
  Scenario: Payment failure
    Given I have added a product to cart
    When I go to cart
    And I click checkout
    And I enter address "Delhi"
    And I select payment method "Card"
    And I enter invalid card details
    And I confirm order
    Then the payment should fail with error
