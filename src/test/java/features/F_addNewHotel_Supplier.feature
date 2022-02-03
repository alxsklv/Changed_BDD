Feature: Supplier Add Hotel feature

Scenario Outline: Login to supplier and adding new MM hotel 

Given User is on <url> login page
And User login into environment with username "supplier@phptravels.com" and password "demosupplier"
And User selects Manage Hotels subsection of Hotels section
And User clicks on Add button to start with the creation of new Hotel

And Admin fills all parameters <hotel_name> <description> <price>  for General Tab
And Checks all parameters of Amenties tab except for "laundry service"
And Enters <german_description> for Translate Tab

When Admin hits submit button

Then New hotel with the <hotel_name> appears in the list of Hotels


Examples:
|url                                |hotel_name  |description             |price|german_description         |     
|https://www.phptravels.net/supplier|Monks palace|It is an absolute dream |1000 |Es ist ein absoluter Traum |





