package com.HostID.Automation.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;
import com.HostID.Automation.Common.Xls_Reader;
import com.HostID.Automation.Pages.Financial_Institution_Home_Selector;
import com.HostID.Automation.Pages.HostID_HomePage_Selector;
public class HostID_LoginPage_Validations 
{
	private HostID_HomePage_Selector hostIDhomepage;
	private Financial_Institution_Home_Selector fiHomepage;
	private Xls_Reader reader;
	private HostID_SharedResources sharedResources;
	private HostID_Utility hostUtility;
	public String filename = System.getProperty("user.dir")+"\\TestData\\TestData_HostID.xlsx";
	
	@BeforeMethod
	public void init() throws Throwable
	{
		System.out.println("HostID_LoginPage_Validations Test case");
		HostID_Utility.ReadProperties();
		String strBrowser = HostID_Utility.pf.getProperty("BrowserName");
		String strEnvironment = HostID_Utility.pf.getProperty("Environment");
		String strUrl = null;
		if(strEnvironment.equalsIgnoreCase("dev"))
		{
			strUrl = HostID_Utility.pf.getProperty("Dev_URL");
		}
		else if(strEnvironment.equalsIgnoreCase("qc"))
		{
			strUrl = HostID_Utility.pf.getProperty("QC_URL");
		}
		sharedResources = new HostID_SharedResources();
		sharedResources.beforeClass(strBrowser, strUrl);
		hostUtility = new HostID_Utility(sharedResources); 
		hostIDhomepage = new HostID_HomePage_Selector(sharedResources,hostUtility);
		fiHomepage = new Financial_Institution_Home_Selector(sharedResources,hostUtility);
	}
	@Test(priority=0)
	public void hostid_HomePage_Login_Validations_ErrorMessage() throws Throwable
	{
		reader = new Xls_Reader(filename);
		String strInitials = reader.getCellData("LoginPage", "edit_Initials", 2);
		String strNetworkPassword = reader.getCellData("LoginPage", "edit_NetworkPassword", 2);
		String strExp_Element_ErrorMessage = reader.getCellData("LoginPage", "element_Error_Message", 2);
		hostIDhomepage.verifyImageExistance();
		System.out.println("Image");
		hostIDhomepage.LoginPage_enterTextIntoInitials(strInitials);
		System.out.println("initials");
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(strNetworkPassword);
		System.out.println("password");
		hostIDhomepage.LoginPage_ClickonLogInButton();
		System.out.println("login");
		hostIDhomepage.waitForErrorMessage();
		String strAct_ErrorMessage = hostIDhomepage.getErrorMessage();
		Assert.assertEquals(strAct_ErrorMessage, strExp_Element_ErrorMessage);	
	}
	@Test(priority=1)
	public void hostid_HomePage_Login_Validations_Clear() throws Throwable
	{
		reader = new Xls_Reader(filename);
		String strInitials = reader.getCellData("LoginPage", "edit_Initials", 3);
		String strNetworkPassword = reader.getCellData("LoginPage", "edit_NetworkPassword", 3);
		hostIDhomepage.verifyImageExistance();
		System.out.println("Image");
		hostIDhomepage.LoginPage_enterTextIntoInitials(strInitials);
		System.out.println("initials");
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(strNetworkPassword);
		System.out.println("password");
		hostIDhomepage.LoginPage_ClickOnClearButton();
		System.out.println("clear");
		String expInitials = "";
		String expNetworkPassword = "";
		String actInitials = hostIDhomepage.getTextFromInitials();
		String actNetworkPassword = hostIDhomepage.getTextOnNetworkpasswordEdit();
		Assert.assertEquals(actInitials, expInitials);
		Assert.assertEquals(actNetworkPassword, expNetworkPassword);	
	}
	@Test(priority=2)
	public void hostid_HomePage_Login_Validations_NextPage() throws Throwable
	{
		
		reader = new Xls_Reader(filename);
		String strInitials = reader.getCellData("LoginPage", "edit_Initials", 4);
		String strNetworkPassword = reader.getCellData("LoginPage", "edit_NetworkPassword", 4);
		hostIDhomepage.verifyImageExistance();
		System.out.println("Image");
		hostIDhomepage.LoginPage_enterTextIntoInitials(strInitials);
		System.out.println("initials");
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(strNetworkPassword);
		System.out.println("password");
		hostIDhomepage.LoginPage_ClickonLogInButton();
		System.out.println("login");
		fiHomepage.waitForPayoutslink();
		System.out.println("payout link");
		fiHomepage.performLogOff();
		System.out.println("logoff");
	}
    @AfterMethod
	public void teardown()
	{
		sharedResources.tearDown();
	}
}