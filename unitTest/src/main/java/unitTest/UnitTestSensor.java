package unitTest;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

import unitTest.analyzers.AnalyzerException;
import unitTest.analyzers.TestReportAnalyzer;
import unitTest.model.TestReport;


/**
 * Unit Test plugin sensor. It analyses report and path xml files
 * and extracts relevant information.
 *
 * @author krishna.soundararajan
 * @version 1.0
 */
public class UnitTestSensor implements Sensor {

    /**
     * The file system object for the project being analysed.
     */
    private final FileSystem fileSystem;

    /**
     * The logger object for the sensor.
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Constructor that sets the file system object for the
     * project being analysed.
     *
     * @param fileSystem the project file system
     */
    public UnitTestSensor(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Determines whether the sensor should run or not for the given project.
     *
     * @param project the project being analysed
     * @return always true
     */
    public boolean shouldExecuteOnProject(Project project) {
        // this sensor is executed on any type of project
        return true;
    }

    /**
     * Analyses project directory in search for IDE metadata configuration files
     * and extracts relevant information.
     *
     * @param project       the project being analysed
     * @param sensorContext the sensor context
     */
    public void analyse(Project project, SensorContext sensorContext) {

        File rootDir = fileSystem.baseDir();

        log.info("Analysing project root in search for IDE Metadata files: " + rootDir.getAbsolutePath());

        TestReportAnalyzer analyzer = new TestReportAnalyzer(rootDir);
        TestReport testReport;

        try {
            testReport = analyzer.analyze();

            log.info("Analysis done");
            log.debug("this is what we've found: " + testReport);

            saveMainInfo(sensorContext, testReport);

        } catch (AnalyzerException ae) {
            log.error("Error while running EclipseAnalyzer", ae);
        }
    }

    /**
     * Saves measures corresponding to main project information.
     *
     * @param sensorContext the sensor context
     * @param testReport   the project information bean
     */
    private void saveMainInfo(SensorContext sensorContext, TestReport testReport) {

        log.debug("Saving measures for unit Test Results");

        Measure measure;

        measure = new Measure(UnitTestMetrics.TEST_CASES_PASSED, testReport.getTestCasesPassed());
        sensorContext.saveMeasure(measure);
       
        measure = new Measure(UnitTestMetrics.TEST_CASES_FAILED, testReport.getTestCasesFailed());
        sensorContext.saveMeasure(measure);
        
        measure = new Measure(UnitTestMetrics.ASSERTIONS_PASSED, testReport.getAssertionsPassed());
        sensorContext.saveMeasure(measure);
        
        measure = new Measure(UnitTestMetrics.ASSERTIONS_FAILED, testReport.getAssertionsFailed());
        sensorContext.saveMeasure(measure);
		
		measure = new Measure(UnitTestMetrics.UNIT_TESTS_TOTAL, testReport.getTotalTest());
        sensorContext.saveMeasure(measure);

        measure = new Measure(UnitTestMetrics.TOTAL_ERRORS, testReport.getTotalError());
        sensorContext.saveMeasure(measure);
        
        Boolean isFailure = (Integer.parseInt(testReport.getTestCasesFailed()) > 0) || (Integer.parseInt(testReport.getTotalError()) > 0) || (Integer.parseInt(testReport.getAssertionsFailed()) > 0);
        
        measure = new Measure(UnitTestMetrics.STATUS, isFailure ? 0d : 1d );
        sensorContext.saveMeasure(measure);
        
        measure = new Measure(UnitTestMetrics.LAST_BUILD, testReport.getLastBuild());
        sensorContext.saveMeasure(measure);
        
        measure = new Measure(UnitTestMetrics.LAST_SUCCESSFUL_BUILD, testReport.getLastSuccessfulBuild());
        sensorContext.saveMeasure(measure);
        
        log.debug("Measures are saved successfully");
    }



    /**
     * Returns the name of the sensor as it will be used in logs during analysis.
     *
     * @return the name of the sensor
     */
    public String toString() {
        return "UnitTestSensor";
    }
}
