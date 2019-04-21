# jmeterperformancecode

To play with this framework, done with two types of implementation
1) Generic Format Implementation (Configure and Execute JMeter Test Plan using Java Code)
2) Cucumber BDD way of Implementation

#Generic Format Implementation
src->main->java->com->automationcalling->JMeterUtil->JMeterEngineUtil has full feature of utility code
src->test->usingJavaCode->TestNG Execution

#Cucumber BDD Way of Implementation
src->main->java->com->automationcalling->JMeterUtil->JMeterEngineUtil has full feature of utility code

  For Step Definition:
  src->main->java->com->automationcalling->stepdefinition->performancestepdefinition
  
  Feature File:
  src->main->resources->features->Simple_HTTP_Rest_request.feature

#To Run directly JMX file using Maven Plugin
src->test->jmeter->jmetereg->jmx file exist
supply the following commands to run the test
mvn clean verify -Dusers=10 -Drampup=5 -Dloop=2 -DjMeterTestFile=jmetereg/HTTP_Non_GUI_Mode_Runtime.jmx

