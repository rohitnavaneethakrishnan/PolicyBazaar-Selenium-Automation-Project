package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Pages.TravelInsurancePage;
@Test(priority=1)
public class WriteExcel extends TravelInsurancePage{
	 public WriteExcel() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	String userDir = System.getProperty("user.dir");
	 String filePath = userDir + "\\src\\test\\java\\resources\\TravelInsuranceProducts.xlsx";
	public void writeproducts() throws IOException {
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("travelinsurance");
		Row row1 = sheet.createRow(0);
		Row row2 = sheet.createRow(1);
		int size = travelInsuranceProviderNames.size();
		int len = travelInsurancePrice.size();
	   int 	colnum1 =0;
		for(int i=0;i<size;i++) {
		row1.createCell(colnum1++).setCellValue(travelInsuranceProviderNames.get(i));
		}
		int colnum2 =0;
		for(int j=0;j<len;j++) {
			row2.createCell(colnum2++).setCellValue(travelInsurancePrice.get(j));
		}
		FileOutputStream out = new FileOutputStream(src);
		wb.write(out);
		wb.close();
	}
	/*
	@Test(priority=2)
    public void travelinsuranceprice() throws IOException {
    	String userDir = System.getProperty("user.dir");
   	    String filePath = userDir + "\\src\\test\\java\\resources\\TravelInsuranceProducts.xlsx";
    	File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int size = travelInsurancePrice.size();
	   int 	colnum =0;
		for(int i=0;i<size;i++) {
		sheet.getRow(1).getCell(0).setCellValue(travelInsurancePrice.get(i));
		}
		FileOutputStream out = new FileOutputStream(src);
		wb.write(out);
		wb.close();
    }
  */
}
