package com.MyCustomers;

import org.apache.bcel.generic.LMUL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Library.UtilityClass;

public class My_customers extends UtilityClass
{
	String limit_101="1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1234567890abcdefghij1";
	
	@Test(priority=0)
	public void TCBA01401()
	{
		try
		{
			//Login to the application		
			login(Supertent_Login_id,Supertent_Login_Password);
		} 
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}	
		
	}
	
	@Test(priority=1)
	public void TCBA01402()
	{
		
		try
		{
			//Click on "My Customers" from the menu options
			click("//span[@class='nav-label'][contains(text(),'My Customers')]");
			
			//Assert the page header text "My Customers" 
			Assert.assertTrue(getText("//span[@class='au-target'][contains(text(),'My Customers')]").contains("My Customers")," Label-My Customers- not found");
			
			//Assert the grid header text label "Customer List"
			Assert.assertTrue(getText("//h3[@class='panel-title au-target']").contains("Customer List")," Label-Customer List- not found");
			
			//Assert the grid label Customer
			Assert.assertTrue(getText("//div[contains(text(),'Customer')]").contains("Customer")," Label-Grid label-Customer- not found");
			
			//Assert the grid label-Submitted Date
			Assert.assertTrue(getText("//div[contains(text(),'Submitted Date')]").contains("Submitted Date")," Label-Grid label-Submitted Date- not found");
			
			//Assert the grid label-Business
			Assert.assertTrue(getText("//div[contains(text(),'Business')]").contains("Business")," Label-Grid label-Business- not found");
			
			//Assert the grid label-Home
			Assert.assertTrue(getText("//div[contains(text(),'Home')]").contains("Home")," Label-Grid label-Home- not found");
			
			//Assert the grid label-Status
			Assert.assertTrue(getText("//div[contains(text(),'Status')]").contains("Status")," Label-Grid label-Status- not found");
			
			//Assert the Button label -"Add Customer" (+ button)
			Assert.assertTrue(getText("//a[@class='au-target']//span[@class='au-target'][contains(text(),'Add Customer')]").contains("Add Customer")," Button-Add Customer- not found");
			
            //Assert the visibility of the pagination
			Assert.assertTrue(driver.findElement(By.xpath("//span[@class='e-pagermsg']")).isDisplayed()," Pagination not found");
			
            //Assert the grid table search functionality.
			type("//input[@id='gvOrders_searchbar']","Shinto Test-2018");			
			//click search button
			click("//*[@id='gvOrders_search']/a");
			//Assert the search result
			Assert.assertTrue(getText("//span[contains(text(),'Shinto Test-2018')]").contains("Shinto Test-2018"),"  Search failed- Shinto Test-2018 not found");
		} 
		
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	
	}
	
	@Test(priority=2)
	public void TCBA01403()
	{
		try
		 
		{
			//Click Add Customer
			click("//a[@class='au-target']//span[@class='au-target'][contains(text(),'Add Customer')]");
			
			//Assert application navigated to Customer Details Page
			Assert.assertTrue(driver.getTitle().contentEquals("My Customers | 5-15")," title My Customers | 5-15 not found");
			
			//Assert labels -Customer Details  Billing Information (This is the information we will use to create the monthly bill)
			Assert.assertTrue(getText("//div[@class='billing-info au-target']").contains("Billing Information (This is the information we will use to create the monthly bill)"),"  label Billing Information (This is the information we will use to create the monthly bill)-notfound");

            //2. Assert the Button - Next -- Add Utilty Data 
			Assert.assertTrue(driver.findElement(By.xpath("//a[@class='au-target']//span[@class='au-target'][contains(text(),'Next -- Add Utilty Data')]")).isDisplayed()," Next -- Add Utilty Data - button not found");
			
			//3 Assert the button-CANCEL
			Assert.assertTrue(driver.findElement(By.xpath("//a[@class='au-target']//span[@class='au-target'][contains(text(),'Cancel')]")).isDisplayed()," CANCEL-  button not found");

            //selecting 'Individual checkbox
			if(driver.findElement(By.xpath("//input[@id='rdbIndividual']")).isSelected()==false)
			{
				click("//input[@id='rdbIndividual']");			
			}
			
			// Assert Label-Customer Type 
			Assert.assertTrue(getText("//h3[contains(text(),'Customer Type')]").contains("Customer Type"),"  label Customer Type-notfound");
			
			// Assert Label-Country
			Assert.assertTrue(getText("//label[@id='lblCountry']").contains("Country"),"  label Country-notfound");
			
			// Assert Label-First Name
			Assert.assertTrue(getText("//label[@id='lblFirstName']").contains("First Name"),"  label First Name-notfound");
			
			// Assert LabelLast Name
			Assert.assertTrue(getText("//label[@id='lblLastName']").contains("Last Name"),"  label Last Name-notfound");
			
			// Assert Label-Street Part-Street Part
			Assert.assertTrue(getText("//label[@id='lblStreetPart']").contains("Street Part"),"  label Street Part-notfound");
			
			// Assert Label-Street PartAddress
			Assert.assertTrue(getText("//label[@id='lblAddress']").contains("Address"),"  label Address-notfound");
			
			// Assert Label-Street No
			Assert.assertTrue(getText("//label[@id='lblStreetNo']").contains("Street No"),"  label Street No-notfound");
				
			// Assert Label-Province 
			Assert.assertTrue(getText("//label[@id='lblStateCode']").contains("Province"),"  label Province -notfound");
			
			// Assert Label-City 
			Assert.assertTrue(getText("//label[@id='lblCity']").contains("City"),"  label City -notfound");
					
			// Assert Label-Zip
			Assert.assertTrue(getText("//label[@id='lblZip']").contains("Zip"),"  label Zip -notfound");
			
			// Assert Label-Email 
			Assert.assertTrue(getText("//label[@id='lblEmail']").contains("Email"),"  label Email -notfound");
			
			// Assert Label-PEC Email (Optional)
			Assert.assertTrue(getText("//label[@id='lblPECEmail']").contains("PEC Email (Optional)"),"  label PEC Email (Optional)-notfound");
			
			// Assert Label-Cell Phone Number 
			Assert.assertTrue(getText("//label[@id='lblCellPhoneNumber']").contains("Cell Phone Number"),"  label Cell Phone Number -notfound");
			
			// Assert Label-Home number if no cellphone , Birth Date (MM/DD/YYYY) , Birth Country , IBAN , Comment , Add any comments you feel IGL should know about customer, if none, leave blank.



			//All Empty fields
			//Click to Next -- Add Utilty Data button
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("scroll(0,1000)");			
			click("//button[@class='btn btn-primary au-target']");
			
			js.executeScript("scroll(0,0)");	
			//Assert error message First Name is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("First Name is required"),"  Meassge-First Name is required-notfound");
			
			//Assert error message Last Nameis required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Last Name is required"),"  Meassge-Last Name is required-notfound");
			
			//Assert error message Email is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Email is required"),"  Meassge-Email is required-notfound");
			
			//Assert error message Cell Phone number is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Cell Phone Number is required"),"  Meassge-Cell Phone Number is requirednotfound");
			
			//Assert error message Home number if no cellphone is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Home number if no cellphone is required"),"  Meassge-Home number if no cellphone is required-notfound");
			
			//Assert error message IBAN is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("IBAN is required"),"  Meassge-IBAN is required-notfound");
			
			//Assert error message Address is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Address is required"),"  Meassge-Address is required-notfound");
			
			//Assert error message Street No is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Street No is required"),"  Meassge-Street No is required-notfound");
			
			//Assert error message Zip is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Zip is required"),"  Meassge-Zip is required-notfound");
			
			//Assert error message Province is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Province is required"),"  Meassge-Province is required-notfound");
			
			//Assert error message City is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("City is required"),"  Meassge-City is required-notfound");
			
			//Assert error message Birth Date is required
			Assert.assertTrue(getText("//div[@class='au-animate']").contains("Birth Date is required"),"  Meassge-Birth Date is required-notfound");		
					
			// Check Field Validations			
			driver.navigate().refresh();
			
			//1.First Name must be no more than 100 characters.
			type("//input[@id='txtFirstName']",limit_101);
			click("//label[@id='lblFirstName']");
			String F1=getText("//label[@id='lblFirstName']");
			String F2=getText("//label[@id='lblFirstName']/following::p[1]");			
			Assert.assertEquals(F1+F2, "First Namemust be no more than 100 characters.");
			
			//Last Name must be no more than 100 characters.
			type("//input[@id='txtLastName']",limit_101);
			click("//label[@id='lblLastName']");
			String L1=getText("//label[@id='lblLastName']");
			String L2=getText("//label[@id='lblLastName']/following::p[1]");			
			Assert.assertEquals(L1+L2, "Last Namemust be no more than 100 characters.");
			
			//Address = 151 characters.
			type("//input[@id='txtAddress']",limit_101+limit_101);			
			click("//label[@id='lblLastName']");
			String A1=getText("//label[@id='lblAddress']");
			String A2=getText("//label[@id='lblAddress']/following::p[1]");			
			Assert.assertEquals(A1+A2, "Addressmust be no more than 150 characters.");
			
			
			//.Street No = 11 characters.
			type("//input[@id='txtStreetNum']",limit_101);
			click("//label[@id='lblLastName']");
			String S1=getText("//label[@id='lblStreetNo']");
			String S2=getText("//label[@id='lblStreetNo']/following::p[1]");			
			Assert.assertEquals(S1+S2, "Street Nomust be no more than 10 characters.");
			
			//Zip = 6 characters.
			type("//input[@id='txtZip']",limit_101);
			click("//label[@id='lblLastName']");
			String Z1=getText("//label[@id='lblZip']");
			String Z2=getText("//label[@id='lblZip']/following::p[1]");			
			Assert.assertEquals(Z1+Z2, "Zipmust be no more than 5 characters.");
			
			js.executeScript("scroll(0,500)");	
			
			//Email Invalid format
			type("//input[@id='txtEmail']","invalidddddd####");
			click("//label[@id='lblZip']");
			String E1=getText("//label[@id='lblEmail']");
			String E2=getText("//label[@id='lblEmail']/following::p[1]");			
			Assert.assertEquals(E1+E2, "Emailinvalid email format");
			
			//Email Invalid format
			type("//input[@id='txtPECEmail']","invalidddddd####");
			click("//label[@id='lblEmail']");
			String P1=getText("//label[@id='lblPECEmail']");
			String P2=getText("//label[@id='lblEmail']/following::p[1]");			
			Assert.assertEquals(P1+P2, "PEC Email (Optional)invalid email format");
			
			//Cell Phone Number must be no more than 15 characters.
			type("//input[@id='txtCellPhoneNumber']","12345678901234567");
			click("//label[@id='lblCellPhoneNumber']");
			String C1=getText("//label[@id='lblCellPhoneNumber']");
			String C2=getText("//label[@id='lblCellPhoneNumber']/following::p[1]");			
			Assert.assertEquals(C1+C2, "Cell Phone Numbermust be no more than 15 characters.");
			
			//Home Number must be no more than 20 characters.
			type("//input[@id='txtHomeNumber']","123456789012345678901");
			click("//label[@id='lblCellPhoneNumber']");
			String H1=getText("//label[@id='lblHomeNumber']");
			String H2=getText("//label[@id='lblHomeNumber']/following::p[1]");			
			Assert.assertEquals(H1+H2, "Home number if no cellphonemust be no more than 20 characters.");
			
			//IBAN invalid format
			type("//input[@id='txtIBAN']","123456789012345678901");
			click("//label[@id='lblIBAN']");
			String I1=getText("//label[@id='lblIBAN']");
			String I2=getText("//label[@id='lblIBAN']/following::p[1]");			
			Assert.assertEquals(I1+I2, "IBANinvalid format");
			
			//IBAN must be no more than 1000 characters.
			type("//input[@id='txtIBAN']",limit_101+limit_101+limit_101+limit_101+limit_101+limit_101+limit_101+limit_101+limit_101+limit_101);
			click("//label[@id='lblIBAN']");
			String IB1=getText("//label[@id='lblIBAN']");
			String IB2=getText("//label[@id='lblIBAN']/following::p[1]");			
			Assert.assertEquals(IB1+IB2, "IBANinvalid format.");
			
			js.executeScript("scroll(0,100)");
			
			//.Zip : Zip can only contain digits
			driver.findElement(By.xpath("//input[@id='txtZip']")).clear();
			type("//input[@id='txtZip']","fgfgfgfgfgfg");
			click("//label[@id='lblZip']");
			String Zd1=getText("//label[@id='lblZip']");
			String Zd2=getText("//label[@id='lblZip']/following::p[1]");			
			Assert.assertEquals(Zd1+Zd2, "Zipmust be no more than 5 characters");
		} 
		
		catch (Exception e)
		
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	
	
	}

}
