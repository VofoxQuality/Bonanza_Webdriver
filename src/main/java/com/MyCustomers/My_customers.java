package com.MyCustomers;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Library.UtilityClass;

public class My_customers extends UtilityClass
{
	
	@Test(priority=0)
	public void TCBA01401()
	{
		//Login to the application		
		login(Supertent_Login_id,Supertent_Login_Password);	
		
	}
	
	@Test(priority=1)
	public void TCBA01402()
	{
		
		//Click on "My Customers" from the menu options
		click("//span[@class='nav-label'][contains(text(),'My Customers')]");
		
		//Assert the page header text "My Customers" 
		Assert.assertTrue(getText("//span[@class='au-target'][contains(text(),'My Customers')]").contains("My Customers")," Label-My Customers- not found");
		
		//Assert the grid header text label "Customer List"
		Assert.assertTrue(getText("//h3[@class='panel-title au-target']").contains("Customer List")," Label-Customer List- not found");
		
		//Assert the grid label Customer
		Assert.assertTrue(getText("//div[contains(text(),'Customer')]").contains("Customer List")," Label-Grid label-Customer- not found");
		
		//Assert the grid label-Submitted Date
		Assert.assertTrue(getText("//div[contains(text(),'Submitted Date')]").contains("Submitted Date")," Label-Grid label-Submitted Date- not found");
		
		//Assert the grid label-Business
		Assert.assertTrue(getText("//div[contains(text(),'Business')]").contains("Business")," Label-Grid label-Business- not found");
		
		//Assert the grid label-Home
		
		//Assert the grid label-Status
		
		
		4. Assert the Button label -"Add Customer" (+ button)
		5. Assert the visibility of the pagination
		6. Assert the grid table search functionality.
	
	}

}
