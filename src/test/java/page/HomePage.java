package page;

import org.openqa.selenium.By;

public class HomePage {
	
	
	public By Search_Bo= By.xpath("//input[@id='searchText']");
	public By Submit_Searchbox= By.xpath("//button[@id='searchsubmit']");
	public By Breadcrumb = By.xpath("//div[@class='breadcrumb clearfix']/a");
	public By Item_Name123 = By.xpath("//span[@class='responsivegriditem__title']");
	public By Item_Name_Link = By.xpath("//span[@class='responsivegriditem__title']/parent::a");
	public By Item_Name_PDP=By.xpath("//h1[@itemprop='name']");
	
}
