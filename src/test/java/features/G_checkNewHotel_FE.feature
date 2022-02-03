Feature: Hotel search at FE

Scenario Outline: Check if the new hotel was added at FE for English and German localizations

Given User is on FE login page "https://www.phptravels.net/" and login
And User login into application with username "user@phptravels.com" and password "demouser"
And User selects Hotels tab
And User sets language to <language>

When User selects all necessary filters and city is "Hilversum"
Then User hits Search button
And User fills in travellers data, payment method, accept terms and confirm booking

Examples:
|language|
|English |
|German  |