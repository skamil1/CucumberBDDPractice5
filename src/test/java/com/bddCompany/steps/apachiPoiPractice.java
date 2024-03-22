package com.bddCompany.steps;

import io.cucumber.java.en.Given;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class apachiPoiPractice {
    @Given("an excel sheet with several datas to be retrieved")
    public void an_excel_sheet_with_several_datas_to_be_retrieved() throws IOException {
       String path = "src/test/resources/ExcelFiles/Job Related Excel sheet.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path); //to read the file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println(sheet.getRow(1).getCell(0));



    }
}
