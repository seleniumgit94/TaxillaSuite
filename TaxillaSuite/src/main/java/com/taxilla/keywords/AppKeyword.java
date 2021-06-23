package com.taxilla.keywords;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opencsv.CSVReader;
import com.relevantcodes.extentreports.LogStatus;
import com.taxilla.utilities.Constants;
import com.taxilla.utilities.ExcelAPI;


import junit.framework.Assert;

public class AppKeyword extends GenericKeyword{
	
	private String srcBkey=null;
	//private String[] str1=new String[30];
	//private String[] str2=new String[30];
	private List<String> WebTableList = new ArrayList<String>();
	private List<String> InputFileList = new ArrayList<String>();
	
	

	
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
		//Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\InputFile\\fup.exe");
		 Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\InputFile\\"+envprop.getProperty(objectKey));
		
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
		
		String actualValue=getobject(objectKey).getText();
		String expectedValue=data.get(dataKey);
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
	
	public boolean verifyEntitiesList() throws InterruptedException, IOException
	{
		System.out.println("Verify whether user is able to get the page to give the data for entities");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean entityList=verifyElement(actualValue,expectedValue);
		 
		 if(!entityList)
			{
				reportFailure("User is not getting the page to check the data for Entities","YES");
				throw new RuntimeException("User is not getting the page to check the data for Entities");
							
			}
			else
			{
				reportSuccess("User is getting the page to check the data for Entities","YES");
				
			}
		return entityList;
	}
	
	public boolean validateFieldsExistence() throws InterruptedException, IOException
	{
		System.out.println("Verify whether user is able to get the fields in UI after clicking on entity");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean fieldsExistence=verifyElement(actualValue,expectedValue);
		 
		 if(!fieldsExistence)
			{
				reportFailure("User is not getting the fields in UI after clicking on entity","YES");
				throw new RuntimeException("User is not getting the fields in UI after clicking on entity");
							
			}
			else
			{
				reportSuccess("User is getting the fields in UI after clicking on entity","YES");
				
			}
		return fieldsExistence;
	}
	
