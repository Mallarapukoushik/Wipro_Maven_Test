Feature: Login to OrangeHRMS application

@smoke
Scenario Outline: login with credentials
  Given User is on HRMSLogin page
  When User enters username as "<username>" and "<password>"
  Then user login validation should be "<result>"
  Then  User logs out
  Then  Close browser

Examples:
| username | password  | result |
| Admin    | admin123  | pass   |
| admin    | admin333  | fail   |
