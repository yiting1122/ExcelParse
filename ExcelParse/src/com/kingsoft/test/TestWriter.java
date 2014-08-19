package com.kingsoft.test;

import java.io.File;
import java.io.IOException;

import com.kingsoft.io.SheetDataWriter;
import com.kingsoft.parse.ParseFacade;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;

import junit.framework.TestCase;

public class TestWriter extends TestCase{
	
	public WorkBook getWorkBook(){
		String filePath = "e:" + File.separator + "excelproject"+ File.separator + "book4.xlsx";
		ParseFacade facade=new ParseFacade(filePath);
		WorkBook workBook=facade.parse();
		facade.close();
		return workBook;
	}
	
	public void testWriter() throws IOException{
		String filePath = "e:" + File.separator + "excelproject"+ File.separator;
		WorkBook book=getWorkBook();
		
		Sheet sheet=book.getSheet("rId2");
		System.out.println(sheet.getRowMap().size());
		
		SheetDataWriter out=new SheetDataWriter(filePath+"testwrite.xml", filePath+"sharedString.xml");
		out.writeSheet(sheet);
		out.close();
	}
	
	
	
	
	
}
