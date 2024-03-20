#Automation Challenge Framework
Selenium Framework challenge using Java, maven, TestNG, and POM 

#Tech Stach
-IntelliJ IDEA 
-Java
-Maven
-TestNG
-DDT

It is an implementation for the Challenge test Scenario.
1)  Open https://www.bing.com

2)  Type and search for “Vodafone”

3)  Scroll down and go to the next page

4)  Count the number of results displayed on the second page (ignore any maps, videos, or images. Just count the normal search results, they are usually around 10 displayed.)

5)  Scroll down and go to the next page

6)  Validate if the number of results on page 2 is equal to page 3 or not

7)  Close the browser window
   
The Project is build using POM design pattern consisted of the following packages 

1-Pages: where i have setup: 
-Pagebase Class where driver are initialized using PageFactory and common actions are stated.
-p1, p2 and p3 Classes where find elements and action methods are applied 

2-Test: Where i have setup: 
-TestBase Class where driver is Setup along with quit driver method, Taking ScreenShots on Failures
-TestPages where test case are utilizing data provided by DDT framework reading data from searchvalue.xlsx and are run using TestNG framework

3-Data package contains:
-searchValue.xlsx,TestData where data are stated
-ValueReader Class to read excel data.

4-Utility package contains Helper Class that its function is to take screenshots on failure events

5-ParallelTest Package to run the test using Selenium Grid

7-Allure-TestNG Report Package where test reports exist

8-Screenshots package contain all failure occurred while running the test

-testNG.xml to run the project through xml file

-testngParallelTesting.xml to run the Parallel test 

-pom.xml where all the dependencies are setup.
