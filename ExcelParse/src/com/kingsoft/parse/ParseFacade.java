package com.kingsoft.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipFile;

import com.kingsoft.log.ExcelLogger;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.SheetStyle;
import com.kingsoft.stream.WorkBook;
import com.kingsoft.util.FileUtil;

@SuppressWarnings("unchecked")
public class ParseFacade {
	
	private ZipFile xlsxFile ;
	private ExcelLogger logger = (ExcelLogger) ExcelLogger.getLogger("com.kingsoft");
	public ParseFacade(String filePath){
		xlsxFile = FileUtil.unZipFile(filePath);
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public WorkBook parse(){
		WorkBook workBook = new WorkBook();
		InputStream stream = FileUtil.getFileInputStream(xlsxFile,"xl/workbook.xml");
		Parse workBookparse = new WorkBookParse(stream, workBook);
		workBookparse.handle();

		Parse workbookProertyParse = new WorkBookPropertyParse(FileUtil.getFileInputStream(xlsxFile,"xl/_rels/workbook.xml.rels"), workBook);
		workbookProertyParse.handle();

		HashMap<String, Sheet> sheetsMap = workBook.getSheets();
		Iterator iter = sheetsMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Sheet> entry = (Map.Entry<String, Sheet>) iter.next();
			String key = entry.getKey();
			Sheet sheet = entry.getValue();
			String path = "xl/" + workBook.getTargets().get(key);
			SheetParse sheetParse = new SheetParse(FileUtil.getFileInputStream(xlsxFile, path), sheet);
			sheetParse.handle();
			sheetsMap.put(key, sheet);
			
		}

		StringValueParse valueParse=new StringValueParse(FileUtil.getFileInputStream(xlsxFile, "xl/sharedStrings.xml"),workBook);
		valueParse.handle();
		
//		workBook.setSheetStyle(parseStyle());
		
		return workBook;
	}
	
	
	public SheetStyle parseStyle(){
		SheetStyle style=new SheetStyle();
		InputStream stream = FileUtil.getFileInputStream(xlsxFile,"xl/styles.xml");
		Parse styleParse=new SheetStyleParse(stream, style);
		styleParse.handle();
		return style;
	}
	
	public boolean close(){
		boolean ret=true;
		try {
			xlsxFile.close();
		} catch (IOException e) {
			ret=false;
			logger.error(ParseFacade.class.getName(),"文件关闭错误"+e.getMessage());
		}
		return ret;
	}
	
	
}
