package seleniumGlueCode;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.assertj.core.api.*;
import org.junit.Assert;
//import utility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition extends page.CreateClassObject{
	
	WebDriver driver = Hook.driver;
	SoftAssertions softly = new SoftAssertions();
	utility.CommonFunction objCommonFunction = new utility.CommonFunction(); 
	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String URL) throws Throwable {
		driver.get(URL);
		Thread.sleep(10000);
		
	}

	@Given("^Refresh the page$")
	public void refresh_the_page() throws Throwable {
	    driver.navigate().refresh();
	}

	@Then("^Search \"([^\"]*)\" in the \"([^\"]*)\" in the \"([^\"]*)\"$")
	public void search_in_the(String itemToType, String elementName , String pageName) throws Throwable {
	    
		objCommonFunction.writeOnObject(itemToType,elementName,pageName);
		Reporter.addStepLog("Search is working fine");
	}
	
	@Then("^User clicks on \"([^\"]*)\" in \"([^\"]*)\"$")
	public void user_clicks_on_in(String elementName, String pageName) throws Throwable {
	    
		objCommonFunction.clickonObject(elementName, pageName);
	}
	
	@Then("^User validates the \"([^\"]*)\" contains \"([^\"]*)\" in \"([^\"]*)\"$")
	public void user_validates_the_contains_in(String elementName, String textToVerify, String pageName) throws Throwable {
	    if(objCommonFunction.validateObject(elementName, pageName))
	    {
	    	String objectText=null;
	    	List<WebElement> objectToValidate=driver.findElements(getObjectFromPage(elementName,pageName));
	    	for(int i=0;i<objectToValidate.size();i++)
	    	{
	    		if(objectText==null)
	    		{
	    			objectText=objectToValidate.get(i).getText();
	    		}
	    		else
	    		{
	    			objectText=objectText+">"+objectToValidate.get(i).getText();
	    		}
	    	}
	    
	    	
	    	softly.assertThat(objectText).as("Breadcrumb").isEqualTo(textToVerify);
	    	softly.assertAll();

	    }
	}

	@Then("^User clicks on item number (\\d+) of \"([^\"]*)\" in \"([^\"]*)\"$")
	public void user_clicks_on_item_number_of_in(int itemIndex, String elementName, String pageName) throws Throwable {
		if(objCommonFunction.validateObject(elementName, pageName))
	    {
			List<WebElement> objectToValidate=driver.findElements(getObjectFromPage(elementName,pageName));
			List<WebElement> objectName=driver.findElements(getObjectFromPage("Item_Name",pageName));
			
			objCommonFunction.storeGlobalObjet("ItemName", objectName.get(itemIndex-1).getText().trim());
			objectToValidate.get(itemIndex-1).click();
	    }
	    
	}
	
	@Then("^Verify the name in the search page and the details page are same$")
	public void verify_the_name_in_the_search_page_and_the_details_page_are_same() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualText=driver.findElement(getObjectFromPage("Item_Name_PDP","HomePage")).getText();
		String expectedText=objCommonFunction.fetchGlobalObjet("ItemName");
		
		System.out.println(actualText+" , "+expectedText);
	}


}
