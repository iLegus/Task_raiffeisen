package cucumber;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"cucumber"},
        tags = "@all",
        dryRun = true,
        strict = false
)
public class YandexTest {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "target/surefire-reports";
    }
}
