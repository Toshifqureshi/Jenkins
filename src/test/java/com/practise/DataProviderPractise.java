package com.practise;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
	
	@Test(dataProvider="getData")
	public void dataProvider(String phone, int price )
	
	{
		System.out.println(phone +"----"+price);
		
	}
	
	@DataProvider
	public Object [][] getData()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="samsung";
		data [0][1]=1000;
		data[1][0]="apple";
		data[1][1]=2000;
		data [2][0]="nokia";
		data[2][1]=3000;
		return data;
				
	}

}
