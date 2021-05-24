package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    public String readexcel(int row,String FilePath,int col) throws IOException {
    	File file = new File(FilePath);
    	FileInputStream fis = new FileInputStream(file);
    	XSSFWorkbook wb = new XSSFWorkbook(fis);
    	XSSFSheet sheet = wb.getSheetAt(0);
    	return String.valueOf(sheet.getRow(row).getCell(col));
    }
}