	public boolean verifySelectDropdown() throws InterruptedException, IOException
	{
		System.out.println("Verify whether user is able to get the dropdown to select fields");
		
		 String actualValue=Boolean.toString(driver.getPageSource().contains(envprop.getProperty(objectKey)));
		 String expectedValue="true";
		 System.out.println(actualValue);
		 System.out.println(expectedValue);
		 boolean selectDropdown=verifyElement(actualValue,expectedValue);
		 
		 if(!selectDropdown)
			{
				reportFailure("Dropdown is not getting displayed to select fields","YES");
				throw new RuntimeException("Dropdown is not getting displayed to select fields");
							
			}
			else
			{
				reportSuccess("Dropdown is getting displayed to select fields","YES");
				
			}
		return selectDropdown;
	}
	public void GetNonPrimaryEntityData() throws Exception
	{
		WebTableList.clear();
		System.out.println("Get data in Non primary entity");
		List<WebElement> tr_collection =  driver.findElements(By.xpath(envprop.getProperty(objectKey)));
		System.out.println("Number of rows in this table="+tr_collection.size());
				
		int row_num,col_num;
		row_num=1;
		
		
		for(WebElement trElement:tr_collection)
		{
			
			List<WebElement> td_collection =  trElement.findElements(By.xpath("td"));
			col_num=1;
			
			
			for(WebElement tdElement:td_collection)
			{
				if(row_num<tr_collection.size()) 
				if(col_num>1 && col_num<5 && row_num>6) 
				{
					
			   System.out.println("Row # "+row_num+",col #"+col_num+",Text="+tdElement.getText());
					// System.out.println(tdElement.getText());
				
				 
			   WebTableList.add(tdElement.getText());
				
	 			
				}
				
			col_num++;
			}
			row_num++;
				
		}
		System.out.println("string value="+WebTableList);
		
		
	}
	@Test
	public void readExcelData() throws Exception
	{
		InputFileList.clear();
		System.out.println("Read Data from Excel File");	
		System.out.println(prop.getProperty(testName+"_xlsx"));		
		
		ExcelAPI  excelInputData=new ExcelAPI(prop.getProperty(testName+"_xlsx"));		
		

		int excelRows = excelInputData.getRowCount(Constants.PERSONAL_SHEET);
		System.out.println("Rows :" + excelRows);
		int excelCols = excelInputData.columnCount(Constants.PERSONAL_SHEET);
		System.out.println("Columns :" + excelCols);
		
		for(int rNum=1;rNum<excelRows;rNum++)
		{
			for(int cNum=0;cNum<excelCols;cNum++) 
			{
			String personal = excelInputData.getCellData(Constants.PERSONAL_SHEET, cNum, rNum);
			System.out.println(personal);
			
			InputFileList.add(personal);
			
			}
		}
		
	}
	
	
	public void validateUploadData() throws IOException
	{   
		System.out.println(WebTableList);
		System.out.println(InputFileList);
				
		 if( WebTableList.size() == InputFileList.size())
	        {
	            for(int i=0;i<WebTableList.size();++i)
	            {
	                if(!(WebTableList.get(i).equals(InputFileList.get(i))))
	                {
	                  System.out.println("Fail");  
	                  InputFileList.clear();
	                  WebTableList.clear();
	                  softassert.assertTrue(false);
	                  reportFailure("Input file data and uploaded data is not same ","YES");
	               	                	               
	  				//throw new RuntimeException("Input file data and uploaded data is not same");
	                }
	            }
	        }
	        else
	        {
	            System.out.println("Invalid Data");
	            InputFileList.clear();
	            WebTableList.clear();
	            softassert.assertTrue(false);
	            reportFailure("Invalid data ","YES");
  				//throw new RuntimeException("invalid data size");
	           
	            
                
	        }
	        System.out.println("Pass");
	        InputFileList.clear();
	        WebTableList.clear();
	        reportSuccess("Input file data and uploaded data is same","YES");
	    }
	
	
	public void readXMLData() throws ParserConfigurationException, SAXException, IOException 
	{
		InputFileList.clear();
		DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dBfactory.newDocumentBuilder();
		// Fetch XML File
		Document document = builder.parse(new File(prop.getProperty(testName+"_xml")));
		//Document document = builder.parse(new File("C:\\Users\\user\\eclipse-workspace\\TaxillaSuite\\InputFile\\InboundTestSuiteA_InputFiles\\xml_asset.xml"));
		document.getDocumentElement().normalize();
		//Get root node
		Element root = document.getDocumentElement();
		NodeList nList = document.getElementsByTagName("entity2");
		//List<String> StrList3 = new ArrayList<String>();
		for (int i = 0; i < nList.getLength(); i++)
		{
			Node node = nList.item(i);
			System.out.println();    //Just a separator
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				
				Element element = (Element) node;
				
				//System.out.println("field1 : "  + element.getElementsByTagName("f1").item(0).getTextContent());
				//System.out.println("field2 : "   + element.getElementsByTagName("f2").item(0).getTextContent());
				
				//str3[j++]=element.getElementsByTagName("f1").item(0).getTextContent();
				//str3[j++]=element.getElementsByTagName("f2").item(0).getTextContent();
				
				InputFileList.add(element.getElementsByTagName("f1").item(0).getTextContent());
				InputFileList.add(element.getElementsByTagName("f2").item(0).getTextContent());
				InputFileList.add(element.getElementsByTagName("f3").item(0).getTextContent());
				 
				
			}
			
		}
		 System.out.println(InputFileList);		
		
		
	}
	
	public void readJSONData()  
	{
		 InputFileList.clear();
         JSONParser parser = new JSONParser();
	      try {
	    	  Object obj = parser.parse(new FileReader(prop.getProperty(testName+"_json")));
	    	 JSONArray RootArrayObject = (JSONArray)obj;
	    	 JSONObject Root = (JSONObject) RootArrayObject.get(0); 
	         String f1 = (String)Root.get("errorCode");
	         String f2 = (String)Root.get("success");
	         JSONArray SubEntityObject = (JSONArray)Root.get("result");
	        // System.out.println("Name: " + f1);
	        // System.out.println("Course: " + f2);
	        // System.out.println("result:");
	         //List<String> JsonList = new ArrayList<String>();
	         for(int j=0;j<SubEntityObject.size();j++)
	         {
	        	 JSONObject SubEntity = (JSONObject) SubEntityObject.get(j); 
	        	 
	        	 InputFileList.add((String) SubEntity.get("stjCd"));
	        	 InputFileList.add((String) SubEntity.get("dty"));
	        	 InputFileList.add((String) SubEntity.get("lgnm"));
	        	 
	        	 
	        	 //String sf1 = (String) SubEntity.get("stjCd");
	        	 //String sf2 = (String) SubEntity.get("dty");
	        	 //String sf3 = (String) SubEntity.get("lgnm");
	        	// System.out.println(sf1);
	        	// System.out.println(sf2);
	        	 //System.out.println(sf3);
	         }
	         System.out.println(InputFileList);
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
	

	public void readCSVData() throws IOException  
	{
		 InputFileList.clear();
         
		 //Instantiating the CSVReader class
	       CSVReader reader = new CSVReader(new FileReader(prop.getProperty(testName+"_csv")));
	       String line[];
	       Boolean FirstRecord=true;
	      // List<String> CsvList = new ArrayList<String>();
	      while ((line = reader.readNext()) != null) {
	    	  if (FirstRecord!=true) {
	         for(int i = 0; i<line.length; i++) 
	         {
	        	
	        	
	        	 InputFileList.add(line[i]);
	        	 
	          }
	        
	         
	      } else
	      {
	    	  FirstRecord=false;
	      }
	    	  
	      }
	      System.out.println(InputFileList);
	}
	
	
	
	public void readTXTData() throws IOException  
	{      InputFileList.clear();
		 //Instantiating the CSVReader class
		   CSVReader reader = new CSVReader(new FileReader(prop.getProperty(testName+"_txt")));
	       String line[];
	       Boolean FirstRecord=true;
	      // List<String> CsvList = new ArrayList<String>();
	      while ((line = reader.readNext()) != null) {
	    	  if (FirstRecord!=true) {
	         for(int i = 0; i<line.length; i++) 
	         {
	        	
	        	
	        	 InputFileList.add(line[i]);
	        	 
	          }
	        
	         
	      } else
	      {
	    	  FirstRecord=false;
	      }
	    	  
	      }
	      System.out.println(InputFileList);
	}
	
	
	

}
