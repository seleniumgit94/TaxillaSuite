package com.taxilla.keywords;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


	public class DependencyTest
	{
	    @Test
	    public void a()
	    {
	        System.out.println("This method depends on testTwo");
	        Assert.assertTrue(false);
	       // SoftAssert s = new SoftAssert();
	       // s.assertTrue(false,"err1");	
	       // System.out.println("This method depends on testTwo1");
			//s.assertAll();
	        
	    }
	     
	   @Test
	    public void b()
	    {
	        System.out.println("This method should execute before testOne");
	        
	    }
	}
