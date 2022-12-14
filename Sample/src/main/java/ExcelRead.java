import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead 
{

	public static void main(String[] args) 
	{
		try
        {
            FileInputStream file = new FileInputStream(new File("src/main/resources/ObsquraStudents.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file 
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //test
            //123
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator(); 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    
                    System.out.print(cell.getStringCellValue() + "\t");
                    
                }
                System.out.println("");
            }
            
            workbook.close();
            file.close();
          
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}

}
