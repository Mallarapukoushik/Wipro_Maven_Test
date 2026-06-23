Feature: Login to jpet store
 
Scenario Outline: login with valid credentials
 
Given User is on JpetStore Login page
When User enters username "<username>" password "<password>"
Then user should be logged in and see greeting for user "<username>"
When User checkout Amazon Parrot in the Birds category link
 
 
Examples:
 
| username | password |
| j2ee     | j2ee     |
| Admin    | admin123 |