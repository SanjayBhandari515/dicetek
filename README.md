DicetekTest
Scenarios Automated:

Scenario 1: To pick the API link from config file
Deliverables:
● Structure of the framework – using RestAssured
● Code to retrieve the API link from config file
● Separate test case file
● Test case report in HTML file
Requirements
URL: http://dummy.restapiexample.com/api/v1/employees
All the data related to employees is present, Place a GET call to retrieve the data of the employees
with the below assertion in the test case response file:
● Assertion to verify 200 OK
● Assertion to verify profile_image is blank for all the employees

Scenario 2: To pick the Request Data from external file
Deliverables:
● Code to fetch employee from an excel or CSV (GET Request)
● Separate test case file
● Test case report in HTML file
Requirements
URL: http://dummy.restapiexample.com/api/v1/employee/2
Steps:
1) Fetch a single employee record using excel or CSV as external file
o /employee/{id} – ID should be picked from the external file
● Assertion to verify 200 OK from the response
● Assertion to verify the response body pattern
● Assertion to verify message in the response “Successfully! Record has been fetched.”


Programming Language and Automation Tools

●Programming Language:Java
●Build Tool: Maven
●rest-assured 4.0.0
●TestNG:6.14.3
●Extent-Report:3.1.5
●IDE: IntelliJ IDEA 2020.2

Folder Structure Overview
The major components of this projects are:

●src/main/java/axiom/framework: Contains common methods for Get, Put, Post etc also Pojo classes.
●src/main/java/axiom/pages: Containing all the pages
●src/main/java/axiom/utils: Containing all the utilities like reporting tool, retry mechanism, configfile setup.
●src/test/java/axiom/test: Contains all the tests
●TestNG: from here we can execute our tests
●TestReport: Contains generated html report

![alt text](http://url/to/file://C:/Users/Himanshu/Desktop/Automation%20Report.PNG)
