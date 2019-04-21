package com.automationcalling.stepdefinition;

import com.automationcalling.javaUtil.PropsLoader;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.automationcalling.JMeterUtil.JMeterEngineUtil.*;
import static com.automationcalling.globalconfig.Constant.*;
import static com.automationcalling.xmlutil.XMLReaderWriter.updateElementText;

public class PerformanceStepDefinition {
    private static HeaderManager headerManager;
    private static final Logger LOG = Logger.getLogger(PerformanceStepDefinition.class.getName());
    public static PropsLoader proploader;

    static {
        loadJMeterconfig();
        headerManager = setHeaderManager();
        proploader = new PropsLoader();
        proploader.loadProperty(performanceConfig);
    }

    @Given("^user supply the following values for ThreadGroup$")
    public void user_supply_the_following_values_for_ThreadGroup(DataTable threadGroup) throws Throwable {
        List<Map<String, String>> threadList = threadGroup.asMaps(String.class, String.class);
        headerManager.add(new Header("Content-Type", proploader.prop.getProperty(threadList.get(0).get("AcceptType"))));
        headerManager.add(new Header("Accept", proploader.prop.getProperty(threadList.get(0).get("ContentType"))));
        headerManager.add(new Header("Authorization", proploader.prop.getProperty("Authorization")));
        setLoopController(Integer.parseInt(threadList.get(0).get("LoopController")));
        setThreadGroup(Integer.parseInt(threadList.get(0).get("NoOfThreads")), Integer.parseInt(threadList.get(0).get("RampupTime")));
    }

    @When("^user supply request type \"([^\"]*)\" and path \"([^\"]*)\"$")
    public void user_supply_request_type_and_path(String requestType, String setPath) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        setHttpSampler("https", proploader.prop.getProperty("environment"), setPath, requestType);
    }

    @Then("^Initialize \"([^\"]*)\" Test Plan and performance test executed store the results \"([^\"]*)\"$")
    public void initialize_Test_Plan_and_performance_test_executed_store_the_results(String testPlanName, String reportName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initializeTestPlan(testPlanName);
        configureTestPlan();
        generateReport(reportName);
    }

    @Given("^user updates the following values in the given \"([^\"]*)\" JMX file$")
    public void user_updates_the_following_values_in_the_given_JMX_file(String fileName, DataTable threadGroup) throws Throwable {
        List<Map<String, String>> threadList = threadGroup.asMaps(String.class, String.class);
        if (threadList.get(0).get("LoopController").length() != 0)
            updateElementText(loop,
                    jmxFILEPath + fileName, 0, threadList.get(0).get("LoopController"));
        if (threadList.get(0).get("RampupTime").length() != 0)
            updateElementText(Rampup,
                    jmxFILEPath + fileName, 0, threadList.get(0).get("RampupTime"));
        if (threadList.get(0).get("RampupTime").length() != 0)
            updateElementText(threads,
                    jmxFILEPath + fileName, 0, threadList.get(0).get("NoOfThreads"));

    }

    @Then("^user execute a performance test by supplying JMX file \"([^\"]*)\" and generate report \"([^\"]*)\"$")
    public void user_execute_a_performance_test_by_supplying_JMX_file_and_generate_report(String fileName, String reportName) throws Throwable {
        executeTestWithJMXFile(reportName, jmxFILEPath + fileName);
    }
}
