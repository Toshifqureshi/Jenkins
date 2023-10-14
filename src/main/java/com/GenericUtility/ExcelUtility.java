package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String excelRead(String Sheet, int RowNo, int CellNo) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(CommonPath.exelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheet);
	Row r = sh.getRow(RowNo);
	Cell c = r.getCell(CellNo);
	return c.getStringCellValue();
	
	}
	public void excelWrite(String Sheet, int RowNo, int CellNo, String Value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(CommonPath.exelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(Sheet);
		Row r = sh.createRow(RowNo);
		Cell c = r.createCell(CellNo);
		c.setCellValue(Value);
		FileOutputStream fos= new FileOutputStream(CommonPath.exelFilePath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method will load the data from excel sheet to data provider
	 * @param Sheet3
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] dataprovider(String Sheet3) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(CommonPath.exelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet3);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++)
		{
			for (int j=0; j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
