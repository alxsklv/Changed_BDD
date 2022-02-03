Feature: Profile modification

Scenario: User can modify his Profile and save provided changes 
Given User is on FE login page "https://www.phptravels.net/" and login
And User login into application with username "user@phptravels.com" and password "demouser"
And User has clicked on Profile button

When User click on Edit and enter new values to username "alex" and phone "987654321" fileds and click Update

Then corresponding fields get new "alex" and "987654321" values
And "Profile updated successfully." message is shown to user
