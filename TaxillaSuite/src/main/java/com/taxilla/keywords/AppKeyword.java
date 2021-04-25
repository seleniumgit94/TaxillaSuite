package com.taxilla.keywords;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class AppKeyword extends GenericKeyword{
	
	private String srcBkey=null;
	

	
	public void securityQuestions1() throws InterruptedException
	
	{
		
		String t1= getobject(objectKey).getAttribute("id");
		System.out.println(t1);
		System.out.println("Typing :- " + envprop.getProperty(objectKey) + " Data ---" + data.get(dataKey) );
		if(t1.contains("What") || t1.contains("In")|| t1.contains("Who"))
         {
			 getobject(objectKey).sendKeys(data.get(dataKey));
         } 
		 
		
	}
    public void securityQuestions2() throws InterruptedException
	
	{
		
	
    	String t2= getobject(objectKey).getAttribute("id");
    	System.out.println(t2);
    	System.out.println("Typing :- " + envprop.getProperty(objectKey) + " Data ---" + data.get(dataKey) );
		
    	if(t2.contains("What") || t2.contains("In")|| t2.contains("Who"))
         {
			 getobject(objectKey).sendKeys(data.get(dataKey));
         } 
		
	}
    
   
	
	public void fileUpload() throws InterruptedException, IOException 
	{
		System.out.println("Uploading Input File");
		 Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\InputFile\\fup.exe");
		
	}
	


	
	
		
	public boolean validateTitle() throws InterruptedException, IOException
	{
		System.out.println("Validate Title :- "+ envprop.getProperty(objectKey));
		//log.info("Navigate to url: "+ prop.getProperty(objectKey));
		String actualValue=driver.getTitle();
		String expectedValue=envprop.getProperty(objectKey);
		 boolean titleStatus=verifyElement(actualValue,expectedValue);
		
		if(!titleStatus)
		{
			reportFailure("User is not able to get Expected PageTitle","YES");
			throw new RuntimeException("Not Expected Page Title");
						
		}
		else
		{
			reportSuccess("User is able to get Expected PageTitle","YES");
			
		}
		return titleStatus;
		    
	}
	
	
	public boolean verifyAuthentication() throws InterruptedException, IOException
	{
		System.out.println("Verify Authentication ");
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean auth=verifyElement(actualValue,expectedValue);
		 
		 if(!auth)
			{
				reportFailure("Invalid Login Credentials","YES");
				throw new RuntimeException("authentication failed");
							
			}
			else
			{
				reportSuccess("Authentication Page is getting displayed","YES");
				
			}
		return auth;
	}
	
	public boolean verifyElementEditable() throws InterruptedException, IOException
	{
		System.out.println("Check the Element is enabled/editable ");
		 String actualValue=Boolean.toString(getobject(objectKey).isEnabled());
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean textboxMode=verifyElement(actualValue,expectedValue);
		 
		 if(!textboxMode)
			{
				reportFailure("User is not able to Edit the TextBox","YES");
				throw new RuntimeException("Unable to Edit the Text Box");
							
			}
			else
			{
				reportSuccess("User is able to Edit the TextBox","NO");
				
			}
		return textboxMode;
	}
	
	

	public boolean VerifyLogin() throws InterruptedException, IOException
	{
		System.out.println("Verify Login ");
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean loginStatus=verifyElement(actualValue,expectedValue);
		 
		 if(!loginStatus)
			{
				reportFailure("Login Not successful","YES");
				throw new RuntimeException("Login Failed");
							
			}
			else
			{
				reportSuccess("Login Successful","YES");
				
			}
		return loginStatus;
	}
	
	public boolean VerifyApp() throws InterruptedException, IOException
	{
		System.out.println("Check for App :- "+ envprop.getProperty(objectKey));
		
		String actualValue=  getobject(objectKey).getText();
		String expectedValue=  data.get(dataKey);
		System.out.println(actualValue);
		System.out.println(expectedValue);
		boolean appStatus=verifyElement(actualValue,expectedValue);
		
		
		if(!appStatus)
		{
			reportFailure("User is not able to Select App","YES");
			throw new RuntimeException("App is not Exist");
						
		}
		else
		{
			reportSuccess("User is able to Select App","YES");
			
		}
		return appStatus;
		    
	}
	
	public boolean validateProcessNowButton() throws InterruptedException, IOException
	{
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		
		 boolean processButton=verifyElement(actualValue,expectedValue);
		
		if(!processButton)
		{
			reportFailure("Process Now button is not getting displayed","YES");
			throw new RuntimeException("Process Button is not exist");
			
		}
		else
		{
			reportSuccess("Process Now button is getting displayed","YES");
			
		}
		return processButton;
}
	
	public boolean verifyInitiateProcess() throws InterruptedException, IOException
	{
		System.out.println("Verify InitiateProcess Screen ");
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean initiateStatus=verifyElement(actualValue,expectedValue);
		 
		 if(!initiateStatus)
			{
				reportFailure("Initiate process Screen is not getting displayed","YES");
				throw new RuntimeException("Initiate procress screen is not getting displayed");
							
			}
			else
			{
				reportSuccess("Initiate procress screen is getting displayed","YES");
				
			}
		return initiateStatus;
	}
	
	public boolean verifySelectTransformation() throws InterruptedException, IOException
	{
		System.out.println("Verify whether Select Transformation option is displalyed ");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean selectTransformation=verifyElement(actualValue,expectedValue);
		 
		 if(!selectTransformation)
			{
				reportFailure("Select Transformation option is not getting displayed","YES");
				throw new RuntimeException("Select Transformation option is not getting displayed");
							
			}
			else
			{
				reportSuccess("Select Transformation option is getting displayed","YES");
				
			}
		return selectTransformation;
	}
	
	public boolean SelectTransformation() throws InterruptedException, IOException
	{
		System.out.println("Verify whether transformation is getting displayed or not ");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean Transformation=verifyElement(actualValue,expectedValue);
		 
		 if(!Transformation)
			{
				reportFailure("Transformation is not getting displayed","YES");
				throw new RuntimeException("Transformation is not getting displayed");
							
			}
			else
			{
				reportSuccess("Transformation  is getting displayed","YES");
				
			}
		return Transformation;
	}
	
	public boolean chooseFile() throws InterruptedException, IOException
	{
		System.out.println("Verify whether choose file option is getting displayed or not");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean choosefile=verifyElement(actualValue,expectedValue);
		 
		 if(!choosefile)
			{
				reportFailure("Choose file option is not getting displayed","YES");
				throw new RuntimeException("Choose file option is not getting displayed");
							
			}
			else
			{
				reportSuccess("Choosse file option is getting displayed","YES");
				
			}
		return choosefile;
		}
	
	public boolean verifyFileupload() throws InterruptedException, IOException
	{
		System.out.println("Check attached input file :- "+ envprop.getProperty(objectKey));
		
		String actualValue=  getobject(objectKey).getText();
		String expectedValue=  data.get(dataKey);
		System.out.println(actualValue);
		System.out.println(expectedValue);
		boolean attchmentStatus=verifyElement(actualValue,expectedValue);
		
		
		if(!attchmentStatus)
		{
			reportFailure("Input file is not attached","YES");
			throw new RuntimeException("Input file is not attached");
						
		}
		else
		{
			reportSuccess("Input file is attached","YES");
			
		}
		return attchmentStatus;
		    
	}
	
	public boolean verifyInitiateRequest() throws InterruptedException, IOException
	{
		System.out.println("Request is initiated ");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean initRequest=verifyElement(actualValue,expectedValue);
		 
		 if(!initRequest)
			{
				reportFailure("Request is not getting initiated","YES");
				throw new RuntimeException("Select Transformation option is not getting displayed");
							
			}
			else
			{
				reportSuccess("Request is initiated","YES");
				
			}
		return initRequest;
	}
	
	public boolean verifyProcesses() throws InterruptedException, IOException
	{
		System.out.println("All processes window is getting displayed ");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean allProcesses=verifyElement(actualValue,expectedValue);
		 
		 if(!allProcesses)
			{
				reportFailure("All processes window is not getting displayed","YES");
				throw new RuntimeException("All processes window is not getting displayed");
							
			}
			else
			{
				reportSuccess("All processes window is getting displayed","YES");
				
			}
		return allProcesses;
	}
	
	public boolean verifyInstanceStatus() throws InterruptedException, IOException
	{
		System.out.println("Instance is getting displayed or not..? ");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean instanceStatus=verifyElement(actualValue,expectedValue);
		 
		 if(!instanceStatus)
			{
				reportFailure("Instance is not completed","YES");
				throw new RuntimeException("Instance is not completed");
							
			}
			else
			{
				reportSuccess("Instance is completed","YES");
				
			}
		return instanceStatus;
	}
	
	public String GetPrimaryBusinessKeyData() throws IOException
	{
		    String srcData=  getobject(objectKey).getText();
		 	System.out.println(srcData);
		 	srcBkey=srcData;
		 	
		 	if(srcData==null)
			{
				reportFailure("Not given data for business keys in primary entity","YES");
				throw new RuntimeException("Not given data for business keys in primary entity");
							
			}
			else
			{
				reportSuccess("Data is given for businesskeys in primary entity","YES");
				
			}
			
		 	
		 	return srcData;
	      
	}
	
	public boolean ValidateEventTypeforTrigger() throws IOException
	{
		System.out.println("ValidateEventTypeforTrigger"+ envprop.getProperty(objectKey));
		
		String actualValue=  getobject(objectKey).getText();
		String expectedValue=  data.get(dataKey);
		System.out.println(actualValue);
		System.out.println(expectedValue);
		boolean eventType=verifyElement(actualValue,expectedValue);
		
		
		if(!eventType)
		{
			reportFailure("Check the input file: Event type 'Event Triggered'  is not getting displayed in notifications","YES");
			throw new RuntimeException("Event type 'Event Trigger'  is not getting displayed in notifications");
						
		}
		else
		{
			reportSuccess("Event type 'Event Triggered'  is  getting displayed in notifications","YES");
			
		}
		return eventType;
		    
	}
	
	public boolean ValidateEventTriggerStatus() throws IOException
	{
		System.out.println("ValidateEvent Trigger Status"+ envprop.getProperty(objectKey));
		
		String actualValue=  getobject(objectKey).getText();
		String expectedValue=  data.get(dataKey);
		System.out.println(actualValue);
		System.out.println(expectedValue);
		boolean eventType=verifyElement(actualValue,expectedValue);
		
		
		if(!eventType)
		{
			reportFailure("'Event Trigger'  is not sucessful","YES");
			throw new RuntimeException("'Event Trigger'  is not sucessful");
						
		}
		else
		{
			reportSuccess("'Event Trigger' is sucessful","YES");
			
		}
		return eventType;
		    
	}
	
	public boolean verifyLocation() throws InterruptedException, IOException
	{
		System.out.println("switching location");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean allProcesses=verifyElement(actualValue,expectedValue);
		 
		 if(!allProcesses)
			{
				reportFailure("User is unable to switch the location","YES");
				throw new RuntimeException("User is unable to switch the location");
							
			}
			else
			{
				reportSuccess("User is able to switch the location","YES");
				
			}
		return allProcesses;
	}
	
	public boolean verifyAllInboundTransmission() throws InterruptedException, IOException
	{
		System.out.println("All inbound transmission window is displayed or not");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean allTransmissions=verifyElement(actualValue,expectedValue);
		 
		 if(!allTransmissions)
			{
				reportFailure("All inbound transmission window is not getting displayed","YES");
				throw new RuntimeException("All inbound transmission window is not getting displayed");
							
			}
			else
			{
				reportSuccess("All inbound transmission window is getting displayed","YES");
				
			}
		return allTransmissions;
	}
	
	public Boolean ValidateTargetBusinessKeyData() throws IOException
	{
		    String trgData=  getobject(objectKey).getText();
		 	System.out.println(trgData);
		 	 
			 	
			 	//String srcData=GetPrimaryBusinessKeyData();
			 	System.out.println(srcBkey);
			 	Boolean result=srcBkey.equals(trgData);
			 	
		 	
		 	if(!result)
			{
				reportFailure("Data is not pulled from Source App","YES");
				throw new RuntimeException("Data is not pulled from Source App");
							
			}
			else
			{
				reportSuccess("Data is pulled from Source App using Tenant Based Partition","YES");
				
			}
			
		 	
		 	return result;
	      
	}
	
	

}
