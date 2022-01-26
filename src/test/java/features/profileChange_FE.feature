Feature: Profile modification

Scenario: User can modify his Profile and save provided changes 
Given User is on login page 
And User login into application with username "user@phptravels.com" and password "demouser"
And User has clicked on Profile button

When User click on Edit and enter new values to username "alex" and email "alex@travel.com" fileds and click Update

Then corresponding fields get new "alex" and "alex@travel.com" values
And "Changes are populated" message is shown to user
