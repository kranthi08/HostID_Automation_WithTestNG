package com.HostID.Automation.Pages;

import org.openqa.selenium.By;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;

public class Financial_Institution_Home_Selector 
{
	@SuppressWarnings("unused")
	private HostID_SharedResources sharedResource;
	private HostID_Utility hostUtility;
	
	private By payoutsLink;
	private By LogoffLink;
	
	public Financial_Institution_Home_Selector(HostID_SharedResources sharedResource,HostID_Utility hostUtility)
	{
		this.sharedResource = sharedResource;
		this.hostUtility = hostUtility;
		Financial_Institution_Home_Objects();
	}
	public void Financial_Institution_Home_Objects()
	{
		payoutsLink = By.id("");
		LogoffLink = By.id("");
	}
	public void waitForPayoutslink()
	{
		hostUtility.waitUntilWebElementExist(payoutsLink,60);
	}
	public void performLogOff()
	{
		hostUtility.clickonLink(LogoffLink);
	}
}