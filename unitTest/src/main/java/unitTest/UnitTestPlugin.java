package unitTest;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.Extension;
import org.sonar.api.SonarPlugin;

/**
 * Unit Test Results plugin definition.
 *
 * @author krishna.soundararajan
 * @version 1.0
 */
public class UnitTestPlugin extends SonarPlugin {

    /**
     * Default constructor.
     */
    public UnitTestPlugin() {
        super();
    }

    /**
     * Defines the plugin extensions: metrics, sensor and dashboard widget.
     *
     * @return the list of extensions for this plugin
     */
    public List<Class<? extends Extension>> getExtensions() {
        return Arrays.asList(
            UnitTestMetrics.class,
            UnitTestSensor.class,
            UnitTestDashboardWidget.class);
    }
}
