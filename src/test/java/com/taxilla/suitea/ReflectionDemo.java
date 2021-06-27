package com.taxilla.suitea;


import java.lang.reflect.Method;


public class ReflectionDemo {
	
	public static void sampleTest()
	{ 
		System.out.println("iam sampletest");
	}
	
	public static void sampleTest1()
	{ 
		System.out.println("iam sampletest1");
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, Exception {
		
		String str="sampleTest1";
		if(str.equals("sampleTest1"))
			sampleTest1();
		ReflectionDemo api=new ReflectionDemo();
		Method mehtod=api.getClass().getMethod(str);
		mehtod.invoke(str);
	
	}
	}


