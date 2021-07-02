Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User closes cookies popup
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list button
    Then User checks that amount of products in wish list are <amountOfProducts>

    Examples:
      | homePage             | keyword  | amountOfProducts |

      | https://www.asos.com | skirt    | 1                |

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User closes cookies popup
    Then User checks header visibility
    And User checks footer visibility
    And User checks logo visibility
    And User checks search field visibility
    And User checks account icon visibility
    And User checks join button visibility
    And User checks sign in button visibility
    And User checks wish list icon visibility
    And User checks shopping bag icon visibility
    And User opens shopping bag
    And User checks that shopping bag title is visible

    Examples:
      | homePage             |
      | https://www.asos.com |

  Scenario Outline: Check add product to shopping bag
    Given User opens '<homePage>' page
    And User closes cookies popup
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User checks 'Size dropdown' visibility
    And User selects first size option
    And User clicks 'Add to Bag' button on product
    And User checks that add to bag dropdown is visible
    Then User checks that add to bag dropdown header is '<header>'

    Examples:
      | homePage             | keyword  | header |
      | https://www.asos.com | dress    | 1 item |


  Scenario Outline: Check shopping bag page functionality
    Given User opens '<homePage>' page
    And User closes cookies popup
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User checks 'Size dropdown' visibility
    And User selects first size option
    And User clicks 'Add to Bag' button on product
    And User checks that add to bag dropdown is visible
    And User checks dropdown 'View Bag' button visibility
    When User clicks dropdown 'View Bag' button
    Then User checks that product item is visible
    And User checks that shopping bag page title is '<title>'
    And User checks that checkout button is visible


    Examples:
      | homePage             | keyword  | title  |
      | https://www.asos.com | dress    | my bag |



  Scenario Outline: Check that checkout is accessible via mini bag dropdown
    Given User opens '<homePage>' page
    And User closes cookies popup
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User checks 'Size dropdown' visibility
    And User selects first size option
    And User clicks 'Add to Bag' button on product
    And User checks that add to bag dropdown is visible
    And User checks dropdown 'Checkout' button visibility
    When User clicks dropdown 'Checkout' button
    And User clicks 'Join' button
    Then User checks 'Continue to checkout' button is visible

    Examples:
      | homePage             | keyword  |
      | https://www.asos.com | dress    |

  Scenario Outline: Check product removal from the shopping bag
    Given User opens '<homePage>' page
    And User closes cookies popup
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And Product page is opened
    And User clicks 'Add to Bag' button on product
    And User checks that add to bag dropdown is visible
    And User clicks dropdown 'View Bag' button
    And User checks that product item is visible
    When User clicks 'Remove' button on the product
    Then User checks that title is visible
    And User checks that title is '<title>'


    Examples:
  | homePage             | keyword  | title             |
  | https://www.asos.com | bag      | your bag is empty |


  Scenario Outline: Check checkout page functionality
    Given User opens '<homePage>' page
    And User closes cookies popup
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And Product page is opened
    And User clicks 'Add to Bag' button on product
    And User checks that add to bag dropdown is visible
    And User clicks dropdown 'View Bag' button
    And Shopping bag page is opened
    And User clicks 'Checkout' button
    And User clicks 'Join' button
    And User checks 'Continue to checkout' button is visible
    Then User clicks 'Continue to checkout' button

    Examples:
      | homePage             | keyword  |
      | https://www.asos.com | bag      |


  Scenario Outline: Check login page functionality
    Given User opens '<loginPage>' page
    And User checks sign in header visibility
    And User checks join header visibility
    And User checks email field visibility
    And User checks password field visibility
    And User checks 'Sign in' button visibility
    When User clicks join button
    Then User checks email field visibility
    And User checks password field visibility
    And User checks first name field visibility
    And User checks last name field visibility
    And User checks password field visibility
    And User checks 'Join asos' button visibility

    Examples:
      | loginPage               | email                 |
      | https://my.asos.com     | asostest404@gmail.com |


  Scenario Outline: Check sign in with empty fields
    Given User opens '<loginPage>' page
    And User checks email field visibility
    And User checks password field visibility
    And User checks 'Sign in' button visibility
    When User clicks 'Sign in' button
    Then User checks warning above email field is '<message1>'
    And User checks warning above password field is '<message2>'


    Examples:
      | loginPage           | message1                               | message2                      |
      | https://my.asos.com | Oops! You need to type your email here | Hey, we need a password here  |

  Scenario Outline: Check sign in with Google
    Given User opens '<loginPage>' page
    And User checks Google button visibility
    When User clicks Google button
    Then User checks that continue button is visible
    And User checks that page url contains '<text>'


    Examples:
      | loginPage           | text               |
      | https://my.asos.com | accounts.google.com |

  Scenario Outline: Check sign in with valid credentials
    Given User opens '<loginPage>' page
    And User checks email field visibility
    And User checks password field visibility
    When User enters '<email>' to email field
    And User enters '<password>' to password field
    And User clicks 'Sign in' button
    And 'My account' page opens
    Then User checks that 'My account' page title is '<title>'
    And User checks that page url contains '<text>'


    Examples:
      | loginPage               | email                 | password   | title      | text       |
      | https://my.asos.com     | asostest404@gmail.com | 0123456789 | my account | my-account |