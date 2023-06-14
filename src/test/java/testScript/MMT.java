package testScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MMT {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis = new FileInputStream("C:\\Users\\abhishek.birana\\eclipse-workspace\\DemoAutomation\\data\\MakeMyTrip.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	System.out.println(wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue());
	
	
	
}
}
