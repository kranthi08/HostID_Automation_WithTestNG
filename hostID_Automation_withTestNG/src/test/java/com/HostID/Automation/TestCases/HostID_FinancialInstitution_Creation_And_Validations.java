package com.HostID.Automation.TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;
import com.HostID.Automation.Pages.Financial_Institution_Details_Selector;
import com.HostID.Automation.Pages.Financial_Institution_Home_Selector;
import com.HostID.Automation.Pages.HostID_HomePage_Selector;

public class HostID_FinancialInstitution_Creation_And_Validations 
{
	private HostID_SharedResources sharedResources;
	private HostID_Utility hostUtility;
	private HostID_HomePage_Selector hostIDhomepage;
	public String filename = System.getProperty("user.dir")+"\\TestData\\TestData_HostID.xlsx";
	public static int Iteration = 0;
	
	private Financial_Institution_Home_Selector fiHomeSelector;
	private Financial_Institution_Details_Selector fiDetailsSelector;
	
	@BeforeMethod
	public void initClasses() throws Throwable
	{
		System.out.println("HostID_FinancialInstitution_Creation_And_Validations Test Case");
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
		fiHomeSelector = new Financial_Institution_Home_Selector(sharedResources,hostUtility);
		fiDetailsSelector = new Financial_Institution_Details_Selector(sharedResources,hostUtility);
	}
	@BeforeMethod
	//@Parameters({"browser","url","initials","networkPassword"})
	public void performLogin() throws Throwable // String strBrowser,String strUrl,
	{	
		String initials = HostID_Utility.pf.getProperty("HostIDinitial");;
		String networkPassword = HostID_Utility.pf.getProperty("HostIDpassword");;
		Iteration = Iteration + 1;
		System.out.println("============================================================");
		System.out.println("Iteration = "+Iteration);		
		System.out.println("============================================================");
		hostIDhomepage.verifyImageExistance();
		hostIDhomepage.LoginPage_enterTextIntoInitials(initials);
		System.out.println("Initials = "+initials);
		hostIDhomepage.LoginPage_enterTextIntoNetworkPassword(networkPassword);
		System.out.println("Password = "+networkPassword);
		hostIDhomepage.LoginPage_ClickonLogInButton();
		System.out.println("Log in button");
		fiHomeSelector.waitForPayoutslink();
		System.out.println("PayOut Link");
	}
	@AfterMethod
	public void teardown()
	{
		sharedResources.tearDown();
	}
	
	@DataProvider(name = "FinancialInstitutionData")
	public Iterator<Object[]> getFinancialInstitutionTestData()
	{
		ArrayList<Object[]> fiTestData = HostID_Utility.getTestDataFromFinancialInstitutionSheet();
		return fiTestData.iterator();
	}
	
