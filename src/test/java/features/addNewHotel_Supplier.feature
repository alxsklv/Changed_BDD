Feature: Supplier Add Hotel feature

Scenario: Login to supplier and adding new MM hotel 
Given User is on login page of supplier "https://www.phptravels.net/supplier"
And User performs login to environment using valid user "supplier@phptravels.com" and password "demosupplier"
And User selects Add New Hotel section to add new MM hotel 

When BE User enters all hotel parameters for the new "Monks Palace" hotel and hits Save

Then New hotel gets populated with "Monks palace hotel was added" message
And The "Laundry service" option is absent in the list of facilities

