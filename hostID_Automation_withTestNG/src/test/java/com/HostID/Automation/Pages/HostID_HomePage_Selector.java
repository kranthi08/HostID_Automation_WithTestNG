package com.HostID.Automation.Pages;

import org.openqa.selenium.By;

import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;

public class HostID_HomePage_Selector 
{
	private HostID_SharedResources sharedResource;
	private HostID_Utility hostUtility;
	private By HOSTID_HOMEPAGE_TitleImage;
	private By edit_HOSTID_HOMEPAGE_INITIALS;
	private By edit_HOSTID_HOMEPAGE_NETWORK_PASSWORD;
	private By button_HOSTID_HOMEPAGE_LOGINBUTTON;
	private By button_HOSTID_HOMEPAGE_CLEARBUTTON;
	private By element_HOSTID_HOMEPAGE_ERRORMESSAGE;
	
	public HostID_HomePage_Selector(HostID_SharedResources sharedResource,HostID_Utility hostUtility)
	{
		this.sharedResource = sharedResource;
		this.hostUtility = hostUtility;
		HostID_HomePage_Objects();
	}
	public void HostID_HomePage_Objects()
	{
		HOSTID_HOMEPAGE_TitleImage = By.xpath("// x-path for host id home page title image");
		edit_HOSTID_HOMEPAGE_INITIALS = By.id("// id for Initials");
		edit_HOSTID_HOMEPAGE_NETWORK_PASSWORD = By.id("// id for network password");
		button_HOSTID_HOMEPAGE_LOGINBUTTON = By.id("// id for Login BUTTON");
		button_HOSTID_HOMEPAGE_CLEARBUTTON = By.id("// id for Clear BUTTON");
		element_HOSTID_HOMEPAGE_ERRORMESSAGE = By.id("// x-path for error message");
	}
	public void verifyImageExistance()
	{
		hostUtility.waitUntilWebElementExist(HOSTID_HOMEPAGE_TitleImage, 60);
		hostUtility.VerifyWebElementExist(HOSTID_HOMEPAGE_TitleImage);		
	}
	public void LoginPage_enterTextIntoInitials(String sEditValue) throws Throwable
	{
		hostUtility.setTextOnEdit(edit_HOSTID_HOMEPAGE_INITIALS, sEditValue);
	}
	public void LoginPage_enterTextIntoNetworkPassword(String netWorkPassword) throws Throwable
	{
		hostUtility.setTextOnEdit(edit_HOSTID_HOMEPAGE_NETWORK_PASSWORD, netWorkPassword);
	}
	public void LoginPage_ClickonLogInButton() throws Throwable
	{
		hostUtility.clickOnButton(button_HOSTID_HOMEPAGE_LOGINBUTTON);
	}
	public void LoginPage_ClickOnClearButton() throws Throwable
	{
		hostUtility.clickOnButton(button_HOSTID_HOMEPAGE_CLEARBUTTON);
	}
	public void waitForErrorMessage()
	{
		//element_HOSTID_HOMEPAGE_ERRORMESSAGE
		hostUtility.waitUntilWebElementExist(element_HOSTID_HOMEPAGE_ERRORMESSAGE, 60);
		
	}
	public String getErrorMessage()
	{
		return hostUtility.getElementText(element_HOSTID_HOMEPAGE_ERRORMESSAGE);
	}
	public String getTextFromInitials() throws Throwable
	{
		return hostUtility.getTextOnEdit(edit_HOSTID_HOMEPAGE_INITIALS);
	}
	public String getTextOnNetworkpasswordEdit() throws Throwable
	{
		return hostUtility.getTextOnEdit(edit_HOSTID_HOMEPAGE_NETWORK_PASSWORD);
	}
}