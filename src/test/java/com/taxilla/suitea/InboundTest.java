package com.taxilla.suitea;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.taxilla.Baseclass.BaseClass;
import com.taxilla.Baseclass.SendEmail;
import com.taxilla.utilities.Constants;
import com.taxilla.utilities.DataUtils;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class InboundTest extends BaseClass
{   
	
	 
	@Test(dataProvider="getdata")
	   //public void login(String x,String y) 
	   public void inboundtest(Hashtable<String,String> data) throws Exception
	  
	  {  
		  if(data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO))
			  throw new SkipException("Run mode is set to NO");
		  System.out.println("InboundTest");  
		// System.out.println(xls.getRowCount("Keywords"));
		 // ds=new DriverScript();
		  try {
			ds.executeKeywords(xls, testName, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw e;
		} 
		    } 
	  
	  @DataProvider
	  public Object[][] getdata() throws Exception
	  {   
		  System.out.println("Inside the Dataprovider");
		  init();
		  Date dt=new Date();
		  String filepath= dt.toString().replace(":","_").replace(" ","_")+".html";
		    report =new ExtentReports(Projectpath+"//HTMLReports//Reports//"+filepath,false);
	        report.loadConfig(new File(Projectpath+"//extentconfigreport.xml//"));
	        report.addSystemInfo("selenium", "3.11.0").addSystemInfo("Environment","information");
	         

		  ds.setExtentReport(report);
		  test= report.startTest("InboundTest");
		  ds.setExtentTest(test);
		 
		 // Object[][] data=new Object[2][2];
		  //data[0][0]="a";
		  //data[0][1]="b";
		  //data[1][0]="c";
		  //data[1][1]="d";
		  //return data;
		  // String testName="LoginTest";
		   String sheetName="Data";
		   
		   return DataUtils.getTestData(xls, sheetName, testName);
	  }
	  
	
	  @AfterTest
	  public void afterTest() 
	  { 
		   System.out.println("After Test");
	  //test.log(LogStatus.INFO, " testing my report2 "); 
	  report.endTest(test);
	 report.flush();
	 softassert.assertAll();
	 //SendEmail.mail();
	 
	    
	  
	  }
	 

	}
