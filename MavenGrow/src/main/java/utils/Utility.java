package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	    public static void captureScreenshot(WebDriver driver , int testID) throws IOException {
		
		Date date = new Date();
		
		String dateformat = date.toString().replace(" ", "-").replace(":", "-");
		
		TakesScreenshot take = (TakesScreenshot) driver;
		
		File Src = take.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("F:\\Screenshot\\testID"+"-"+testID+" "+dateformat+".jpeg");
		
		FileHandler.copy(Src, dest);
	
	}
	
	public static void fetchDataFromExelSheet() throws IOException {
		
		String path = "C:\\Users\\Amol\\Desktop\\Test.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Workbook workbook = WorkbookFactory.create(file);
		
		try {
			String userName = workbook.getSheet("Amol").getRow(0).getCell(1).getStringCellValue();
		}
		catch(IllegalStateException e){
			double password = workbook.getSheet("Amol").getRow(0).getCell(1).getNumericCellValue();
		}
	}
}

