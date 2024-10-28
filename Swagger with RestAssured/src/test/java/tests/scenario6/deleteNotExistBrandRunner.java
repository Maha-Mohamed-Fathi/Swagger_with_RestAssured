package tests.scenario6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/test/java/tests/scenario6/deleteNotExistBrand.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/deleteNotExistBrand-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true)

public class deleteNotExistBrandRunner extends AbstractTestNGCucumberTests {

}
