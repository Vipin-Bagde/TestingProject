package com.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class {

	public String GetDataFromExcel(String SheetName, int rowindex, int columnindex) throws EncryptedDocumentException, IOException {
		FileInputStream MyFile = new FileInputStream("D:\\old desktop data\\download data\\ZerodhaCred.xlsx");
		Sheet MySheet = WorkbookFactory.create(MyFile).getSheet(SheetName);
		try {
			return MySheet.getRow(rowindex).getCell(columnindex).getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
			return (int) MySheet.getRow(rowindex).getCell(columnindex).getNumericCellValue()+"";
		}
	}
	public  void GetScreenShots()throws IOException {
		Date df = new Date();
		DateFormat dtFormat = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		String CurrentDte = dtFormat.format(df);
		File source = ((TakesScreenshot) Base_class.driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("D:\\GetScreenShots\\" + CurrentDte + ".png");
		FileHandler.copy(source, Destination);
	}
	
}
