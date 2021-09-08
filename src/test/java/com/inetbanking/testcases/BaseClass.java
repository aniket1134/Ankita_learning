package com.inetbanking.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig =new ReadConfig();
	public String baseurl=readconfig.getApplicationUrl();
	public String userid=readconfig.getuserid();
	public String password=readconfig.getpassword();
	public static Logger logger;
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		logger = Logger.getLogger("com.inetbanking.testcases.TC_LoginTest_001");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		driver=new ChromeDriver();
		
		}
		
		else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
			driver=new InternetExplorerDriver();
			
			}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
