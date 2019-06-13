package com.HostID.Automation.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
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
	public String filename = System.getProperty("user.dir")"\\TestData\\TestData_HostID.xlsx";
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void init(String strBrowser,String strUrl) throws Throwable 
	{
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
		hostIDhomepage.LoginPage_enterTextIntoInitials(strInitials);
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(strNetworkPassword);
		hostIDhomepage.LoginPage_ClickonLogInButton();
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
		hostIDhomepage.LoginPage_enterTextIntoInitials(strInitials);
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(strNetworkPassword);
		hostIDhomepage.LoginPage_ClickOnClearButton();
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
		hostIDhomepage.LoginPage_enterTextIntoInitials(strInitials);
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(strNetworkPassword);
		hostIDhomepage.LoginPage_ClickonLogInButton();
		fiHomepage.waitForPayoutslink();
		fiHomepage.performLogOff();	
	}
	
		
    @AfterClass
	public void teardown()
	{
		sharedResources.tearDown();
	}
}