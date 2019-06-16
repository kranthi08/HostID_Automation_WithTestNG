package com.HostID.Automation.Pages;

import java.util.Map;

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
	}
	
	public void loginPageVerification()
	{
		hostutils.verify_VisibilityOfLink(INBOXLINK);
	}
	public void logoff_link_click()
	{
		hostutils.clickonLink(LOGOFFLINK);
	}
	public void tabOrderVerification(String tabOrderLinks) throws InterruptedException
	{
		String arrTabOrderLinks[] = null;
		if(tabOrderLinks.contains("->"))
		{
			arrTabOrderLinks = tabOrderLinks.split("\\->");		
			if(arrTabOrderLinks.length > 0)
			{
				for(int i=0;i<arrTabOrderLinks.length-1;i++)
				{
				hostutils.verify_VisibilityOfLink(arrTabOrderLinks[i]);
				Thread.sleep(2000);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(tabOrderLinks);
		}
	}
	public void mouseHoveroperation(Map<String,String>HoveredText)
	{
		String sText = HoveredText.get("mouseHoverText");
		hostutils.hoverTheMouseIntoElement(sText);
	}
	
	//=========================================================================================
	// Create Tab
	// ========================================================================================
	public void createTab_visibleLinkVerification(String createTab_VISIBLED_LINKS) throws InterruptedException
	{
		String arrVisibledLinks[] = null;
		String visibledLinks = createTab_VISIBLED_LINKS;
		if(visibledLinks.contains("->"))
		{
			arrVisibledLinks = visibledLinks.split("\\->");		
			if(arrVisibledLinks.length > 0)
			{
				for(int i=0;i<arrVisibledLinks.length-1;i++)
				{
				hostutils.verify_VisibilityOfLink(arrVisibledLinks[i]);
				Thread.sleep(2000);
				}
			}
		}
		else
		{
			hostutils.verify_VisibilityOfLink(visibledLinks);
		}
		
	}
	public void createTab_invisibileLinkVerification(String createTab_Invisible_Links) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = createTab_Invisible_Links;
		if(links.contains("->"))
		{
			arrLinks = links.split("\\->");
			if(arrLinks.length > 0)
			{
				for(int i=0;i<arrLinks.length-1;i++)
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
	  
	public void verify_VisibilityOfCreateTab()
	{
		hostutils.verify_VisibilityOfLink("Create");
	}
	
	//=========================================================================================
	// Import Tab
	// ========================================================================================
	
	public void importTab_invisibileLinkVerification(String importTab_invisibleLinks) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = importTab_invisibleLinks;
		if(links.contains("->"))
		{
			arrLinks = links.split("\\->");
			if(arrLinks.length > 0 )		
			{
				for(int i=0;i<arrLinks.length-1;i++)
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
	
	public void importTab_visibileLinkVerification(String importTab_visibleLinks) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = importTab_visibleLinks;
		if(links.contains("->"))
		{
			arrLinks = links.split("\\->");
			if(arrLinks.length > 0 )		
			{
				for(int i=0;i<arrLinks.length-1;i++)
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
	
	public void verify_VisibilityOfimportTab()
	{
		hostutils.verify_VisibilityOfLink("Import");
	}
		
	//=========================================================================================
	// Search Tab
	// ========================================================================================
	
	public void searchTab_visibileLinkVerification(String searchtab_visible_Links) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = searchtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
			Thread.sleep(2000);
		}
	}
	public void searchTab_invisibileLinkVerification(String searchtab_visible_Links) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = searchtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
			Thread.sleep(2000);
		}
	}
	
	public void verify_VisibilityOfSearchTab()
	{
		hostutils.verify_VisibilityOfLink("Search");
	}
	
	//=========================================================================================
	// Exported Tab
	// ========================================================================================
	
	
	public void exportedTab_visibileLinkVerification(String exportedtab_visible_Links) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = exportedtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
			Thread.sleep(2000);
		}
	}
	
	public void exportedTab_invisibileLinkVerification(String exportedtab_visible_Links) throws InterruptedException
	{
		String arrLinks[] = null;
		String links = exportedtab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
			Thread.sleep(2000);
		}
	}
	public void verify_VisibilityOfExportedTab()
	{
		hostutils.verify_VisibilityOfLink("Exported");
	}
	//=========================================================================================
	// Jobs Tab
	// ========================================================================================
	
	public void jobsTab_invisibileLinkVerification(String jobsTab_invisible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = jobsTab_invisible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
			Thread.sleep(2000);
		}
	}
	
	public void jobsTab_visibleLinksverification(String jobsTab_visible_Links) throws Throwable
	{
		String arrLinks[] = null;
		String links = jobsTab_visible_Links;
		arrLinks = links.split("\\->");
		for(int i=0;i<arrLinks.length-1;i++)
		{
			hostutils.verify_VisibilityOfLink(arrLinks[i]);
			Thread.sleep(2000);
		}
	}
	
	public void verify_VisibilityOfJobsTab()
	{
		hostutils.verify_VisibilityOfLink("Jobs");
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
