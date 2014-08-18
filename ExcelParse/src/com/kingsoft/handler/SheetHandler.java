package com.kingsoft.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingsoft.log.ExcelLogger;
import com.kingsoft.log.ExcelLoggerTest;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;

public class SheetHandler extends DefaultHandler {
	private StringBuffer buf;
	private WorkBook workBook;
	private Sheet sheet;
	private String sheetName;
	private ExcelLogger logger= (ExcelLogger) ExcelLogger.getLogger("com.kingsoft");
	
	
	public SheetHandler(Sheet sheet) {
		super();
		this.sheet = sheet;
	}

	public void startDocument() throws SAXException {
		System.out.println("*******开始解析文档*******");
	}

	public void endDocument() throws SAXException {
		System.out.println("*******解析文档结束*******");
	}

	public void startPrefixMapping(String prefix, String uri) {
		System.out.println("\n前缀映射: " + prefix + " 开始!" + "  它的URI是:" + uri);
	}

	public void endPrefixMapping(String prefix) {
		System.out.println("\n前缀映射: " + prefix + " 结束!");
	}

	public void startElement(String namespaceURI, String localName,
			String fullName, Attributes attributes) throws SAXException {
		System.out.println("\n元素: " + "[" + fullName + "]" + " 开始解析!");
		if("sheet".equals(fullName.toLowerCase())){	
			sheet=new Sheet();
		}
		// 打印出属性信息
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.println("\t属性名称:" + attributes.getLocalName(i) + " 属性值:"
					+ attributes.getValue(i));
			
			
		}
		

	}

	public void endElement(String namespaceURI, String localName,
			String fullName) throws SAXException {
		// 打印元素解析结束信息
		System.out.println("元素: " + "[" + fullName + "]" + " 解析结束!");
	
	}

	public void characters(char[] chars, int start, int length)
			throws SAXException {
		
	}

	public void warning(SAXParseException exception) {
		
		System.out.println("*******WARNING******");
		System.out.println("\t行:\t" + exception.getLineNumber());
		System.out.println("\t列:\t" + exception.getColumnNumber());
		System.out.println("\t错误信息:\t" + exception.getMessage());
		System.out.println("********************");
		logger.warn(SheetHandler.class.getName(), exception.getLineNumber()+exception.getMessage());	
	}

	public void error(SAXParseException exception) throws SAXException {
		System.out.println("******* ERROR ******");
		System.out.println("\t行:\t" + exception.getLineNumber());
		System.out.println("\t列:\t" + exception.getColumnNumber());
		System.out.println("\t错误信息:\t" + exception.getMessage());
		System.out.println("********************");
		logger.error(SheetHandler.class.getName(), exception.getLineNumber()+exception.getMessage());	
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("******** FATAL ERROR ********");
		System.out.println("\t行:\t" + exception.getLineNumber());
		System.out.println("\t列:\t" + exception.getColumnNumber());
		System.out.println("\t错误信息:\t" + exception.getMessage());
		System.out.println("*****************************");
		logger.error(SheetHandler.class.getName(), exception.getLineNumber()+exception.getMessage());	
	}
}
