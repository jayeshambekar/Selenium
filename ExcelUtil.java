package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getDataFromExcel(String sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException, IOException {
		
		//Step1:Create Object of FileInputStream class & in FileInputStream constructor enter the path/location  of the extrenal file
				FileInputStream fis = new FileInputStream("src/test/resources/Data.xlsx");
				
				//Step2:Call WokrbookFactory class from Apache poi & Call create (InputSteam)
				Workbook wb = WorkbookFactory.create(fis);	
				
				//Step3:Call getSheet(String name) & Enter sheet name
//				Sheet sh = wb.getSheet("Organizations");
				//Sheet sh = wb.getSheet("Contact");
				Sheet sh = wb.getSheet("Leads");
				
				//Step4:Call getRow(int num) & Enter the row number
				Row rw = sh.getRow(Rownum);
				
				//Step5:Call getCell(int cell)
				Cell cl = rw.getCell(Cellnum);
				
				//Step6:Call getStringCellValue()
				String value = cl.getStringCellValue();
				return value;

	}

}
