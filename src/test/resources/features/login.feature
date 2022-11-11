Feature: Login Feature
  Check if login Feature is working
  
  Background:
  	Given we are in login page

  @smoke
  Scenario: Check Valid Login
    When we enter usermane standard_user and password secret_sauce
    And click login button
    Then we get redirected to inventory page
    
  @smoke
  Scenario: Check Login with Invalid Credentials
  	When we enter usermane standard_user and password secret_sauce1
  	And click login button
  	Then error message appeares
  	
  @regration
  Scenario Outline: Check multiple logins
  	When we enter usermane <Username> and password <Password>
  	And click login button
    Then we get redirected to inventory page
    
    Examples:
    	|Username|Password|
    	|standard_user|secret_sauce|
			|locked_out_user|secret_sauce|
			|problem_user|secret_sauce|
			|performance_glitch_user|secret_sauce|