Feature: This example is about how to run simple REST API test using Java API for JMX and pure Java code

  Scenario: To run performance test for simple REST API with pure java code.
    Given user supply the following values for ThreadGroup
      | NoOfThreads | RampupTime | LoopController | AcceptType             |ContentType|
      | 10           | 5          | 2             | header.acceptType_json |header.Content-Type_json|
    When user supply request type "GET" and path "/api/users?page=2"
    Then Initialize "Simple HTTP Test" Test Plan and performance test executed store the results "BDD_Performance_Report"

  Scenario: To run performance test for specific preconfigured JMX file
    Given user updates the following values in the given "HTTP_Non_GUI_Mode.jmx" JMX file
      | NoOfThreads | RampupTime | LoopController |
      | 10           | 5          | 5             |
    Then user execute a performance test by supplying JMX file "HTTP_Non_GUI_Mode.jmx" and generate report "JMX_Test_Results"

