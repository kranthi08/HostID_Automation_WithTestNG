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
	public WebDriver driver;
	public void beforeClass(String browser,String url) throws IOException
	{		
		WindowsUtils.killByName("chromedriver.exe");
		driver=null;
		System.out.println("Driver set to null");		
		String myBrowser = 	browser;
		String appURL = url;
		driver=null;
		if(myBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			driver.navigate().to(appURL);
		}
		else if(myBrowser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.navigate().to(appURL);			
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
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
		driver.close();
		driver.quit();
	}
}