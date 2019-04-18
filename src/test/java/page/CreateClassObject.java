package page;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;

public class CreateClassObject {
	
	public static By getObjectFromPage(String elementName, String pageName) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
		Object object = null;
		try {
			Class<?> cls = Class.forName("page."+pageName);
			try {
				object = cls.newInstance();
				return (By) cls.getField(elementName).get(object);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("There is no page available with the name '"+pageName+"'");
		}
		 return null;
	}

}
