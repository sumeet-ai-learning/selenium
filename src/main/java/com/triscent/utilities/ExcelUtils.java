/*
package com.triscent.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;

    private static FileInputStream excelFile;
    private static String filePath;

    public static Object[][] readExcelData(String fileName, String sheetName) throws Exception {
        if(!fileName.endsWith(".xlsx")){

        }
        String[][] arrayExcelData = null;
        String workingDir = System.getProperty("user.dir");
        filePath = workingDir + File.separator + "src" + File.separator + "main" + File.separator + "resources"
                + File.separator + fileName;
        excelFile = new FileInputStream(filePath);
        ExcelWBook = new XSSFWorkbook(excelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        int rowNumber = ExcelWSheet.getLastRowNum();
        int colNumber = ExcelWSheet.getRow(0).getLastCellNum() - 1;
        arrayExcelData = new String[rowNumber][colNumber];

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arrayExcelData[i][j] = ExcelWSheet.getRow(i + 1).getCell(j + 1).getStringCellValue();
            }
        }
        return arrayExcelData;
    }
}*/
