package utility;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import seleniumGlueCode.Hook;

public class CommonFunction extends page.CreateClassObject{
	
	WebDriver driver = Hook.driver;
	
	public static HashMap<String,String> objectCollection = new HashMap<String,String>();
	

	public static void storeGlobalObjet(String key, String value)
	{
		objectCollection.put(key, value);
	}
	public static String fetchGlobalObjet(String key)
	{
		String a = objectCollection.get(key);
		return a; 
		
	}
	
	public void clickonObject(String elementName, String pageName) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
		
		driver.findElement(getObjectFromPage(elementName,pageName)).click();
		
	}
	public boolean validateObject(String elementName, String pageName) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
		
		 return driver.findElement(getObjectFromPage(elementName,pageName)).isDisplayed();
		
	}

	public void writeOnObject(String itemToType,String elementName, String pageName) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
		
		driver.findElement(getObjectFromPage(elementName,pageName)).sendKeys(itemToType);
		
	}
}
