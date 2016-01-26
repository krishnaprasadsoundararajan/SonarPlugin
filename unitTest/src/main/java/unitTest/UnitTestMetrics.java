package unitTest;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

/**
 * Unit Test plugin metrics definition.
 *
 * @author krishna.soundararajan
 * @version 1.0
 */
public class UnitTestMetrics implements Metrics {

    public static final Metric TEST_CASES_PASSED =
        new Metric.Builder(
            "test_cases_passed",
            "Test Cases Passed by Unit Test",
            Metric.ValueType.STRING)
            .setDescription("Test Cases which are successful while running the unit tests")
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

    public static final Metric TEST_CASES_FAILED =
        new Metric.Builder(
            "test_cases_failed",
            "Test Cases Failed by Unit Test",
            Metric.ValueType.STRING)
            .setDescription("Test Cases which are not successful while running the unit tests")
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

	public static final Metric ASSERTIONS_PASSED =
        new Metric.Builder(
            "assertions_passed",
            "Assertions which are passed",
            Metric.ValueType.STRING)
            .setDescription("Assertions which are successful while running the unit tests")
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();
	
	public static final Metric ASSERTIONS_FAILED =
	        new Metric.Builder(
	            "assertions_failed",
	            "Assertions which are failed",
	            Metric.ValueType.STRING)
	            .setDescription("Assertions which are failed while running the unit tests")
	            .setDomain(CoreMetrics.DOMAIN_GENERAL)
	            .create();

	public static final Metric UNIT_TESTS_TOTAL =
        new Metric.Builder(
            "unit_tests_total",
            "Total Unit Tests",
            Metric.ValueType.STRING)
            .setDescription("Total unit tests")
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();

	public static final Metric TOTAL_ERRORS =
        new Metric.Builder(
            "total_errors",
            "Total errors in unit test",
            Metric.ValueType.STRING)
            .setDescription("Errors in unit test")
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .create();
     
	public static final Metric STATUS =
	        new Metric.Builder(
	            "is_success",
	            "Shows if success or failure",
	            Metric.ValueType.BOOL)
	            .setDescription("Success or Failue")
	            .setDomain(CoreMetrics.DOMAIN_GENERAL)
	            .create();
	
	public static final Metric LAST_BUILD =
	        new Metric.Builder(
	            "last_build",
	            "Link to last build",
	            Metric.ValueType.STRING)
	            .setDescription("Link to last build")
	            .setDomain(CoreMetrics.DOMAIN_GENERAL)
	            .create();
	
	public static final Metric LAST_SUCCESSFUL_BUILD =
	        new Metric.Builder(
	            "last_successful_build",
	            "Link to last build",
	            Metric.ValueType.STRING)
	            .setDescription("Link to last build")
	            .setDomain(CoreMetrics.DOMAIN_GENERAL)
	            .create();
	     
    /**
     * Default constructor.
     */
    public UnitTestMetrics() {
        super();
    }

    /**
     * Defines the plugin metrics.
     *
     * @return the list of this plugin metrics
     */
    public List<Metric> getMetrics() {
        return Arrays.asList(
            TEST_CASES_PASSED,
            TEST_CASES_FAILED,
            ASSERTIONS_PASSED,
            ASSERTIONS_FAILED,
            UNIT_TESTS_TOTAL,
            TOTAL_ERRORS,
            STATUS,
            LAST_BUILD,
            LAST_SUCCESSFUL_BUILD);
    }
}
