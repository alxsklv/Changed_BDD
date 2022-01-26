Feature: Profile check

Scenario: User can access the Profile Page 
Given User is on login page 
And User login into application with username "user@phptravels.com" and password "demouser"

When User has clicked on Profile button

Then Profile page is opened and its url is "https://www.phptravels.net/profile"
And Valid userdata is present on the page "user@phptravels.com" username and "Your Profile" title

 
