package com.HostID.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;

public class AccessControl_Selector 
{
	WebDriver driver = null;
	private HostID_SharedResources hostidResources;
	private HostID_Utility hostutils;
	private By INBOXLINK;
	private By WORKORDERSLINK;
	private By WORKORDERS_HEADER_TITLE;
	private By LOGOFFLINK;
	private By CREATE_TAB,IMPORT_TAB,SEARCH_TAB,EXPORTED_TAB,JOBS_TAB,WORK_ORDERS_TAB;		
	public AccessControl_Selector(HostID_SharedResources hostidResources,HostID_Utility hostutils)
	{
			this.hostidResources = hostidResources;
			this.hostutils = hostutils;
			this.driver = hostidResources.getDriver();
			AccessControl_for_FI_Manager_Selector_PageObjects();
	}
	public void AccessControl_for_FI_Manager_Selector_PageObjects()
	{
		INBOXLINK = By.linkText("Inbox");
		WORKORDERSLINK = By.linkText("Work Orders");
		WORKORDERS_HEADER_TITLE = By.xpath(""); // id or x-path for WORKoRDERS_HEADER_TITLE
		LOGOFFLINK = By.xpath(""); // x-path for Log off link
		
		CREATE_TAB =  By.xpath(""); // X-Path for create tab
		IMPORT_TAB =  By.xpath(""); // X-Path for Import Tab
		SEARCH_TAB =  By.xpath(""); // X-Path for search tab
		EXPORTED_TAB =  By.xpath(""); // X-Path for exported tab
		JOBS_TAB =  By.xpath(""); // X-Path for jobs tab
		WORK_ORDERS_TAB = By.xpath(""); // X-Path for Work Orders tab
	}
	public void loginPageVerification()
	{
		hostutils.verify_VisibilityOfLink(INBOXLINK);
	}
	public void logoff_link_click()
	{
		hostutils.clickonLink(LOGOFFLINK);
	}
	public void tabOrderVerification(String tabOrderLinks) throws Throwable
	{
		String arrTabOrderLinks[] = null;
		if(tabOrderLinks.contains("->"))
		{
			arrTabOrderLinks = tabOrderLinks.split("\\->");		
			if(arrTabOrderLinks.length > 0)
			{
				for(int i=0;i<=arrTabOrderLinks.length-1;i++)
				{
				hostutils.verify_VisibilityOfLink(arrTabOrderLinks[i]);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(tabOrderLinks);
		}
	}
	//=========================================================================================
	// Create Tab
	// ========================================================================================
	public void createTab_visibleLinkVerification(String createTab_VISIBLED_LINKS) throws Throwable
	{
		String arrVisibledLinks[] = null;
		String visibledLinks = createTab_VISIBLED_LINKS;
		if(visibledLinks.contains("->"))
		{
			arrVisibledLinks = visibledLinks.split("\\->");		
			if(arrVisibledLinks.length > 0)
			{
				for(int i=0;i<=arrVisibledLinks.length-1;i++)
				{
				hostutils.verify_VisibilityOfLink(arrVisibledLinks[i]);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(visibledLinks);
		}
	}
	public void createTab_invisibileLinkVerification(String createTab_Invisible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = createTab_Invisible_Links;
		if(links.contains("->"))
		{
			arrLinks = links.split("\\->");
			if(arrLinks.length > 0)
			{
				for(int i=0;i<=arrLinks.length-1;i++)
				{
					hostutils.verify_VisibilityOfLink(arrLinks[i]);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(links);
		}
	}
	public void verify_VisibilityOfCreateTab()
	{
		hostutils.verify_VisibilityOfLink("Create");
	}
	public void performMouseHoverIntoCreateTab() throws Throwable
	{
		hostutils.hoverTheMouseIntoElement(CREATE_TAB);
	}
	
	public void verify_VisibilityOfImportTab()
	{
		hostutils.verify_VisibilityOfLink("Import");
	}
	public void performMouseHoverIntoImportTab() throws Throwable
	{
		hostutils.hoverTheMouseIntoElement(IMPORT_TAB);
	}
	
	public void verify_VisibilityOfSearchTab()
	{
		hostutils.verify_VisibilityOfLink("Search");
	}
	public void performMouseHoverIntoSearchTab() throws Throwable
	{
		hostutils.hoverTheMouseIntoElement(SEARCH_TAB);
	}
	
	public void verify_VisibilityOfExportedTab()
	{
		hostutils.verify_VisibilityOfLink("Exported");
	}
	public void performMouseHoverIntoExportedTab() throws Throwable
	{
		hostutils.hoverTheMouseIntoElement(EXPORTED_TAB);
	}
	
	public void verify_VisibilityOfJobsTab()
	{
		hostutils.verify_VisibilityOfLink("Jobs");
	}
	public void performMouseHoverIntoJobsTab() throws Throwable
	{
		hostutils.hoverTheMouseIntoElement(JOBS_TAB);
	}
	
	public void verify_VisibilityOfWorkOrdersTab()
	{
		hostutils.verify_VisibilityOfLink("Work Orders");
	}
	
	//=========================================================================================
	// Import Tab
	// ========================================================================================
	public void importTab_invisibileLinkVerification(String importTab_invisibleLinks) throws Throwable
	{
		String arrLinks[] = null;
		String links = importTab_invisibleLinks;
		if(links.contains("->"))
		{
			arrLinks = links.split("\\->");
			if(arrLinks.length > 0 )		
			{
				for(int i=0;i<=arrLinks.length-1;i++)
				{
					hostutils.verify_VisibilityOfLink(arrLinks[i]);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(links);
		}
	}
	public void importTab_visibileLinkVerification(String importTab_visibleLinks) throws Throwable
	{
		String arrLinks[] = null;
		String links = importTab_visibleLinks;
		if(links.contains("->"))
		{
			arrLinks = links.split("\\->");
			if(arrLinks.length > 0 )		
			{
				for(int i=0;i<=arrLinks.length-1;i++)
				{
					hostutils.verify_VisibilityOfLink(arrLinks[i]);
					Thread.sleep(2000);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(links);
		}
	}		
	//=========================================================================================
	// Search Tab
	// ========================================================================================
	public void searchTab_visibileLinkVerification(String searchtab_visible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = searchtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<=arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
		}
	}
	public void searchTab_invisibileLinkVerification(String searchtab_visible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = searchtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<=arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
		}
	}
	//=========================================================================================
	// Exported Tab
	// ========================================================================================
	public void exportedTab_visibileLinkVerification(String exportedtab_visible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = exportedtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<=arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
		}
	}
	public void exportedTab_invisibileLinkVerification(String exportedtab_visible_Links) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = exportedtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<=arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
		}
	}
	//=========================================================================================
	// Jobs Tab
	// ========================================================================================
	public void jobsTab_invisibileLinkVerification(String jobsTab_invisible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = jobsTab_invisible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<=arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
		}
	}
	public void jobsTab_visibleLinksverification(String jobsTab_visible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = jobsTab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<=arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
		}
	}
	//=========================================================================================
	// work orders Tab
	// ========================================================================================
	public void workOrdersLinkClick()
	{
		hostutils.clickonLink(WORKORDERSLINK);
	}
	public void workOderPageValidation()
	{
		hostutils.waitUntilWebElementExist(WORKORDERS_HEADER_TITLE, 60);
		hostutils.VerifyWebElementExist(WORKORDERS_HEADER_TITLE);
	}
	public void workOrdersTab_visibiltyVerification()
	{
		hostutils.verify_VisibilityOfLink("Work Orders");
	}
// End Of Class
}
