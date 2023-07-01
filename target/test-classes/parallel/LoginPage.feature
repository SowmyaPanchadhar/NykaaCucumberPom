@tag
Feature: Login functionality for opensource HRMS application
As a user of HRMS application
I should be able to login to application with my credentials
so that i can access my account

Background:
	Given I am on HRMS login page

  @Test1
  Scenario: Successful login with valid username and password
    Given I have entered valid "Admin" and "admin123"
    When I click on login
    Then I should be logged in succesfully	
    And I should be redirected to homepage
    
    @Test2
  Scenario Outline: unsuccesful login with invalid credentials
    Given I have entered invalid  "<username>" or "<password>" 
    When I click on login button
    Then I should see an error message "<error_message>" 

    Examples: 
      | username  			| password 				| error_message  												|
      | Admin			 			| invalidpassword | Invalid credentials |
      | invalidusername | Admin123			 	| Invalid credentails |
      | 								|	Admin@123		| Required |
      | admin						| 						|	Required |
    
    
    @Test3
  	Scenario: Navigate to forgot password page when clicked on Forgot password link
  		When I click on forgot passowrd link
  		Then I should be navigated to forgot password page to reset credentails
      