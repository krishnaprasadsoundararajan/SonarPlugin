package unitTest;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;

/**
 * Unit Test plugin widget definition.
 *
 * @author krishna.soundararajan
 * @version 1.0
 */
@UserRole(UserRole.USER)
@Description("Shows the unit test report overview generated from the unit tests which happen daily")
public class UnitTestDashboardWidget
    extends AbstractRubyTemplate
    implements RubyRailsWidget {

    /**
     * Default constructor.
     */
    public UnitTestDashboardWidget() {
        super();
    }

    /**
     * Returns the widget id.
     *
     * @return the widget id
     */
    public String getId() {
        return "unitTest";
    }

    /**
     * Returns the widget title.
     *
     * @return the widget title
     */
    public String getTitle() {
        return "UnitTest Results";
    }

    /**
     * Returns the path to the widget Ruby file.
     *
     * @return the path to the widget Ruby file
     */
    @Override
    protected String getTemplatePath() {
        String templatePath = "/unitTest/unittest_widget.html.erb";
        return templatePath;
    }
}
