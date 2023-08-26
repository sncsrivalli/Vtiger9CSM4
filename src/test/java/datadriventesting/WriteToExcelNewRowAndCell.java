package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcelNewRowAndCell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1: Convert physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

		// Step 2: Open Workbook
		Workbook workbook = WorkbookFactory.create(fis);

		// Step 3: Get control over sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		
		// Step 4: Create new Row
		Row row = sheet.createRow(4);
		
		//Step 5: Create new Cell
		Cell cell = row.createCell(0);
		
		//Step 6: Set data into cell
		cell.setCellValue("username2");
		
		//Step 7: Save data to excel
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		workbook.write(fos);
		
		//Step 8: close workbook
		workbook.close();

	}

}
