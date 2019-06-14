package com.HostID.Automation.Pages;

import org.openqa.selenium.By;

import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;

public class Financial_Institution_Home_Selector 
{
	private HostID_SharedResources SharedResources;
	private HostID_Utility hostUtility;
	
	private By payoutsLink;
	private By LogoffLink;
	
	public Financial_Institution_Home_Selector(HostID_SharedResources SharedResources,HostID_Utility hostUtility)
	{
		this.SharedResources = SharedResources;
		this.hostUtility = hostUtility;
		Financial_Institution_Home_Objects();
	}
	public void Financial_Institution_Home_Objects()
	{
		payoutsLink = By.id("// id or name or link text or xpath for payouts link");
		LogoffLink = By.id("// id or name or link text or xpath for logoff link");
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
