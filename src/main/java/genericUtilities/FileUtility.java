package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class consists of generic methods related to file operations
 */
public class FileUtility {

	/*
	 * This method will reaf data from property file and return the value to caller
	 *  
	 *  @param key
	 *  @return value
	 *  @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/src/test/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	/*
	 * This method will read data from excel file and return the value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param colNo
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetname,int rowNo, int colNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("/home/cm_geeta/AutomationTesting/Practice2024/AutomationFramework/src/test/resources/ProductData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(colNo);
		String value = cell.getStringCellValue();
		return value;
	}
	
}