	@Test(dataProvider="FinancialInstitutionData")
	public void fi_Creation_And_Validations(String Institution_Name,String FI_Number,String Address_Line1,String Address_Line2,String City,String State,String ZIP,String ZIP_SUFFIX,String Corporate_Structure,String TAX_Identification_Number,String OmniBus_Account_Number,String Special_Instructions,String Omni_Serve,String NSCC_ID,String SuccessMessage_FailureMessage,String MessageKeyword) throws Throwable
	{
		hostUtility.createFinancialInstitution("Create->Institution");
		System.out.println("Create->Institution");
		fiDetailsSelector.wait_And_Verify_FinancialInstitution_Header();
		System.out.println("wait_And_Verify_FinancialInstitution_Header");
		fiDetailsSelector.enterTextInto_INSTITUTION_NMAE(Institution_Name);
		System.out.println("Institution_Name = "+Institution_Name);
		fiDetailsSelector.enterTextInto_FI_NUMBER(FI_Number);
		System.out.println("FI_Number = "+FI_Number);
		fiDetailsSelector.enterTextInto_ADDRESS_LINE1(Address_Line1);
		System.out.println("Address_Line1 = "+Address_Line1);
		fiDetailsSelector.enterTextInto_ADDRESS_LINE2(Address_Line2);
		System.out.println("Address_Line2 = "+Address_Line2);
		fiDetailsSelector.enterTextInto_CITY(City);
		System.out.println("City = "+City);
		fiDetailsSelector.selectItemFrom_STATE(State);
		System.out.println("State = "+State);
		fiDetailsSelector.enterTextInto_ZIP(ZIP);
		System.out.println("ZIP = "+ZIP);
		fiDetailsSelector.enterTextInto_ZIP_SUFFIX(ZIP_SUFFIX);
		System.out.println("ZIP_SUFFIX = "+ZIP_SUFFIX);
		fiDetailsSelector.selectItemFrom_CORPORATE_STRUCTURE(Corporate_Structure);
		System.out.println("Corporate_Structure = "+Corporate_Structure);
		fiDetailsSelector.enterTextInto_TAX_IDENTIFICATION_NUMBER(TAX_Identification_Number);
		System.out.println("TAX_Identification_Number = "+TAX_Identification_Number);
		fiDetailsSelector.enterTextInto_OMNIBUS_ACCOUNT_NUMBER(OmniBus_Account_Number);
		System.out.println("OmniBus_Account_Number = "+OmniBus_Account_Number);
		fiDetailsSelector.enterTextInto_SPECIAL_INSTRUCTIONS(Special_Instructions);
		System.out.println("Special_Instructions = "+Special_Instructions);
		fiDetailsSelector.selectItemFrom_OMNI_SERVE(Omni_Serve);
		System.out.println("Omni_Serve = "+Omni_Serve);
		fiDetailsSelector.enterTextInto_NSCCID(NSCC_ID);
		System.out.println("NSCC_ID = "+NSCC_ID);
		fiDetailsSelector.clickOn_ADDINSTITUTIONBUTTON();
		System.out.println("clickOn_ADDINSTITUTIONBUTTON");
		switch(MessageKeyword)
		{
		case "AccountExist":
			String expecteAccountExist = SuccessMessage_FailureMessage;
			String actualAccountExist = fiDetailsSelector.getAccountExist_ErrorMessage();
			try
			{
				Assert.assertEquals(actualAccountExist, expecteAccountExist);
				System.out.println("AccountExist = Message Matched");
			}
			catch(Throwable t)
			{
				System.out.println("AccountExist = Message Not Matched");
			}			
			break;
		case "WrongTaxIdNumber":
			String expectedWrongTaxIdNumber = SuccessMessage_FailureMessage;
			String actualWrongTaxIdNumber = fiDetailsSelector.getTaxID_ErrorMessage();
			try
			{
				Assert.assertEquals(actualWrongTaxIdNumber, expectedWrongTaxIdNumber);
				System.out.println("WrongTaxIdNumber = Message Matched");
			}
			catch(Throwable t)
			{
				System.out.println("WrongTaxIdNumber = Message Not Matched");
			}
			break;
		case "WrongNSCCID":
			String expectedWrongNSCCID = SuccessMessage_FailureMessage;
			String actualWrongNSCCID = fiDetailsSelector.get_Nscc_ErrorMessage();
			try
			{
				Assert.assertEquals(actualWrongNSCCID, expectedWrongNSCCID);
				System.out.println("WrongNSCCID = Message Matched");
			}
			catch(Throwable t)
			{
				System.out.println("WrongNSCCID = Message Not Matched");
			}
			break;
		case "Success":
			String expectedSuccessMessage = SuccessMessage_FailureMessage;
			String actualSuccessMessage = fiDetailsSelector.get_Nscc_ErrorMessage();
			try
			{
				Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
				System.out.println("Success = Message Matched");
			}
			catch(Throwable t)
			{
				System.out.println("Success = Message Not Matched");
			}
			break;
		default: 
			System.out.println("Cases not matched");
	    break;
		}
	}
}
