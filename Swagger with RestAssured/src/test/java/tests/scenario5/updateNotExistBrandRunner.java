package tests.scenario5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/test/java/tests/scenario5/updateNotExistBrand.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/updateNotExistBrand-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true)
public class updateNotExistBrandRunner extends AbstractTestNGCucumberTests{
}
