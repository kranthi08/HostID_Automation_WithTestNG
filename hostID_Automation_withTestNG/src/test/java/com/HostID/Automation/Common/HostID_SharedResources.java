package com.HostID.Automation.Common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;

public class HostID_SharedResources 
{
	public static ThreadLocal<WebDriver> Tdriver = new ThreadLocal<WebDriver>();
	public static boolean performAppLaunch;
	
	public void beforeClass(String browser,String url) throws IOException
	{		
		WebDriver driver;
		try
		{
			if(getDriver().toString().equals(null))
			{
				performAppLaunch = true;
			}
			else
			{
				performAppLaunch = false;
				return;
			}
		}
		catch(Exception e)
		{
			WindowsUtils.killByName("chromedriver.exe");
			driver=null;
			performAppLaunch = true;
			System.out.println("Driver set to null");
		}		
		String myBrowser = 	browser;
		String appURL = url;
		driver=null;
		if(myBrowser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.navigate().to(appURL);
		}
		else if(myBrowser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.navigate().to(appURL);			
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	public WebDriver getDriver()
	{
		return Tdriver.get();
	}
	public void setWebDriver(WebDriver driver)
	{
		Tdriver.set(driver);
	}
	public void tearDown()
	{
		getDriver().close();
		getDriver().quit();
	}
}