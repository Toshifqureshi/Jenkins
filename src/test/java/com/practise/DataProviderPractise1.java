package com.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise1 {
	
	@Test(dataProvider="price")
	public void dataprovider1(String phone, int amt)
	{
		System.out.println(phone+ " "+amt);
	}
	@DataProvider(name="phone")
	public Object[][] getdata()
	{
		Object [][] data=new Object[3][2];
		data[0][0]="samsung";
		data [0][1]=1000;
		data[1][0]="apple";
		data[1][1]=2000;
		data[2][0]="nokia";
		data[2][1]=4000;
		return data;
		
	}
	
	@DataProvider(name="price")
	public Object[][] getdata1()
	{
		Object [][] data=new Object[3][2];
		data[0][0]="samsung";
		data [0][1]=2000;
		data[1][0]="apple";
		data[1][1]=3000;
		data[2][0]="nokia";
		data[2][1]=5000;
		return data;
		
	}

}
