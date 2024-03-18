package Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ValueReader {
   //initiating FileInputStream
   FileInputStream fis = null;

    // Setting the file path using system property
   String filepath = System.getProperty("user.dir") + "/src/test/java/Data/searchValue.xlsx";

    // Method to get FileInputStream
    public FileInputStream getFileInputStream() {
        try {
            fis = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found !! :" + e.getMessage());
            System.exit(0);
        }
        return fis;
    }

    // Method to read Excel data
    public Object[][] getExcelData() throws IOException {
        FileInputStream fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheetAt(0);

        int totalNumberOfRows = sheet.getPhysicalNumberOfRows();
        int totalNumberOfCols = 1;

        Object[][] arraysExcelData = new Object[totalNumberOfRows][totalNumberOfCols];

        //iterating over rows
        for (int i = 0; i < totalNumberOfRows; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            arraysExcelData[i][0] = cell.toString();
        }

        wb.close();
        fis.close(); // Close the FileInputStream

        return arraysExcelData;
    }
}
