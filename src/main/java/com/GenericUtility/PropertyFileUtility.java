package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String propertyFile(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(CommonPath.propertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
		
		
	}

}
