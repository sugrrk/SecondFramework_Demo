package com.wbl1.util1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper1 {
    //to create object for log4j by calling logManager and method called getLogger.
    private static Logger log = LogManager.getLogger(ExcelHelper1.class);
    //here we are creating a method where it will return two dimensional objects.
    public static Object[][] getExcelData1(String fileName, String sheetName) {
        Object[][] data = null;
        XSSFWorkbook wb = null;// creating workbook object
        try {
            wb = new XSSFWorkbook(Constants1.RESOURCES_PATH + "/tests-data1/" + fileName);//giving the path.
            XSSFSheet sheet = wb.getSheet(sheetName);//after workbook we are going to get access for sheet.
            int rowsIndex = sheet.getLastRowNum();//here we are going to get how many rows.
            log.info("total rows:" + rowsIndex);
            data = new Object[rowsIndex][];
            for (int i = 1; i <= rowsIndex; i++) {//we start from 1 as index 0 will have headings.
                XSSFRow row = sheet.getRow(i);
                int cols = row.getLastCellNum();//getting number of columns
                log.info("total cols:" + cols);
                Object[] colData = new Object[cols];
                for (int j = 0; j < cols; j++) {
                    colData[j] = row.getCell(j).toString();// we are trying to get access to cell Data

                }
                data[i - 1] = colData;
            }
        } catch (IOException e) {
            log.error("ExcelHelper exception:"+ e);

        } finally {
            try {
                wb.close();
            } catch (IOException e) {
                log.error(e);
            }

        }
        return data;
    }
}
