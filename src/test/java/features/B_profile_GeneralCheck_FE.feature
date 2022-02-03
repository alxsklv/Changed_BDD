Feature: Profile check

Scenario: User can access the Profile Page 
Given User is on FE login page "https://www.phptravels.net/" and login
And User login into application with username "user@phptravels.com" and password "demouser"

When User has clicked on Profile button

Then Profile page is opened and its url is "https://www.phptravels.net/account/profile"
And Valid userdata is present on the page "Demo" username and "Profile Information" title

 
