
# Polovni Automobili Selenium testing using Cucumber and Data Driven Testing

This is a project which I have done to solidify my Selenium testing framework skill. The goal of the project was to automate [Polovni automobili](https://polovniautomobili.com) website. Tests are written using Selenium framework and Java programming language. As a testing framework I have used TestNG, as well as Cucumber testing framework, using Gherkin language, according to the principle of Behavior Driven Testing. Tests are organized on the basis of POM (Page Object Model). Excel file with test data is used to feed data into the tests in accordance to the principle of Data Driven Testing.

Selenium version 4.17.0 was used for testing. As a reporting tool I have used Allure. Project build tool that I have used to streamline project file organization is Maven. Main browser used for running tests was Google Chrome version 126. Tests also work on Microsoft Edge and Mozilla Firefox browsers.

All the dependencies are placed im **pom.xml** file. Just click on the option Load Maven changes when you first open the project, and the dependencies should be loaded and indexed.

To use Allure reporting, open the terminal and enter command **allure serve** and the HTML file with report will be generated. 
