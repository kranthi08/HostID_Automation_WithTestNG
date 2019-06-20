package com.HostID.Automation.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;
import com.HostID.Automation.Common.Xls_Reader;
import com.HostID.Automation.Pages.AccessControl_Selector;
import com.HostID.Automation.Pages.Financial_Institution_Home_Selector;
import com.HostID.Automation.Pages.HostID_HomePage_Selector;

public class HostID_FI_Manager_AccessControl_Validation 
{
	private Xls_Reader reader;
	private AccessControl_Selector AccessControl;
	private HostID_SharedResources sharedResources;
	private HostID_Utility hostUtility;
	private HostID_HomePage_Selector hostIDhomepage;
	private Financial_Institution_Home_Selector fiHomepage;
	public String filename = System.getProperty("user.dir")+"\\TestData\\TestData_HostID.xlsx";
	
	@BeforeClass
	//@Parameters({"browser","url","initials","networkPassword"})
	public void init() throws Throwable 
	{
		System.out.println("HostID_FI_Manager_AccessControl_Validation Test case");
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
		String initials = HostID_Utility.pf.getProperty("FI_Manager_Initials");;
		String networkPassword = HostID_Utility.pf.getProperty("FI_Manager_NetworkPassword");
		sharedResources = new HostID_SharedResources();
		sharedResources.beforeClass(strBrowser, strUrl);
		hostUtility = new HostID_Utility(sharedResources); 
		hostIDhomepage = new HostID_HomePage_Selector(sharedResources,hostUtility);
		fiHomepage = new Financial_Institution_Home_Selector(sharedResources,hostUtility);
		AccessControl = new AccessControl_Selector(sharedResources,hostUtility);
		
		hostIDhomepage.verifyImageExistance();
		System.out.println("Image");
		hostIDhomepage.LoginPage_enterTextIntoInitials(initials);
		System.out.println("Initials");
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(networkPassword);
		System.out.println("network password");
		hostIDhomepage.LoginPage_ClickonLogInButton();
		System.out.println("login");
		fiHomepage.waitForPayoutslink();
		System.out.println("payout");
	}
	@AfterClass
	public void teardown()
	{
		sharedResources.tearDown();
	}
	@Test(priority=0)
	public void create_Tab_Validations() throws Throwable
	{
		reader = new Xls_Reader(filename);
		String strtabOrder = reader.getCellData("Access_Control", "Accessor_TAB_Order", 2);
		String strVisibleLinks = reader.getCellData("Access_Control", "CreateTab_VisibleLinks", 2);
		String strInvisibleLinks = reader.getCellData("Access_Control", "CreateTab_InvisibleLinks", 2);
		
		AccessControl.tabOrderVerification(strtabOrder);
		System.out.println("tab order");
		hostUtility.hoverTheMouseIntoElement("Create");
		System.out.println("create");
		AccessControl.createTab_visibleLinkVerification(strVisibleLinks);
		System.out.println("visible links");
		AccessControl.createTab_invisibileLinkVerification(strInvisibleLinks);
		System.out.println("in visible links");
	}
	@Test(priority=1)
	public void import_Tab_Validations() throws Throwable
	{
		String strInvisibleLinks = reader.getCellData("Access_Control", "ImportTab_InvisibleLinks", 2);
		AccessControl.verify_VisibilityOfimportTab();
		System.out.println("import");
		AccessControl.importTab_invisibileLinkVerification(strInvisibleLinks);
		System.out.println("in visible links");
	}
	@Test(priority=2)
	public void search_Tab_Validations() throws Throwable
	{
		String strVisibleLinks = reader.getCellData("Access_Control", "SearchTab_VisibleLinks", 2);
		hostUtility.hoverTheMouseIntoElement("Search");
		System.out.println("search");
		AccessControl.createTab_visibleLinkVerification(strVisibleLinks);
		System.out.println("visible links");
	}
	@Test(priority=3)
	public void exported_Tab_Validations() throws Throwable
	{
		String strVisibleLinks = reader.getCellData("Access_Control", "ExportedTab_VisibleLinks", 2);
		hostUtility.hoverTheMouseIntoElement("Exported");
		System.out.println("export");
		AccessControl.createTab_visibleLinkVerification(strVisibleLinks);
		System.out.println("visible links");
	}
	@Test(priority=4)
	public void jobs_Tab_Validations() throws Throwable
	{
		String strInvisibleLinks = reader.getCellData("Access_Control", "JobsTab_InvisibleLinks", 2);
		AccessControl.verify_VisibilityOfJobsTab();
		System.out.println("jobs");
		AccessControl.jobsTab_invisibileLinkVerification(strInvisibleLinks);
		System.out.println("in visible links");
	}
	@Test(priority=5)
	public void workorders_Tab_Validations() throws Throwable
	{
		AccessControl.workOrdersTab_visibiltyVerification();
		System.out.println("work orders");
		AccessControl.workOrdersLinkClick();
		System.out.println("work orders link");
		AccessControl.workOderPageValidation();
		System.out.println("work orders page valdation");
	}
	
// End of class	
}
