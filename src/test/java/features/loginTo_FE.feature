Feature: Application Login 

Scenario: User successfully logs to the website and see his name near Profile
Given User is on FE login page 
When User login into application with username "user@phptravels.com" and password "demouser"
Then Home page with proper "https://www.phptravels.net/homepage" url is populated 
And Entered username "user@phptravels.com" is displayed at the Landing Page near the Profile section