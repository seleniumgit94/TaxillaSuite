package com.taxilla.keywords;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class GenericKeyword {
	
	Properties envprop;
	Properties prop;
	public String testName;
	public ExtentReports report;
	public ExtentTest test;
	public String objectKey;
	public String dataKey;
	public String descriptionkey;
	public Hashtable<String, String> data;
	public WebDriver driver;
	private static final Logger log=Logger.getLogger(GenericKeyword.class);
	public SoftAssert softassert;
	
	
	
	
	
	public Hashtable<String, String> getData() {
		return data;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}
	
	public void setDescription(String descriptionkey) {
		this.descriptionkey = descriptionkey;
	}
	
	
	//Get Extents Reports from BaseClass
	
		public ExtentReports getExtentReport() {
			return report;
		}

		public void setExtentReport(ExtentReports report) {
			this.report = report;
		}
		
		//Get Extents Tests from BaseClass
		
		public ExtentTest getExtentTest() {
			return test;
		}

		public void setExtentTest(ExtentTest test) {
			this.test = test;
		}
		
		public void setTestName(String testName) {
			this.testName = testName;
		}
		
		//Set SoftAsserts
		
		public void setSoftAssert(SoftAssert softassert) {
			this.softassert = softassert;
			
		}

	public void openBrowser() throws InterruptedException
	{
		String browser=data.get(dataKey);
		System.out.println("Opening Browser :- " +browser);
		
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		
	}
	
	public void navigate() throws InterruptedException
	{
		//System.out.println("Navigate to url :- "+ prop.getProperty(objectKey));
		//log.info("Navigate to url: "+ prop.getProperty(objectKey));
		driver.get(prop.getProperty(objectKey));
		
		//Get information into Report
		//test= report.startTest("Navigate to "+ objectKey);
		//test.log(LogStatus.INFO, "Navigate to URL :"+ prop.getProperty(objectKey));
		
		//test= report.startTest(testName);
		
	}
	
	public void click() throws InterruptedException 
	{
		System.out.println("clicking :- " + envprop.getProperty(objectKey));
		//driver.findElement(By.xpath(envprop.getProperty(objectKey))).click();
		getobject(objectKey).click();
		
		
	}
	public void jsClick() throws InterruptedException 
	{
		System.out.println("clicking :- " + envprop.getProperty(objectKey));
		//driver.findElement(By.xpath(envprop.getProperty(objectKey))).click();
	
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getobject(objectKey));		
        
	}
	
	public void type() throws InterruptedException
	{
		System.out.println("Typing :- " + envprop.getProperty(objectKey) + " Data ---" + data.get(dataKey) );
		//driver.findElement(By.xpath(envprop.getProperty(objectKey))).sendKeys(data.get(dataKey));
		getobject(objectKey).sendKeys(data.get(dataKey));
		
		
	}
	
	public void selectDropdown() throws InterruptedException
	{
		System.out.println("Select :- " + envprop.getProperty(objectKey) + " Data ---" + data.get(dataKey) );
		Select dropdown = new Select(getobject(objectKey));  
		dropdown.selectByVisibleText(data.get(dataKey));
		
		
		
	}
	
	public WebElement getobject(String objectKey)
	{
		WebElement element=null;
		if(objectKey.endsWith("_id")) {
			element=driver.findElement(By.id(envprop.getProperty(objectKey)));
		}else if(objectKey.endsWith("_name")) {
			element=driver.findElement(By.className(envprop.getProperty(objectKey)));
		}else if(objectKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(envprop.getProperty(objectKey)));
		}
		
		return element;
	}
	
	public void Wait()
	{
		
		 driver.manage().timeouts().implicitlyWait(Integer.parseInt(envprop.getProperty(objectKey)), TimeUnit.SECONDS);
          
	}
	
	
	public void Delay() throws InterruptedException
	{
		
		Thread.sleep(Integer.parseInt(envprop.getProperty(objectKey)));
	}
	
	public void getReport() throws InterruptedException
	
	{	
		  
			 // test= report.startTest("Enter " + prop.getProperty(objectKey)); 
			 // test.log(LogStatus.INFO, ""+  prop.getProperty(objectKey)+" "+ data.get(dataKey) );
			 // test= report.startTest("Enter " + envprop.getProperty(objectKey)); 
			 // test.log(LogStatus.INFO, ""+  envprop.getProperty(objectKey)+" "+ data.get(dataKey) );
			   
		  if (!descriptionkey.contains("Delay"))
				  if(!descriptionkey.contains("Wait"))
		 
			  
		  {
			   //test= report.startTest(testName);
		       String chkdatakey=data.get(dataKey);
		       if(chkdatakey!=null)
		       {		   
			    test.log(LogStatus.INFO, ""+  descriptionkey +"  "+data.get(dataKey));
			   // test.log(LogStatus.INFO, data.get(dataKey) );
			  
		       } else 
		       {
		    	 
		       test.log(LogStatus.INFO, ""+descriptionkey);
		      
		      // System.out.println(prop.getProperty(objectKey));
		       //System.out.println("testdata="+(envprop.getProperty(objectKey)) != null? envprop.getProperty(objectKey) : prop.getProperty(objectKey));
		       }   
		   
		  }
		
	}
	
	//***********verify element
	public  boolean verifyElement(String actualValue ,String expectedValue) {
		
		//String actualink=driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).getAttribute("innerHTML");
		System.out.println("Actual :"+actualValue );
		System.out.println("Expected Link :"+expectedValue );
		if(actualValue.equals(expectedValue))
			return true;			
		else			
			return false;
		
		
	}
	
	//***************Reporting*************
	
	public  void reportSuccess(String successMsg,String setScreenshot) throws IOException {
		test.log(LogStatus.PASS, successMsg);
		System.out.println("success");
		if(setScreenshot=="YES")
		takeSuccessScreenshot();
		
	}

	public  void reportFailure(String FailureMsg,String setScreenshot) throws IOException {
		test.log(LogStatus.FAIL, FailureMsg);
		System.out.println("failure");
		if(setScreenshot=="YES")
		takeFailScreenshot();		
		
	}
	
	public  void takeSuccessScreenshot() throws IOException {
		  Date dt=new Date();
		  SimpleDateFormat dateformat= new SimpleDateFormat("dd_MM_YYYY hh_mm_ss");
		  File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(scrnshot, new File(System.getProperty("user.dir")+"\\HTMLReports\\Screenshots\\Success\\"+"img1_"+dateformat.format(dt)+".jpeg"));
		  test.log(LogStatus.INFO, "screenshot-->"+test.addScreenCapture(System.getProperty("user.dir")+"\\HTMLReports\\Screenshots\\Success\\"+"img_"+dateformat.format(dt)+".jpeg"));
		
		  
		  System.out.println(System.getProperty("user.dir")+"\\HTMLReports\\Screenshots\\Success\\"+"img_"+dateformat.format(dt)+".jpeg");
		
		
	}
	public  void takeFailScreenshot() throws IOException {
		  Date dt=new Date();
		  SimpleDateFormat dateformat= new SimpleDateFormat("dd_MM_YYYY hh_mm_ss");
		  
		  
		  File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(scrnshot, new File(System.getProperty("user.dir")+"\\HTMLReports\\Screenshots\\Failure\\"+"img1_"+dateformat.format(dt)+".jpeg"));
		  test.log(LogStatus.INFO, "screenshot-->"+test.addScreenCapture(System.getProperty("user.dir")+"\\HTMLReports\\Screenshots\\Failure\\"+"img_"+dateformat.format(dt)+".jpeg"));
		 
		  System.out.println(System.getProperty("user.dir")+"\\HTMLReports\\Screenshots\\Failure\\"+"img_"+dateformat.format(dt)+".jpeg");
		  
		  

		
	}
	
	

	
	public void quit()
	{
		if(driver!=null)
		driver.quit();
	}

}
