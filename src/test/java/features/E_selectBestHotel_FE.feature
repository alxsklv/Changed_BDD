Feature: Hotel search and filters 

Scenario: User performs search using filters to find the best option  
Given User is on FE login page "https://www.phptravels.net/" and login
And User login into application with username "user@phptravels.com" and password "demouser"
And User selects Hotels tab

When User selects all necessary filters and city is "Singapore"

Then User hits Search button
And User sets star grade to two stars and click on Details
And User books cheapest Triple rooms option from the details page
And User fills in travellers data, payment method, accept terms and confirm booking


Scenario: User checks if the booked hotel has appeared in his Profile (this scenario will fail as last step of previous scenario always fails and no any hotel in Profile)
Given User is on FE login page "https://www.phptravels.net/" and login
And User login into application with username "user@phptravels.com" and password "demouser"
When User selects My Bookings tab
Then User see his booking in My Booking list