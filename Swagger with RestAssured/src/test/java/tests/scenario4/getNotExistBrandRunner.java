package tests.scenario4;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/test/java/tests/scenario4/getNotExistBrand.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/getNotExistBrand-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true)

public class getNotExistBrandRunner extends AbstractTestNGCucumberTests{
}
