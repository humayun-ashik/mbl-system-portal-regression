package com.konasl.mbl.utils;
import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SaveTestResultToExcelFile {
    FileInputStream file = new FileInputStream((new File("G:\\Automation\\qa-repo\\payment-project-automation\\" +
            "resources\\MBLRegressionTestCase-v.01.xlsx")));

    public SaveTestResultToExcelFile(int sheetIndex,String cellContent, String cellValue) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        int rowNum = findRow(sheet, cellContent);
        Row row = sheet.getRow(rowNum);
        CellStyle style = workbook.createCellStyle();
        if (cellValue=="PASS"){
            //style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        }
        else if(cellValue=="FAIL"){
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
        }
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Cell cell   = row.createCell(7);
        cell.setCellValue(cellValue);
        cell.setCellStyle(style);

        // setting foreground color

        FileOutputStream outputFile = new FileOutputStream(new File("G:\\Automation\\qa-repo\\payment-project-automation\\"  +
                "resources\\MBLRegressionTestCase-v.01.xlsx"));
        workbook.write(outputFile);
        outputFile.close();


    }


    private static int findRow(XSSFSheet sheet, String cellContent) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                        return row.getRowNum();
                    }
                }
            }
        }

        return 0;
    }



}
