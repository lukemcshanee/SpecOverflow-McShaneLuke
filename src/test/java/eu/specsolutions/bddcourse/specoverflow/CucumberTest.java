package eu.specsolutions.bddcourse.specoverflow;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("eu/specsolutions/bddcourse/specoverflow")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "eu.specsolutions.bddcourse.specoverflow")
public class CucumberTest {
}
