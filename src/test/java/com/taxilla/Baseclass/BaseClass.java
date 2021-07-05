package com.taxilla.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.taxilla.Drivers.DriverScript;
import com.taxilla.keywords.GenericKeyword;
import com.taxilla.utilities.ExcelAPI;



public class BaseClass {

	public static String Projectpath=System.getProperty("user.dir");
	public static FileInputStream fis;	
	public static Properties envprop;
	public static Properties prop;
	public ExcelAPI xls;
	public String testName;
	public DriverScript ds;
	public  ExtentReports report;
	public  ExtentTest test;
	
	public  SoftAssert softassert= new SoftAssert(); 
		
		 @BeforeTest
		  public void init() throws Exception 
		 {
			  System.out.println(Projectpath);
			  System.out.println("Before Test...");
			  
			  //To get the package Name
			  String pack=this.getClass().getPackage().getName();
			  System.out.println(pack);
			  
			     String arr[]=this.getClass().getPackage().getName().split("\\.");
				 String suiteName = arr[arr.length-1];
				 System.out.println(suiteName);
				 
			  
			//To get the Current Test Name
			  testName=this.getClass().getSimpleName();
			  System.out.println(testName);
			 
			  
			  
			  fis=new FileInputStream(Projectpath+"\\resources\\environment.properties"); 
			  
			  envprop=new Properties();
			  envprop.load(fis);
			  String e=envprop.getProperty("env");
			 
			  
			  System.out.println(e);
			  
			  fis=new FileInputStream(Projectpath+"\\resources\\"+e+".properties"); 
			  prop=new Properties(); 
			  prop.load(fis); 
			  
			  String url=prop.getProperty("taxillaurl");
			  
			  System.out.println(url);
			  fis=new FileInputStream(Projectpath+"\\log4jconfig.properties");
			  
			  PropertyConfigurator.configure(fis);
			  
			 
								
			  
			  //xls=new ExcelAPI("C:\\Users\\user\\eclipse-workspace\\TaxillaProduct\\Excels\\SuiteA1.xlsx");
			  //xls=new ExcelAPI(envprop.getProperty("suitea_xls"));
			  System.out.println(prop.getProperty(suiteName+"_xls"));
			  xls=new ExcelAPI(prop.getProperty(suiteName+"_xls"));
			// ExcelAPI  excelInputData=new ExcelAPI(prop.getProperty(testName+"_xls"));
			  
			  //initilize object for driver script class
			  ds=new DriverScript();
			  ds.setEnvprop(envprop);
			  ds.setProp(prop);
			  
			  ds.setSoftAssert(softassert);
			  
			  
			  
			  
			 	
			  //Extent Report configuration
			// Date dt=new Date();
				//String filepath= dt.toString().replace(":","_").replace(" ","_")+".html";
			   // report =new ExtentReports(Projectpath+"//HTMLReports//"+filepath,false);
		       // report.loadConfig(new File(Projectpath+"//extentconfigreport.xml//"));
		       // report.addSystemInfo("selenium", "3.11.0").addSystemInfo("Environment","information");
			 
			  
			//  ds.setExtentReport(report);
			//  test= report.startTest(testName);
			  //ds.setExtentTest(test);
			  
			 
			 
			  
			  
			 
		        }

			 
				
		 
		 
		 @AfterMethod
		 public void quit()
		 {
			
			 if(ds!=null)
			 ds.quit();
			
		 }
	}
