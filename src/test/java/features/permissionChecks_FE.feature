Feature: permission to different Sections

Scenario Outline: User should have permission to About and Hotels section but Membership section is blocked
Given User is on login page 
And User login into application with username "user@phptravels.com" and password "demouser"
When User selects <tabName> from navigation bar
Then Page becomes available with <tabName> title on it except for Membership

Examples:
|tabName   |
|About     |
|Hotels    |
|Membership|