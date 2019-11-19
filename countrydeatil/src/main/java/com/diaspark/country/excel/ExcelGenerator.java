package com.diaspark.country.excel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.diaspark.country.entity.ScheduleEntity;


public class ExcelGenerator {
	  
	  public static ByteArrayInputStream scheduleToExcel(List<ScheduleEntity> matchSchedule) throws IOException {
	    String[] COLUMNs = {"Id", "countryName", "matchType","matchStatus" ,"date"};
	    try(
	        Workbook workbook = new XSSFWorkbook();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ){
	      CreationHelper createHelper = workbook.getCreationHelper();
	   
	      Sheet sheet = workbook.createSheet("matchSchedule");
	   
	      Font headerFont = workbook.createFont();
	      headerFont.setBold(true);
	      headerFont.setColor(IndexedColors.BLUE.getIndex());
	   
	      CellStyle headerCellStyle = workbook.createCellStyle();
	      headerCellStyle.setFont(headerFont);
	   
	      // Row for Header
	      Row headerRow = sheet.createRow(0);
	   
	      // Header
	      for (int col = 0; col < COLUMNs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(COLUMNs[col]);
	        cell.setCellStyle(headerCellStyle);
	      }
	   
	      // CellStyle for Age
	      CellStyle ageCellStyle = workbook.createCellStyle();
	      ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	   
	      int rowIdx = 1;
	      for (ScheduleEntity scheduleDAO : matchSchedule) {
	        Row row = sheet.createRow(rowIdx++);
	   
	        row.createCell(0).setCellValue(scheduleDAO.getId());
	        row.createCell(1).setCellValue(scheduleDAO.getCountryName());
	        row.createCell(2).setCellValue(scheduleDAO.getMatchType());
	        row.createCell(3).setCellValue(scheduleDAO.getResult().getMatchStatus());
	        Cell ageCell = row.createCell(4);
	        ageCell.setCellValue(scheduleDAO.getDate());
	        ageCell.setCellStyle(ageCellStyle);
	      }
	   
	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    }
	  }
	}