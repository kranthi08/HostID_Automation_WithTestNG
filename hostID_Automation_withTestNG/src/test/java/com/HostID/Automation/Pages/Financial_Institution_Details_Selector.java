package com.HostID.Automation.Pages;

import org.openqa.selenium.By;
import com.HostID.Automation.Common.HostID_SharedResources;
import com.HostID.Automation.Common.HostID_Utility;

public class Financial_Institution_Details_Selector 
{
	private HostID_Utility hostutils;
	private HostID_SharedResources hostidResources;
	
	private By INSTITUTION_NMAE;
	private By FI_NUMBER;
	private By ADDRESS_LINE1;
	private By ADDRESS_LINE2;
	private By CITY;
	private By STATE;
	private By ZIP;
	private By ZIP_SUFFIX;
	private By CORPORATE_STRUCTURE;
	private By TAX_iDENTIFICATION_NUMBER;
	private By OMNIBUS_ACCOUNT_NUMBER;
	private By SPECIAL_INSTRUCTIONS;
	private By OMNI_SERVE;
	private By NSCCID;
	private By ADDINSTITUTIONBUTTON;
	private By ACCOUNTEXIST_ERRORMESSAGE;
	private By TAXID_ERRORMESSAGE;
	private By NSCC_ERRORMESSAGE;
	private By SUCCESSMESSAGE;
	private By FINANCIAL_INSTITUTION_DETAILS_HEADER;
	
	public Financial_Institution_Details_Selector(HostID_SharedResources hostidResources,HostID_Utility hostutils)
	{
		this.hostidResources = hostidResources;
		this.hostutils = hostutils;
		Financial_Institution_Details_Objects();
	}
	
	public void Financial_Institution_Details_Objects()
	{
		INSTITUTION_NMAE = By.id("// id for INSTITUTION_NMAE");
		FI_NUMBER = By.id("// id for FI_NUMBER");
		ADDRESS_LINE1 = By.id("// id for ADDRESS_LINE1");
		ADDRESS_LINE2 = By.id("// id for ADDRESS_LINE2");
		CITY = By.id("// id for CITY");
		STATE = By.id("// id for STATE");
		ZIP = By.id("// id for ZIP");
		ZIP_SUFFIX = By.id("// id for ZIP_SUFFIX");
		CORPORATE_STRUCTURE = By.id("// id for CORPORATE_STRUCTURE");
		TAX_iDENTIFICATION_NUMBER = By.id("// id for TAX_iDENTIFICATION_NUMBER");
		OMNIBUS_ACCOUNT_NUMBER = By.id("// id for OMNIBUS_ACCOUNT_NUMBER");
		SPECIAL_INSTRUCTIONS = By.id("// id for SPECIAL_iNSTRUCTIONS");
		OMNI_SERVE = By.id("// id for OMNI_SERVE");
		NSCCID = By.id("// id for NSCCID");
		ADDINSTITUTIONBUTTON = By.id("// id for ADDINSTITUTIONBUTTON");
		ACCOUNTEXIST_ERRORMESSAGE = By.id("id for ACCOUNTEXIST_ERRORMESSAGE");
		TAXID_ERRORMESSAGE = By.id("// id for TAXID_ERRORMESSAGE");
		NSCC_ERRORMESSAGE = By.id("// id for NSCC_ERRORMESSAGE");
		SUCCESSMESSAGE = By.id("// id for SUCCESSMESSAGE");
		FINANCIAL_INSTITUTION_DETAILS_HEADER = By.id("// id for FINANCIAL_INSTITUTION_DETAILS_HEADER");
	}
	public void wait_And_Verify_FinancialInstitution_Header()
	{
		hostutils.waitUntilWebElementExist(FINANCIAL_INSTITUTION_DETAILS_HEADER, 60);
		hostutils.VerifyWebElementExist(FINANCIAL_INSTITUTION_DETAILS_HEADER);
	}
	
	public void enterTextInto_INSTITUTION_NMAE(String institution_name) throws Throwable
	{
		hostutils.setTextOnEdit(INSTITUTION_NMAE, institution_name);
	}
	public void enterTextInto_FI_NUMBER(String institution_number) throws Throwable
	{
		hostutils.setTextOnEdit(FI_NUMBER, institution_number);
	}
	public void enterTextInto_ADDRESS_LINE1(String addressline1) throws Throwable
	{
		hostutils.setTextOnEdit(ADDRESS_LINE1, addressline1);
	}
	public void enterTextInto_ADDRESS_LINE2(String addressline2) throws Throwable
	{
		hostutils.setTextOnEdit(ADDRESS_LINE2, addressline2);
	}
	public void enterTextInto_CITY(String city) throws Throwable
	{
		hostutils.setTextOnEdit(CITY, city);
	}
	public void selectItemFrom_STATE(String state) throws Throwable 
	{
		hostutils.selectItemFromWebList(STATE, state);
	}
	public void enterTextInto_ZIP(String zip) throws Throwable
	{
		hostutils.setTextOnEdit(ZIP, zip);
	}
	public void enterTextInto_ZIP_SUFFIX(String zip_suffix) throws Throwable
	{
		hostutils.setTextOnEdit(ZIP_SUFFIX, zip_suffix);
	}
	public void selectItemFrom_CORPORATE_STRUCTURE(String corporate_structure) throws Throwable
	{
		hostutils.selectItemFromWebList(CORPORATE_STRUCTURE, corporate_structure);
	}
	public void enterTextInto_TAX_IDENTIFICATION_NUMBER(String tax_id_number) throws Throwable
	{
		hostutils.setTextOnEdit(TAX_iDENTIFICATION_NUMBER, tax_id_number);
	}
	public void enterTextInto_OMNIBUS_ACCOUNT_NUMBER(String omnibus_account_number) throws Throwable
	{
		hostutils.setTextOnEdit(OMNIBUS_ACCOUNT_NUMBER, omnibus_account_number);
	}
	public void enterTextInto_SPECIAL_INSTRUCTIONS(String special_instructions) throws Throwable
	{
		hostutils.setTextOnEdit(SPECIAL_INSTRUCTIONS, special_instructions);
	}
	public void selectItemFrom_OMNI_SERVE(String omni_serve) throws Throwable
	{
		hostutils.selectItemFromWebList(OMNI_SERVE, omni_serve);
	}
	public void enterTextInto_NSCCID(String nsccid) throws Throwable
	{
		hostutils.setTextOnEdit(NSCCID, nsccid);
	}
	public void clickOn_ADDINSTITUTIONBUTTON() throws Throwable
	{
		hostutils.clickOnButton(ADDINSTITUTIONBUTTON);
	}
	public String getAccountExist_ErrorMessage()
	{
		hostutils.waitUntilWebElementExist(ACCOUNTEXIST_ERRORMESSAGE, 60);
		return hostutils.getElementText(ACCOUNTEXIST_ERRORMESSAGE);
	}
	public String getTaxID_ErrorMessage()
	{
		hostutils.waitUntilWebElementExist(TAXID_ERRORMESSAGE, 60);
		return hostutils.getElementText(TAXID_ERRORMESSAGE);
	}
	public String get_Nscc_ErrorMessage()
	{
		hostutils.waitUntilWebElementExist(NSCC_ERRORMESSAGE, 60);
		return hostutils.getElementText(NSCC_ERRORMESSAGE);
	}
	public String get_SuccessMessage()
	{
		hostutils.waitUntilWebElementExist(SUCCESSMESSAGE, 60);
		return hostutils.getElementText(SUCCESSMESSAGE);
	}
}
