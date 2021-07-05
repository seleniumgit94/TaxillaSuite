package com.taxilla.Drivers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.taxilla.keywords.AppKeyword;
import com.taxilla.utilities.Constants;
import com.taxilla.utilities.ExcelAPI;

public class DriverScript {
	
	Properties envprop;
	Properties prop;
	ExtentReports report;
	ExtentTest test;
	AppKeyword app;
	String testName;
	SoftAssert softassert;
	
	
	public Properties getEnvprop() {
		return envprop;
	}

	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
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
	



	
	public void quit()
	{
		if(app!=null)
		app.quit();
	}

	
	public void executeKeywords(ExcelAPI xls,String testName,Hashtable<String, String> testData) throws Exception
	{
		
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		System.out.println("Rows :" + rows);
		
		app=new AppKeyword();
		//send the prop  & envprop to keyword class
				app.setEnvprop(envprop);
				app.setProp(prop);
				app.setData(testData);
		//send the extent report  & extent test to keyword class	
				app.setExtentReport(report);
				app.setExtentTest(test);
				app.setTestName(testName);
		//send the softassert to keyword class	
				app.setSoftAssert(softassert);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.TCID_COL, rNum);
			if(tcid.equals(testName))
			{
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.KEYWORD_COL, rNum);
				String objectKey = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.OBJECT_COL, rNum);
				String dataKey = xls.getCellData(Constants.KEYWORDS_SHEET,Constants.DATA_COL, rNum);
				String descriptionkey = xls.getCellData(Constants.KEYWORDS_SHEET,Constants.DESCRIPTION_COL, rNum);
				
			
			String data=testData.get(dataKey);
			//System.out.println("show details "+envprop.getProperty(objectKey));
			//System.out.println(tcid +"----"+keyword + "----" +envprop.getProperty(objectKey)+"----" +data);
			app.setDataKey(dataKey);
			app.setObjectKey(objectKey);
			app.setDescription(descriptionkey);
			
			
				/*
				 * if(keyword.equals("openBrowser")) app.openBrowser(); else
				 * if(keyword.equals("navigate")) app.navigate(); else
				 * if(keyword.equals("click")) app.click(); else if(keyword.equals("type"))
				 * app.type(); else if(keyword.equals("validateLogin")) app.validateLogin();
				 * else if(keyword.equals("validateTitle")) app.validateTitle();
				 */
			
			
			Method method;
		   // System.out.println(keyword+"..."+objectkey);
		    try {
		    	Method getReport=app.getClass().getMethod("getReport");
				getReport.invoke(app);
				method=app.getClass().getMethod(keyword);
				method.invoke(app);
				//Method getReport=app.getClass().getMethod("getReport");
				//getReport.invoke(app);
			  // if(Boolean.FALSE.equals(i))
				  // break;
			} 
		    
		    catch (Exception e) {
				
		    	
				//e.printStackTrace();
				
				//Method getReport=app.getClass().getMethod("getReport");
				//getReport.invoke(app);
				throw e;
			}
		   
			
			
			
			}
		}
	}

}
