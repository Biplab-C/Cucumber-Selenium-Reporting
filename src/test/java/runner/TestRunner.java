package runner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import reporting.Report;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src\\test\\java\\feature"
,glue= {"seleniumGlueCode"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)


public class TestRunner extends reporting.Report {
	
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Report rpt = new Report();
		Reporter.loadXMLConfig(new File(rpt.getReportConfigPath()));
	}

}
