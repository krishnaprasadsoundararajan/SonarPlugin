package unitTest.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author krishna.soundararajan
 * @version 1.0
 */

public class TestReport {

	    private String testCasesPassed;
	    private String testCasesFailed;
	    private String assertionsPassed;
	    private String assertionsFailed;
	    private String totalTest;
	    private String totalError;
	    private String lastBuild;
	    private String lastSuccessfulBuild;

	    /**
	     * Default constructor.
	     */
	    public TestReport() {

	        super();

	        this.setAssertionsPassed("0");
	        this.setAssertionsFailed("0");
	        this.setTestCasesFailed("0");
	        this.setTestCasesPassed("0");
	        this.setTotalTest("0");
	        this.setTotalError("0");
	       
	    }

		public String getTestCasesPassed() {
			return testCasesPassed;
		}

		public void setTestCasesPassed(String testCasesPassed) {
			this.testCasesPassed = testCasesPassed;
		}

		public String getTestCasesFailed() {
			return testCasesFailed;
		}

		public void setTestCasesFailed(String testCasesFailed) {
			this.testCasesFailed = testCasesFailed;
		}
       
		public String getAssertionsPassed() {
			return assertionsPassed;
		}

		public void setAssertionsPassed(String assertionsPassed) {
			this.assertionsPassed = assertionsPassed;
		}
		
		public String getAssertionsFailed() {
			return assertionsFailed;
		}

		public void setAssertionsFailed(String assertionsFailed) {
			this.assertionsFailed = assertionsFailed;
		}
		
		public String getTotalTest() {
			return totalTest;
		}

		public void setTotalTest(String totalTest) {
			this.totalTest = totalTest;
		}

		public String getTotalError() {
			return totalError;
		}

		public void setTotalError(String totalError) {
			this.totalError = totalError;
		}

		public String getLastBuild() {
			return lastBuild;
		}

		public void setLastBuild(String lastBuild) {
			this.lastBuild = lastBuild;
		}

		public String getLastSuccessfulBuild() {
			return lastSuccessfulBuild;
		}

		public void setLastSuccessfulBuild(String lastSuccessfulBuild) {
			this.lastSuccessfulBuild = lastSuccessfulBuild;
		}

	}

