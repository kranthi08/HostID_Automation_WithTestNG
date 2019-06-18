package com.HostID.Automation.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.StringUtil;

public class HostID_Utility 
{
	HostID_SharedResources sharedResources;
	public WebDriver driver;
	
	public HostID_Utility(HostID_SharedResources sharedResources)
	{
		this.driver = sharedResources.getDriver();
	}
	
	//========================================================================================
	// Set Text On Edit
	//========================================================================================
	public void setTextOnEdit(By objElementName,String editValue) 
	{		
		boolean boolsetTextOnEdit = false;
		int attempt=0;
		while(attempt < 3)
		{
			try
			{
				if(driver.findElement(objElementName).isDisplayed())
				{
					String strName = driver.findElement(objElementName).getAttribute("name");					
					driver.findElement(objElementName).clear();
					driver.findElement(objElementName).sendKeys(editValue);
					boolsetTextOnEdit = true;
					System.out.println("Set Text On edit named : " +strName+ "  and Value "+editValue);
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("setTextOnEdit - "+e.getMessage());
			}
			attempt++;			
		}
		if(boolsetTextOnEdit == false)
		{
			System.out.println("WebEdit with Name :"+driver.findElement(objElementName).getAttribute("name")+" was not found");
		}
	}
	//========================================================================================
	// Wait Until The Web Element Exist
	//========================================================================================
	public void waitUntilWebElementExist(By strItem,int intTime)
	{
		System.out.println("wait for the Element - Started");
		new WebDriverWait(driver,intTime).until(ExpectedConditions.presenceOfElementLocated(strItem));
		System.out.println("wait for the Element - Ended");
	}
	//======================================================================================================================
	// Click on Button
	//======================================================================================================================
	public void clickOnButton(By objElementName)
	{
		boolean bollclickOnButton = false;
		int attempts = 0;
		while(attempts < 3 && driver.findElements(objElementName).size()!=0)
		{
			try
			{
				if(driver.findElements(objElementName).size()!=0)
				{
					String strName = driver.findElement(objElementName).getAttribute("name");
					driver.findElement(objElementName).click();
					bollclickOnButton = true;					
					System.out.println("Clicked on Button : "+strName);
					break;
				}
				break;
			}
			catch(StaleElementReferenceException e)
			{
				System.out.println("clickOnButton --- "+ e.getMessage());
			}
				attempts++;			
		}
		if(bollclickOnButton == false)
		{
			System.out.println("WebButton with nmae : "+driver.findElement(objElementName).getAttribute("name")+" was not found");
		}
	}
	//======================================================================================================================
	// Get the Element text
	//======================================================================================================================
	public String getElementText(By objElementName)
	{		
		String sb=null;
		try
		{
			if(driver.findElement(objElementName).isDisplayed())
			{
				sb = driver.findElement(objElementName).getText();
			}
		}
		catch(Exception e)
		{
			System.out.println("getElementText --- "+e.getMessage());
		}
		return sb;	
	}
	//========================================================================================
	// get Text On Edit
	//========================================================================================
	public String getTextOnEdit(By objElementName)
	{			
		int attempt=0;
		String sText=null;
		while(attempt < 3)
		{
			try
			{
				if(driver.findElements(objElementName).size()!=0)
				{																	
					sText = driver.findElement(objElementName).getText();
				}
			}
			catch(Exception e)
			{
				System.out.println("getTextOnEdit --- "+e.getMessage());
			}
			attempt++;			
		}			
		return sText;
	}
	//======================================================================================================================
	// Verify the Web Element exist or not
	//======================================================================================================================
	public void VerifyWebElementExist(By strItem)
	{
		boolean boolVerifyWebElementExist = false;
		try
		{
			if(driver.findElement(strItem).isDisplayed())
			{
				boolVerifyWebElementExist = true;
				System.out.println("Searching for the Element - is displayed");
			}
		}
		catch(Exception e)
		{
			System.out.println("VerifyWebElementExist --- "+e.getMessage());
		}
		if(boolVerifyWebElementExist == false)
		{
			System.out.println("Searching for the Element - is not displayed");
		}
	}
	//======================================================================================================================
	// Click on Button
	//======================================================================================================================
	public void clickonLink(By objElementName)
	{
		boolean boolclickonlink=false;
		int attempts=0;
		while(attempts<3)
		{
			try
			{
				waitUntilWebElementExist(objElementName,60);
				if(driver.findElements(objElementName).size()!=0)
				{
					String strName = driver.findElement(objElementName).getAttribute("name");
					driver.findElement(objElementName).click();
					boolclickonlink = true;
					System.out.println("Clicked on Link :"+strName); 
					break;
				}
			}
			catch(StaleElementReferenceException e)			
			{
				System.out.println("clickonLink --- "+e.getMessage());
			}
			attempts++;
		}
		if(boolclickonlink==false)
		{
			System.out.println("Link with the name : "+driver.findElement(objElementName).getAttribute("name")+" was not found");
		}
	}
	//======================================================================================================================
	// createFinancialInstitution
	//======================================================================================================================
		public void createFinancialInstitution(String requiredModule)
		{
			boolean booleanNavigateToRequiredModule = false;
			try
			{
				if(!driver.findElement(By.linkText("Inbox")).isDisplayed()) 
				{
					System.out.println("-------------  In Refresh Mode  ----------"+requiredModule);
					driver.navigate().refresh();
				}
			}
			catch(Exception e)		
			{
				System.out.println("------   Exception In Refresh Mode ------");
				driver.navigate().refresh();
				System.out.println("NavigateToRequiredModule --- "+e.getMessage());
			}		

			int intCounter = 0;
			String[] arrRequiredmodule = null;
			if(!requiredModule.trim().isEmpty())
			{
				arrRequiredmodule = requiredModule.split("\\->");
				WebElement element = driver.findElement(By.linkText(arrRequiredmodule[0]));				 
		        Actions action = new Actions(driver);
		        action.moveToElement(element).build().perform();
		        driver.findElement(By.linkText(arrRequiredmodule[1])).click();				
				booleanNavigateToRequiredModule = true;
			}
			if(booleanNavigateToRequiredModule == false |intCounter!=arrRequiredmodule.length)
			{
				System.out.println("Unable to navigate required module");
			}
		}
		// ==========================================================================================
		// Verify the visibility of the element with the help of By object
		// ==========================================================================================
		public void verify_VisibilityOfLink(By objElement)
		{
			boolean verifyVisibilityOfLnk=false;
			try
			{
				if(driver.findElement(objElement).isDisplayed())
				{
					System.out.println("Link with Text - "+driver.findElement(objElement).getAttribute("text")+" is displayed");
					verifyVisibilityOfLnk=true;
				}
				else
				{
					System.out.println("Link with Text - "+driver.findElement(objElement).getAttribute("text")+" is not displayed");
					verifyVisibilityOfLnk=false;
				}
			}
			catch(Exception e)
			{
				System.out.println("verify_VisibilityOfLink -  "+e.getMessage());
				verifyVisibilityOfLnk=false;				
			}
			if(verifyVisibilityOfLnk==false)
			{
				System.out.println("verify_VisibilityOfLink - Exception Occured - Link Not displayed - ");
			}
		}
		
		// ==========================================================================================
		// Verify the visibility of the element with the help of string value
		// ==========================================================================================
		public void verify_VisibilityOfLink(String strLinkText)
		{
			boolean verifyVisibilityOfLnk=false;
			try
			{
				if(driver.findElements(By.linkText(strLinkText)).size()>0)
				{
					System.out.println("Link with Text - "+driver.findElement(By.linkText(strLinkText)).getAttribute("text")+" is displayed");
					verifyVisibilityOfLnk=true;
				}
				else
				{
					System.out.println("Link with Text - "+driver.findElement(By.linkText(strLinkText)).getAttribute("text")+" is not displayed");
					verifyVisibilityOfLnk=false;
				}
			}
			catch(Exception e)
			{
				System.out.println("verify_VisibilityOfLink -  "+e.getMessage());
				verifyVisibilityOfLnk=false;				
			}
			if(verifyVisibilityOfLnk==false)
			{
				System.out.println("verify_VisibilityOfLink - Exception Occured - Link Not displayed - ");
			}
		}
			
		// ==========================================================================================
		// Hover the mouse operation into a particular element
		// ==========================================================================================
		public void hoverTheMouseIntoElement(By objElement)
		{
			boolean hoverthemouseintoelement = false;
			try
			{
				if(driver.findElement(objElement).isDisplayed())
				{
					WebElement element = driver.findElement(objElement);				 
			        Actions action = new Actions(driver);
			        action.moveToElement(element).build().perform();
			        Thread.sleep(2000);
			        hoverthemouseintoelement = true;
			        System.out.println("Perform the mouse hover operation on "+driver.findElement(objElement).getAttribute("text"));
				}
			}
			catch(Exception e)
			{
				System.out.println("hoverTheMouseIntoElement - objElement - "+e.getMessage());
			}
			if(hoverthemouseintoelement == false)
			{
				System.out.println("hoverTheMouseIntoElement - Element not visible");
			}			
		}
			
		// ==========================================================================================
		// Hover the mouse operation into a particular element
		// ==========================================================================================
		public void hoverTheMouseIntoElement(String strElement)
		{
			@SuppressWarnings("unused")
			boolean hoverthemouseintoelement = false;
			try
			{
				if(driver.findElement(By.linkText(strElement)).isDisplayed())
				{
					WebElement element = driver.findElement(By.linkText(strElement));				 
			        Actions action = new Actions(driver);
			        action.moveToElement(element).build().perform();
			        Thread.sleep(2000);
			        hoverthemouseintoelement = true;
			        System.out.println("Perform the mouse hover operation on "+driver.findElement(By.linkText(strElement)).getAttribute("text"));
				}
			}
			catch(Exception e)
			{
				System.out.println("hoverTheMouseIntoElement - strElement - "+e.getMessage());
			}
			if(hoverthemouseintoelement == false)
			{
				System.out.println("hoverTheMouseIntoElement - Element not visible");
			}
		}
		// ==========================================================================================
		// get the browser busy status
		// ==========================================================================================
		public void GetBusyStatus(String strBrowser) throws Throwable 
		{
			try
			{
			WebDriverWait wt= new WebDriverWait(driver,60);
			WebElement busyElement=driver.findElement(By.id("loading"));				
			if(busyElement.getAttribute("style").equals(null)|| busyElement.getAttribute("style").isEmpty() || busyElement.getAttribute("style").equals(""))
			{
				return;
			}
			else
			{
				if(strBrowser.equalsIgnoreCase("IE")||strBrowser.equalsIgnoreCase("InternetExplorer"))
				{
					wt.until(ExpectedConditions.attributeToBe(busyElement,"style","DISPLAY: none"));
				}
				else if(strBrowser.equalsIgnoreCase("FF")||strBrowser.equalsIgnoreCase("firefox"))
				{
					wt.until(ExpectedConditions.attributeToBe(busyElement,"style","display: none;"));
				}
				else
				{
					wt.until(ExpectedConditions.attributeToBe(busyElement,"style","display: none;"));
				}			
				System.out.println("Performed Wait");
			}
			}
			catch(Exception e)
			{
				System.out.println("GetBusyStatus - strBrowser "+e.getMessage());
			}
		}
		//======================================================================================================================
		// Select an Item from Web LIst.
		//======================================================================================================================
		public void selectItemFromWebList(By objElementName,String ItemValue) throws InterruptedException,NoSuchElementException 
		{
			@SuppressWarnings("unused")
			boolean selectItemFromWebList=false;
			try
			{
				if(driver.findElements(objElementName).size()!=0&& StringUtil.isNotBlank(ItemValue))
				{
					Select itemstoSelect = new Select(driver.findElement(objElementName));
					System.out.println("Inside selectItemFromWebList ");
					String strName = driver.findElement(objElementName).getAttribute("name");
					itemstoSelect.selectByVisibleText(ItemValue);
					selectItemFromWebList = true;
					System.out.println("Selected Item in weblist : "+strName+ " Value "+ItemValue);
				}
			}
			catch(Exception e)
			{
				System.out.println("selectItemFromWebList --- "+e.getMessage());
				try
				{
					if(driver.findElements(objElementName).size()!=0&& StringUtil.isNotBlank(ItemValue))
					{
						Select itemstoSelect = new Select(driver.findElement(objElementName));					
						String strName = driver.findElement(objElementName).getAttribute("name");
						List<WebElement> allOptions = itemstoSelect.getOptions();
						for(WebElement i:allOptions)
						{
							if(i.getText().equalsIgnoreCase(ItemValue))
							{
								String tValue = i.getText(); 
								itemstoSelect.selectByVisibleText(tValue);
								selectItemFromWebList = true;
								System.out.println("Selected Item in weblist : "+strName+ " Value "+ItemValue);;
							}
						}						
					}
			    }
				catch(Exception s)
				{
					System.out.println("selectItemFromWebList --- "+e.getMessage());
				}
		    }
		}
		//======================================================================================================================
		//Get the data from Financial Institution Sheet
		//======================================================================================================================
		public static ArrayList<Object[]> getTestDataFromFinancialInstitutionSheet()
		{
			Xls_Reader reader = null;
			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			try
			{
				reader = new Xls_Reader(System.getProperty("user.dir")+"\\TestData\\TestData_HostID.xlsx");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			for(int rowNum = 2;rowNum<= reader.getRowCount("Financial_Institution");rowNum++)
			{
				String Institution_Name	= reader.getCellData("Financial_Institution", "Institution_Name", rowNum);
				String FI_Number = reader.getCellData("Financial_Institution", "FI_Number", rowNum);	
				String Address_Line1 = reader.getCellData("Financial_Institution", "Address_Line1", rowNum);	
				String Address_Line2 = reader.getCellData("Financial_Institution", "Address_Line2", rowNum);	
				String City = reader.getCellData("Financial_Institution", "City", rowNum);	
				String State = reader.getCellData("Financial_Institution", "State", rowNum);	
				String ZIP = reader.getCellData("Financial_Institution", "ZIP", rowNum);	
				String ZIP_SUFFIX = reader.getCellData("Financial_Institution", "ZIP_SUFFIX", rowNum);	
				String Corporate_Structure = reader.getCellData("Financial_Institution", "Corporate_Structure", rowNum);	
				String TAX_Identification_Number = reader.getCellData("Financial_Institution", "TAX_Identification_Number", rowNum);	
				String OmniBus_Account_Number = reader.getCellData("Financial_Institution", "OmniBus_Account_Number", rowNum);	
				String Special_Instructions = reader.getCellData("Financial_Institution", "Special_Instructions", rowNum);	
				String Omni_Serve = reader.getCellData("Financial_Institution", "Omni_Serve", rowNum);
				String NSCC_ID = reader.getCellData("Financial_Institution", "NSCC_ID", rowNum);
				String SuccessMessage_FailureMessage = reader.getCellData("Financial_Institution", "SuccessMessage_FailureMessage", rowNum);
				String MessageKeyword = reader.getCellData("Financial_Institution", "MessageKeyword", rowNum);
				
				Object ob[] = {Institution_Name,FI_Number,Address_Line1,Address_Line2,City,State,ZIP,ZIP_SUFFIX,Corporate_Structure,TAX_Identification_Number,OmniBus_Account_Number,Special_Instructions,Omni_Serve,NSCC_ID,SuccessMessage_FailureMessage,MessageKeyword};
				myData.add(ob);
			}
			return myData;
		}
		//======================================================================================================================
	// End Of Class
}