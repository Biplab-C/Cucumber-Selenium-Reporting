package seleniumGlueCode;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hook extends reporting.Report {	
	
	public static WebDriver driver;
		 
		 @Before
		    public void beforeScenario(){
			    
			 System.setProperty("webdriver.chrome.driver", "D:\\New_Workspace\\Cucumber-Selenium\\drivers\\chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		    } 
		 
		 @After(order = 1)
		 public void afterScenario(Scenario scenario) {
		 if (scenario.isFailed()) {
		 String screenshotName = scenario.getName().replaceAll(" ", "_");
		 try {
		 File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 } catch (IOException e) {
		 } 
		 }
		 }
		 @After(order = 0)
		    public void afterScenario(){
			 	driver.close();
			 	
		    }
		

}
