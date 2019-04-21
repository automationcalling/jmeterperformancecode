package usingJavaCode;

import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.automationcalling.JMeterUtil.JMeterEngineUtil.*;

public class BasicTestUsingJava {
    private static HeaderManager headerManager;
    private static final Logger LOG = Logger.getLogger(BasicTestUsingJava.class.getName());

    @Test
    public void simpleHTTPTest() {
        try {
            loadJMeterconfig();
            headerManager = setHeaderManager();
            headerManager.add(new Header("Content-Type", "application/json"));
            headerManager.add(new Header("Accept", "application/json"));
            setHttpSampler("https", "reqres.in", "/api/users?page=2", "GET");
            setLoopController(2);
            setThreadGroup(10, 5);
            initializeTestPlan("Simple HTTP Test Run using Java API");
            configureTestPlan();
            //saveTestPlan("src/main/resources/", "jmxfiles/simplehttptest.jmx");
            generateReport("SimpleHTTPRESTAPIReport");
            System.exit(0);
        } catch (Exception e) {
            LOG.severe(e.getMessage());
            System.exit(1);
        }
    }
}
