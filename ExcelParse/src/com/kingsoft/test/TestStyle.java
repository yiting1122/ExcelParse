package com.kingsoft.test;

import java.io.File;

import com.kingsoft.parse.ParseFacade;
import com.kingsoft.stream.SheetStyle;


import junit.framework.TestCase;

public class TestStyle extends TestCase {
	
	public void testParseStyle(){
		String filePath = "e:" + File.separator + "excelproject"+ File.separator + "testxlsx.xlsx";
		ParseFacade facade=new ParseFacade(filePath);
		SheetStyle style=facade.parseStyle();
		System.out.println(style);
		style.printNumFormats();
		style.printFonts();
		style.printCellFills();
		style.printCellCellBorders();
		style.printCellStyleXfs();
		style.printCellXFs();
		style.printCellStyles();
		
		facade.close();
	}
}
