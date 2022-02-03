Feature: Application Login 

Scenario: User successfully logs to the website and see his name near Profile
	Given User is on FE login page "https://www.phptravels.net/" and login
	And User login into application with username "user@phptravels.com" and password "demouser"
	When Home page with proper "https://www.phptravels.net/account/dashboard" url is populated 
	Then Username "Demo" is displayed at the Landing Page near the Profile section
