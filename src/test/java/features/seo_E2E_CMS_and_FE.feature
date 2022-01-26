Feature: Setting SEO tags in CMS and check at FE

Scenario: Admin continues with Monks Super Palace hotel to modify SEO section in CMS
Given User is on login page of CMS environment "https://www.phptravels.net/admin"
And User performs login to CMS using valid user "admin@phptravels.com" and password "demoadmin"
And Admin selects Hotel section
And Selects "Monks Super Palace" hotel from the list
And Goes to SEO tab by clicking on it
And Add some tags using dropdown 
When Admin hits Save button 
Then The "New tags were populated" pop-up message is shown

Scenario: User checks SEO tags at FE for updated hotel to make sure that they were added
Given User is on login page 
And User login into application with username "user@phptravels.com" and password "demouser"
And User selects Hotels tab
And User enters tha name "Monks Super Palace" of the hotel to the search field 
When User hits Search button
Then List of tags for found hotel is extracted and compared against the list from CMS


Scenario: Teardown - Admin removes "Monks Super Palace" using CMS 
Given User is on login page of CMS environment "https://www.phptravels.net/admin"
And User performs login to CMS using valid user "admin@phptravels.com" and password "demoadmin"
And Admin selects Hotel section
And Selects "Monks Super Palace" hotel from the list
When Admin clicks on Delete button
Then The "Hotel is removed" popup is shown 
