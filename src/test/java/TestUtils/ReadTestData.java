package TestUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadTestData {
	public  static FileInputStream fis;
	public static Workbook wb;

	public static Object[] readData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		fis = new FileInputStream("E:\\Git\\BasicTest\\RestAssuredBddFramework\\TestData\\EmployessDetails.xlsx");

		wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Employee");
		Object[] data=new Object[sheet.getLastRowNum()];
		for (int row=0;row<sheet.getLastRowNum();row++) {
			data[row]=sheet.getRow(row).getCell(1).toString();
		}
		
		return data;
		

	}
	@Test
	public void dada() throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println(readData());
		
		
	}

}
