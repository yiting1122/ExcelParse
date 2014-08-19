package com.kingsoft.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipFile;

import org.xml.sax.SAXException;

import com.carrotsearch.hppc.ObjectArrayList;
import com.kingsoft.handler.SheetHandler;
import com.kingsoft.parse.Parse;
import com.kingsoft.parse.ParseFacade;
import com.kingsoft.parse.SheetParse;
import com.kingsoft.parse.StringValueParse;
import com.kingsoft.parse.WorkBookParse;
import com.kingsoft.parse.WorkBookPropertyParse;
import com.kingsoft.stream.Cell;
import com.kingsoft.stream.Row;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;
import com.kingsoft.util.FileUtil;
import com.kingsoft.util.RegxConvertor;
import com.kingsoft.value.StringValue;
import com.kingsoft.value.ValueType;

import junit.framework.TestCase;


public class TestWorkBook extends TestCase {
	
	
	public WorkBook getWorkBook(){
		String filePath = "e:" + File.separator + "excelproject"+ File.separator +"testxlsx.xlsx";
		ParseFacade facade=new ParseFacade(filePath);
		WorkBook workBook=facade.parse();
		facade.close();
		return workBook;
	}
	
	public void getCellList(WorkBook workBook){
		HashMap<String, Sheet> sheetsMap = workBook.getSheets();
		Iterator iter = sheetsMap.keySet().iterator();
		while (iter.hasNext()) {
			Sheet sheet=sheetsMap.get(iter.next());
			
//			HashMap<String, Integer> styleTable=sheet.getStyleTable();
//			Iterator styleIterator=styleTable.entrySet().iterator();
//			while(styleIterator.hasNext()){
//				System.out.println(styleIterator.next()+"");
//			}
			
			System.out.println(sheet.toString());
			String sheetName=sheet.getName();
			TreeMap<Integer, Row> rowMap=sheet.getRowMap();
			Iterator rowiIterator = rowMap.keySet().iterator();
			while (rowiIterator.hasNext()) {
				int rowNum=(Integer) rowiIterator.next();
				Row row=rowMap.get(rowNum);
				ObjectArrayList<Cell> cells=row.getCellsList();
				for(int i=0;i<cells.size();i++){
					Cell c=cells.get(i);
					System.out.println("sheet Name:"+sheetName+" row number:"+rowNum+" cell content :"+c);
				}
			}
		}
	}

	
	/**
	 * ����workbook�Ƿ������ȷ
	 */
	public void testParse() {
		long time=System.currentTimeMillis();
		WorkBook workBook=getWorkBook();
		System.out.println("耗时"+(System.currentTimeMillis()-time)+"ms");
		System.out.println(workBook);
//		getCellList(workBook);
	}
	
	
	
	/**
	 * ����ͨ�����кŻ�ȡ��Ԫ��
	 */
//	public void testGetCell(){
//		WorkBook workBook=getWorkBook();
//		Sheet sheet=workBook.getSheet("rId2");
//		
//		int rowNum=16;
//		short column=2;
//		
//		Cell cell=sheet.getCell(rowNum, column);
//		System.out.println(cell);
//	}
//	

	
}
