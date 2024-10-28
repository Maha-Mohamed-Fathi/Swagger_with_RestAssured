package tests.scenario2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features= {"src/test/java/tests/scenario2/getSpecificBrand.feature"},
        glue=     {"tests"},
        plugin = {"pretty", "html:reports/getSpecificBrand-Report.html", "json:Report\\jsonReport.json"},
        monochrome=true)

public class getSpecificBrandRunner extends AbstractTestNGCucumberTests{
}
