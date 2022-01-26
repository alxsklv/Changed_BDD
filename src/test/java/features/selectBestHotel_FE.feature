Feature: Hotel search and filters 

Scenario: User performs search using filters to find the best option  
Given User is on login page 
And User login into application with username "user@phptravels.com" and password "demouser"
And User selects Hotels tab

When User selects all necessary filters

Then User hits Search button
And Purchase a hotel from search results 
And User has clicked on Profile button
And Checks the profile to see that the hotel is booked 
