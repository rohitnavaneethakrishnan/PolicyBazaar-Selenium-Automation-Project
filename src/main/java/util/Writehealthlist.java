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

import Pages.HealthInsurance;

public class Writehealthlist extends HealthInsurance{
	 public Writehealthlist() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
    @Test
	public void healthlist() throws IOException {
		   String userDir = System.getProperty("user.dir");
	  	    String filePath = userDir + "\\src\\test\\java\\resources\\Healthlist.xlsx";
	   	File src = new File(filePath);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet("travelinsuranceprice");
			
			int size = healthlist.size();
		   int 	rownum =0;
			for(int i=0;i<size;i++) {
			Row row =sheet.createRow(rownum++);
			row.createCell(0).setCellValue(healthlist.get(i));
			}
			FileOutputStream out = new FileOutputStream(src);
			wb.write(out);
			wb.close();
	   }

}
