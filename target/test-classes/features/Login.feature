#Feature: Verify Login Functionality
#Scenario: Verify user is able to login with valid credentials
#Given the login page is open in the default browser
#When the user enters a valid username
#And the user enters a valid password
#And the user clicks the submit button
#Then the user should be logged in successfully
#And the user should be redirected to the login home page



#for multiple login
#Feature: Verify Login Functionality

 # Scenario Outline: Verify login page
#    Given the login page is open in the default browser
#    When the user enters username "<username1>"
#    And the user enters password "<password1>"
#    And the user clicks the submit button with status "<Status>"
 #   Then verify login result "<Status>"

 #   Examples:
 #     | username1 | password1 | Status  |
 #     | username  | password  | success |
  #    | adjak     | password  | fail    |
  #    | username  | jkahjbka  | fail    |
  #    | kjdakhdae | jkahjbka  | fail    |
  
  
  
#zero bank

#Feature: verify search functionality
#Scenario Outline: verify search buttons 
#Given login page should be open i default browser
#When click on username field and add valid user name
#And then click on password button and enter valid password
#And now click on submit button
#And go to search button and click add inputs <input>
#Then list of products
#Examples:
#|input|
#|account|
#|pay|
#|state|


#ninja cart

#Feature: Validate End To End Shopping Workflow

#Scenario: Verify customer can login, search product, add item to cart and checkout successfully

#Given login page should be open in default browser
#When click on email address field and add valid email "<email>"
#And then click on password field and enter valid "<password>"
#And now click on login button "<status>"
#Then login successfully and redirect to ninja home page

#And ninja search input field receives "<product>"
#Then ninja custom product list matches criteria

#And user clicks on add to cart button for the item
#Then product should be added to cart successfully

#And user clicks on the black shopping cart button
#And clicks on the checkout option
#Then user should be redirected to the checkout page

#Examples:
#| email                | password  | status  | product |
#| nk1711336@gmail.com | Nitesh123 | success | iphone  |



#using pom 

Feature: Validate End To End Shopping Workflow
@Smoke
Scenario Outline: Verify customer can login, search product, add item to cart and checkout successfully

Given login page should be open in default browser

When click on email address field and add valid email "<email>"

And then click on password field and enter valid "<password>"

And now click on login button "<status>"

Then login successfully and redirect to ninja home page

When ninja search input field receives "<product>"

Then ninja custom product list matches criteria

When user clicks on add to cart button for the item

Then product should be added to cart successfully

When user clicks on the black shopping cart button

And clicks on the checkout option

Then user should be redirected to the checkout page

Examples:
| email                | password  | status  | product |
| nk1711336@gmail.com | Nitesh123 | success | iphone  |