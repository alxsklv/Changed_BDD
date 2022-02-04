Feature: CMS Page Update

Scenario Outline: User updates CMS page successfully
Given User is on <url> login page
And User login into environment with username "admin@phptravels.com" and password "demoadmin"
When User navigates on CMS > Pages page
Then User clicks Edit button on first page in list
And User sets page title to "Test Title"
And User sets permalink to "cookies-policy"
And User sets description to "Test description"
And User sets SEO keywords to "test_seo_keyword"
And User sets SEO description to "Test SEO description"
And Update button is clicked


      
Examples:
|url                              |
|https://www.phptravels.net/admin |

Scenario Outline: User checks the changed page at FE
Given User is on <module_url> login page
When Page is loaded
Then User can see "Test Title", "Test description" on page
And SEO keyword "test_seo_keyword" and SEO description "Test SEO description" are presented on page

Examples:
|module_url                               |
|https://www.phptravels.net/cookies-policy|