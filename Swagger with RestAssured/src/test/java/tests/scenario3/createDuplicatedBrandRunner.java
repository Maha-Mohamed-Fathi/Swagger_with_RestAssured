package tests.scenario3;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/test/java/tests/scenario3/createDuplicatedBrand.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/createDuplicatedBrand-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true)

public class createDuplicatedBrandRunner extends AbstractTestNGCucumberTests{
}
