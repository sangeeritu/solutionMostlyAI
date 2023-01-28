# Mostly AI Test Assignment solution

Automation for https://mostly.ai/ test assignment. This project uses the page object model (POM) design. 

## Stack & Libraries
- Java
- Selenium WebDriver
- TestNG 
- Maven
- Extent Reports and logging

## Prerequisites
- IDE (Intellij)
- JDK 
- Maven configuration

## How to run tests
1. Clone the repository from the branch
2. Run the TestNG.xml file in intellij OR
3. Run mvn test in Intellj / terminal
4. Report can be found inside the report folder 

## Best practices
1. Uses Page object model
2. Use Reusable Request
3. Uses test data from json file
4. Failure screenshots can be found in screenshot folder
5. The Project is CI/CD friendly. Jobs can be scheduled using the TestNG XML file
6. Report are generated and stored in report folder with the test suite name

## Components
1.Page objects are in the directory src/main/java/pages
2.Test classes are in the directory src/test/java/tests
3.Listener class is in the directory src/main/java/util
4.Test data is defined in TestData.json file

## Future improvement
1. Report can be made even more explanatory
2. Multiple browser support using Factory design

