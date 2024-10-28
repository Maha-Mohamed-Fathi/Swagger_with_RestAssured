package tests.scenario1;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/test/java/tests/scenario1/getAllBrands.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/getAllBrands-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true)

public class getAllBrandsRunner extends AbstractTestNGCucumberTests {
}
