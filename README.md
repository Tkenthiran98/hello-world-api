Hello World API

A Spring Boot REST API with a single endpoint that returns a greeting based on the first letter of a given name.


How to Run

Open the project in IntelliJ IDEA, then either:
Option 1 - IntelliJ IDEA:
Run HelloWorldApiApplication.java directly using the green play button

or

./mvnw spring-boot:run
App starts at http://localhost:8080


How to Test
Option 1 - IntelliJ IDEA:
Right-click the test folder → Run All Tests

or

./mvnw test

Endpoint
GET /hello-world?name={name}



Case                              Status                                               Response
CaseStatusResponseName         starts with A–M200                          OK{"message": "Hello Alice"}
Name starts with N–Z           400 Bad Request                               {"error": "Invalid Input"}
Name is missing or empty       400 Bad Request                               {"error": "Invalid Input"}


Assumptions

The check is case-insensitive — alice and ALICE are treated the same way
Names are always formatted with the first letter uppercase and the rest lowercase
Anything that doesn't start with a letter (numbers, special characters, blank spaces) is treated as invalid