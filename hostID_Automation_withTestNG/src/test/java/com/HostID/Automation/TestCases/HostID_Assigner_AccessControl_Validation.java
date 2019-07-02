package com.HostID.Automation.TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;
import com.HostID.Automation.Common.Xls_Reader;
import com.HostID.Automation.Pages.AccessControl_Selector;
import com.HostID.Automation.Pages.Financial_Institution_Home_Selector;
import com.HostID.Automation.Pages.HostID_HomePage_Selector;

public class HostID_Assigner_AccessControl_Validation 
{
	private Xls_Reader reader;
	private AccessControl_Selector AccessControl;
	private HostID_SharedResources sharedResources;
	private HostID_Utility hostUtility;
	private HostID_HomePage_Selector hostIDhomepage;
	private Financial_Institution_Home_Selector fiHomepage;
	public String filename = System.getProperty("user.dir")+"\\TestData\\TestData_HostID.xlsx";
	
	@BeforeTest
	public void init() throws Throwable
	{
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
		
		String initials = HostID_Utility.pf.getProperty("Assigner_Initials");;
		String networkPassword = HostID_Utility.pf.getProperty("Assigner_NetworkPassword");
		
		sharedResources = new HostID_SharedResources();
		sharedResources.beforeClass(strBrowser, strUrl);
		hostUtility = new HostID_Utility(sharedResources); 
		hostIDhomepage = new HostID_HomePage_Selector(sharedResources,hostUtility);
		fiHomepage = new Financial_Institution_Home_Selector(sharedResources,hostUtility);
		AccessControl = new AccessControl_Selector(sharedResources,hostUtility);
		
		hostIDhomepage.verifyImageExistance();
		hostIDhomepage.LoginPage_enterTextIntoInitials(initials);
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(networkPassword);
		hostIDhomepage.LoginPage_ClickonLogInButton();				
		fiHomepage.waitForPayoutslink();
	}
	@AfterTest
	public void teardown()
	{
		sharedResources.tearDown();
	}
	@Test(priority=0)
	public void create_Tab_Validations() throws Throwable
	{
		reader = new Xls_Reader(filename);
		String strtabOrder = reader.getCellData("Access_Control", "Accessor_TAB_Order", 3);
		String strVisibleLinks = reader.getCellData("Access_Control", "CreateTab_VisibleLinks", 3);
		String strInvisibleLinks = reader.getCellData("Access_Control", "CreateTab_InvisibleLinks", 3);
		
		AccessControl.tabOrderVerification(strtabOrder);
		AccessControl.performMouseHoverIntoCreateTab();
		AccessControl.createTab_visibleLinkVerification(strVisibleLinks);
		AccessControl.createTab_invisibileLinkVerification(strInvisibleLinks);
	}
	@Test(priority=1)
	public void import_Tab_Validations() throws Throwable
	{
		String strVisibleLinks = reader.getCellData("Access_Control", "ImportTab_VisibleLinks", 3);
		String strInvisibleLinks = reader.getCellData("Access_Control", "ImportTab_InvisibleLinks", 3);
		
		AccessControl.performMouseHoverIntoImportTab();
		AccessControl.importTab_visibileLinkVerification(strVisibleLinks);
		AccessControl.importTab_invisibileLinkVerification(strInvisibleLinks);
	}
	@Test(priority=2)
	public void search_Tab_Validations() throws Throwable
	{
		String strVisibleLinks = reader.getCellData("Access_Control", "SearchTab_VisibleLinks", 3);
		AccessControl.performMouseHoverIntoSearchTab();
		AccessControl.searchTab_visibileLinkVerification(strVisibleLinks);
	}
	@Test(priority=3)
	public void exported_Tab_Validations() throws Throwable
	{
		String strVisibleLinks = reader.getCellData("Access_Control", "ExportedTab_VisibleLinks", 3);
		AccessControl.performMouseHoverIntoExportedTab();
		AccessControl.exportedTab_visibileLinkVerification(strVisibleLinks);
	}
	@Test(priority=4)
	public void jobs_Tab_Validations() throws Throwable
	{
		String strInvisibleLinks = reader.getCellData("Access_Control", "JobsTab_InvisibleLinks", 3);
		AccessControl.verify_VisibilityOfJobsTab();
		AccessControl.jobsTab_invisibileLinkVerification(strInvisibleLinks);
	}
	@Test(priority=5)
	public void workorders_Tab_Validations() throws Throwable
	{
		AccessControl.workOrdersTab_visibiltyVerification();
		AccessControl.workOrdersLinkClick();
		AccessControl.workOderPageValidation();
	}
}
