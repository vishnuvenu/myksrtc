package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ConfigureTest {
	
	private String url="http://www.pega.com/";
	private String browser =null;
	
	//constructor to set the browser
	public ConfigureTest(String bro){browser = bro; }
	public ConfigureTest(){browser = ""; }
	//function to get  browser and URL under test
	public String getData(String type)
	{if(type.equals("url"))
	   { return url;}
	 if (type.equals("browser"))
	   { return browser;}
	
	 else return null;
	}
	// browser initialize
	public WebDriver initializeBrowser()
	{  
		WebDriver driver = null;
		if(browser.equals("firefox"))
		   {
			
			ProfilesIni pf1 = new ProfilesIni();
			FirefoxProfile fp1= pf1.getProfile("selenium");
			driver = new FirefoxDriver(fp1);
			
		   }
		 if (browser.equals("ie"))
		   {
			//System.setProperty("", ) '
			 System.setProperty("webdriver.ie.driver", "C:\\sel\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		   }	
		 if (browser.equals("chrome"))
		   {
			System.setProperty("webdriver.chrome.driver", "C:\\sel\\chromedriver.exe");
			 driver = new ChromeDriver();
		   }
		 if (browser.equals(""))
		   {
			//System.setProperty("webdriver.chrome.driver", "C:\\sel\\chromedriver.exe");
			 driver = new HtmlUnitDriver();
		   }
		  return driver;
		
	}
}
