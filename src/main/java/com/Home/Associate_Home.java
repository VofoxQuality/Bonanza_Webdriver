package com.Home;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Library.UtilityClass;

public class Associate_Home extends UtilityClass

{
	
	@Test(priority=0)
	public void TCBA01101()
	{
		try 
		{
			//Call TCBA01008() method in the Associate_Login class for the successful login
			Associate_Login login=new Associate_Login();
			login.TCBA01008();
		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}		
	}	
	@Test(priority=1)
	public void TCBA01102()
	{
		try
		{
			//Assert 'Add Customer' button is displayed
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Add Customer')]")).isDisplayed()," Add Customer button not found");
			
			//Assert 'Add Associate' button is displayed
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Add Associate')]")).isDisplayed()," Add Associate button not found");
			
			//Assert 'Invite Associate' button is displayed
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Invite Associate')]")).isDisplayed()," Invite Associate button not found");
			
			//Assert Header title " My Title"
			Assert.assertTrue(getText("//span[contains(text(),'My Title:')]").contains("My Title")," text-My title not found");
			
			//Press "Add Customer" Button
			click("//span[contains(text(),'Add Customer')]");
			
			Thread.sleep(3000);			
			
			//Assert the  header text "Customer Details" in the New Customers page
			Assert.assertTrue(getText("//span[contains(text(),'Customer Details')]").contains("Customer Details")," text-Customer Details not found");
			
			//Press "Home" Button
			click("//span[contains(text(),'Home')]");
			
			Thread.sleep(2000);
			
			// To verify After click on the "Home" button the page should properly redirect to the Home.
			Assert.assertTrue(driver.getTitle().contentEquals("Home | 5-15"));
			
			//click 'Add Associate' button
			click("//span[contains(text(),'Add Associate')]");
			
			Thread.sleep(2000);			
			
			//Assert the  header text "Add Associates" in the MY Associates page
			Assert.assertTrue(getText("//div[@class='page-title']").contains("Add Associates")," text-Add Associates not found");
			
			//Press "Home" Button
			click("//span[contains(text(),'Home')]");
			
			Thread.sleep(2000);
			
			// To verify After click on the "Home" button the page should properly redirect to the Home.
			Assert.assertTrue(driver.getTitle().contentEquals("Home | 5-15"));
			
			//Press "Invite Associate" Button
			click("//span[contains(text(),'Invite Associate')]");
			
			Thread.sleep(2000);			
			
			//Assert the  header text "Invite Friends"
			Assert.assertTrue(getText("//span[contains(text(),'Invite Friends')]").contains("Invite Friends")," text-Invite Friend-not found");
			
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("scroll(0,580)");			
			
			WebDriverWait wt=new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='btnSubmit']"))));
			
			//Press "Send Invite" Button
			click("//button[@id='btnSubmit']");
			
			js.executeScript("scroll(0,0)");	
			
			//verify First Nameis required
			String f1=getText("//label[contains(text(),'First Name')]");
			String f2=getText("//label[contains(text(),'First Name')]/following::p[1]");
			Assert.assertEquals(f1+f2,"First Nameis required");
			
			//verify Last Nameis required
			String L1=getText("//label[contains(text(),'Last Name')]");
			String L2=getText("//label[contains(text(),'Last Name')]/following::p[1]"); 
			Assert.assertEquals(L1+L2,"Last Nameis required");
			
			//verify Email is required
			String E1=getText("//div[@id='rwEmail']//label[@class='au-target'][contains(text(),'Email')]");
			String E2=getText("//div[@id='rwEmail']//label[@class='au-target'][contains(text(),'Email')]/following::p[1]");
			Assert.assertEquals(E1+E2,"Emailis required");
			
			//verify Confirm Email is required
			String C1=getText("//label[contains(text(),'Confirm Email')]");
			String C2=getText("//label[contains(text(),'Confirm Email')]/following::p[1]");
			Assert.assertEquals(C1+C2,"Confirm Emailis required");
			
			js.executeScript("scroll(0,580)");
			
			//Press "Cancel" Button
			click("//button[@id='btnCancel']");
			
			Thread.sleep(2000);  
			
			//Assert application is navigated to My associate page
			Assert.assertTrue(driver.getTitle().contentEquals("My Associates | 5-15")," title My associate | 5-15 not found");			
			
			//Press "Home" Button
			click("//span[contains(text(),'Home')]");
			
			Thread.sleep(3000);
			
			//Assert the page title of the home page
			Assert.assertTrue(driver.getTitle().contentEquals("Home | 5-15"), "title Home | 5-15 not found");
			
			//Click Contract not signed / Rejected total accounts and associate "Counts"
			click("//span[contains(text(),'26')]");
			
			Thread.sleep(2000);
			
			//Assert the page title of the drill-down page is My Downline | 5-15
			Assert.assertTrue(driver.getTitle().contentEquals("My Downline | 5-15")," title My Downline | 5-15 not found");
			
			//To verify the label "Summary" in the summary page
			Assert.assertTrue(getText("//h3[contains(text(),'Summary')]").contains("Summary")," text-Summary not found");
			
		} 
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}	
	}	
	@Test(priority=2)
	public void TCBA01103()
	{		
		try 
		{
			//Press "Log off" Button in the Profile drop down
			click("//span[@class='username']");
			click("//span[contains(text(),'Log Off')]");
			
			Thread.sleep(2000);
			
			//Assert the title of the login page
			Assert.assertTrue(driver.getTitle().contentEquals("Log In | 5-15"),"title Log In not found");
		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}			
	}
}
