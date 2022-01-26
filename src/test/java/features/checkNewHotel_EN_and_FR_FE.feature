Feature: Hotel search at FE

Scenario Outline: Check if the new hotel was added at FE for English and French localizations
Given User is on login page with url for corresponding localization <url>
And User login into application with username "user@phptravels.com" and password "demouser"
And User selects Hotels tab

When User enters tha name "Monks Palace" of the hotel to the search field 

Then User hits Search button
And See corresponding <message> for selected localization


Examples:
|url                           |message                |
|https://www.phptravels.net/en |Monks Palace is found  | 
|https://www.phptravels.net/fr |Monks Palace est trouvé|
