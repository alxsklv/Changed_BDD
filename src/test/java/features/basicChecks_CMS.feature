Feature: CMS basic features and functinality 

Scenario: Login in CMS and checking Add User function
Given User is on login page of CMS environment "https://www.phptravels.net/admin"
And User performs login to CMS using valid user "admin@phptravels.com" and password "demoadmin"
And Admin selects User section
And Click on Add New User button
And All fields userName "Alex" userPassword "test123" userEmail "alex@test.com" birthday "13-03-1993" are filled with data
When Admin hits Save button to populate new user
Then Checks that the new User was added to the list of users by checking userName "Alex" and userEmail "alex@test.com" values 

Scenario: Admin removes created user 
Given User is on login page of CMS environment "https://www.phptravels.net/admin"
And User performs login to CMS using valid user "admin@phptravels.com" and password "demoadmin"
And Admin selects User section
And Admin selects user "Alex" by clicking on his name 
When Remove button is clicked
Then The "User Alex is removed" pop up is shown

Scenario: Admin check hotels section and edit some fields of Monks palace hotel
Given User is on login page of CMS environment "https://www.phptravels.net/admin"
And User performs login to CMS using valid user "admin@phptravels.com" and password "demoadmin"
And Admin selects Hotel section
And Selects "Monks palace" hotel from the list 
And Changes the name of the hotel to "Monks Super Palace"
And Clear facilites field and add "Laundry service" facility only
When Admin hits Save button to save modifications
Then New values "Monks Super Palace" and "Laundry service" are populated to corresponding fields
