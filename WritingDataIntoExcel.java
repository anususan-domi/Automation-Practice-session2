package day30;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet();
		
		// Craeting rows & cells then updating data
		/*
		//First row
		XSSFRow row1=sheet.createRow(0);
		
		row1.createCell(0).setCellValue("welcome");
		row1.createCell(1).setCellValue(123);
		row1.createCell(2).setCellValue("Java");

		
		//second row
		XSSFRow row2=sheet.createRow(1);
				
		row2.createCell(0).setCellValue("abc");
		row2.createCell(1).setCellValue("xyz");
		row2.createCell(2).setCellValue("13444");
	*/
		
		//creating rows & cells and update data using loop
		Scanner sc=new Scanner(System.in);
		
		
		for(int r=0;r<=3;r++)
		{
			XSSFRow currentRow=sheet.createRow(r);
			
			for(int c=0;c<2;c++)
			{
				//currentRow.createCell(c).setCellValue("welcome");
				System.out.println("Enter a value:");
				String value=sc.next();
				currentRow.createCell(c).setCellValue(value);
			}
		}		
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		
				
		
		System.out.println("Done!!!");
	}

}
