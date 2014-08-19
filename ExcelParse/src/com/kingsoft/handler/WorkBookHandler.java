package com.kingsoft.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingsoft.log.ExcelLogger;
import com.kingsoft.log.ExcelLoggerTest;
import com.kingsoft.stream.Sheet;
import com.kingsoft.stream.WorkBook;

public class WorkBookHandler extends DefaultHandler {

	private static final String WORKBOOKVIEW = "workbookView";
	private static final String SHEET = "sheet";
	private static final String CALCPR = "calcPr";
	private static final String CALCID="calcId";
	private static final String NAME = "name";
	private static final String RID = "r:id";
	private static final String SHEETID = "sheetId";
	private static final String ACTIVETAB = "activeTab";
	private static final String WINDOWHEIGHT = "windowHeight";
	private static final String WINDOWWIDTH = "windowWidth";
	private static final String XWINDOW = "xWindow";
	private static final String YWINDOW = "yWindow";
	/**
	 * 
	 */

	private WorkBook workBook;
	private Sheet sheet;
	private ExcelLogger logger = (ExcelLogger) ExcelLogger
			.getLogger("com.kingsoft");

	public WorkBookHandler(WorkBook workBook) {
		super();
		this.workBook = workBook;
	}

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) {
	}

	@Override
	public void endPrefixMapping(String prefix) {
	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String fullName, Attributes attributes) throws SAXException {
		if (SHEET.equals(fullName)) {
			String sheetRId = null;
			sheet = new Sheet();
			sheet.setName(attributes.getValue(NAME));
			sheet.setSheetId(attributes.getValue(SHEETID));
			sheetRId = attributes.getValue(RID);
			sheet.setRid(sheetRId);
			if (sheetRId != null) {
				sheet.setWorkBook(workBook);
				workBook.addSheet(sheetRId, sheet);
			}

		} else if (WORKBOOKVIEW.equals(fullName)) {
			if(attributes.getValue(ACTIVETAB)!=null){
			workBook.setActiveTab(Byte.parseByte(attributes.getValue(ACTIVETAB)));
			}
			if(attributes.getValue(WINDOWHEIGHT)!=null){
			workBook.setWindowHeight(Integer.parseInt(attributes
					.getValue(WINDOWHEIGHT)));
			}
			if(attributes.getValue(WINDOWWIDTH)!=null){
			workBook.setWindowWidth(Integer.parseInt(attributes
					.getValue(WINDOWWIDTH)));
			}
			if(attributes.getValue(YWINDOW)!=null){
			workBook.setyWindow(Integer.parseInt(attributes.getValue(YWINDOW)));
			}
			if(attributes.getValue(XWINDOW)!=null){
			workBook.setxWindow(Integer.parseInt(attributes.getValue(XWINDOW)));
			}

		} else if (CALCPR.equals(fullName)) {
			workBook.setCalcId(Integer.parseInt(attributes.getValue(CALCID)));
		}

	}

	@Override
	public void endElement(String namespaceURI, String localName,
			String fullName) throws SAXException {
	}

	@Override
	public void characters(char[] chars, int start, int length)
			throws SAXException {

	}

	@Override
	public void warning(SAXParseException exception) {

		System.out.println("*******WARNING******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.warn(WorkBookHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("******* ERROR ******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.error(WorkBookHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("******** FATAL ERROR ********");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("*****************************");
		logger.error(WorkBookHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}
}
