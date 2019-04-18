package reporting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Report {
	
	public String getReportConfigPath() throws IOException{
		Properties prop=new Properties();
		FileInputStream ip= new FileInputStream("D:\\New_Workspace\\Cucumber-Selenium\\config\\Configuration.properties");
		prop.load(ip);
		 String reportConfigPath = prop.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
		}

}
