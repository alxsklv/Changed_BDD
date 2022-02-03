Feature: Login using different environments

Scenario Outline: User should not be able to log in to Supplier and CMS with FE credentials
Given User is on <url> login page
When User login into environment with username "user@phptravels.com" and password "demouser"
Then User receives error message "Invalid Login Credentials" 
And Stays on the page with the same URL <final_url>

Examples:
|url                                |final_url                             |  
|https://www.phptravels.net/admin   |https://phptravels.net/api/admin      |
|https://www.phptravels.net/supplier|https://phptravels.net/api/supplier   |


