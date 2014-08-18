package com.kingsoft.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;

import org.xml.sax.SAXException;

import com.kingsoft.handler.SheetHandler;
import com.kingsoft.parse.Parse;
import com.kingsoft.parse.SheetParse;
import com.kingsoft.parse.WorkBookParse;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;
import com.kingsoft.util.FileUtil;

import junit.framework.TestCase;

public class TestSax extends TestCase {
	public void test() {
		String filePath = "e:" + File.separator + "excelproject"
				+ File.separator + "book2.xlsx";
		WorkBook workBook = new WorkBook();

		ZipFile xlsxFile = FileUtil.unZipFile(filePath);
		InputStream stream = FileUtil.getFileInputStream(xlsxFile,
				"xl/workbook.xml");
		Parse workBookparse = new WorkBookParse(stream, workBook);
		workBookparse.handle();
		System.out.println(workBook);
		HashMap<String, Sheet> sheetsMap = workBook.getSheets();
		Iterator iter = sheetsMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Sheet> entry = (Map.Entry<String, Sheet>) iter.next();
			String key = entry.getKey();
			Sheet sheet = entry.getValue();
			SheetHandler handler = new SheetHandler(sheet);
			String path = "xl/worksheets/" + key.toLowerCase() + ".xml";
			SheetParse sheetParse = new SheetParse(FileUtil.getFileInputStream(
					xlsxFile, path), sheet);
			sheetParse.handle();

		}
	}
}
